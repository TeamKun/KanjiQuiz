package net.kunmc.lab.kanjiquiz.command.config;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import kotlin.Unit;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Set extends Command {
    private final List<ConfigItem> configItemList = new ArrayList<>();

    public Set() {
        super("set");

        try {
            for (Field field : ConfigManager.class.getDeclaredFields()) {
                configItemList.add(new ConfigItem(field));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        usage(builder -> {
            builder.textArgument("設定項目", suggestionBuilder -> {
                configItemList.forEach(x -> {
                    suggestionBuilder.suggest(x.name());
                });
            })
            .textArgument("値")
            .executes(ctx -> {
                run(ctx);
                return Unit.INSTANCE;
            });
        });
    }

    private void run(CommandContext ctx) {
        String itemName = ctx.getArgs().get(0);
        if (!isCollectItemName(itemName)) {
            ctx.fail(itemName + "は正しいコンフィグ名ではありません.");
            return;
        }

        String value = ctx.getArgs().get(1);
        ConfigItem configItem = configItemList.stream().filter(x -> x.name().equals(itemName)).findFirst().get();
        Object parsedValue = ArgumentType.valueOf(configItem.clazz).parse(value);

        if (parsedValue == null) {
            ctx.fail(value + "は不正な値です.");
            return;
        }

        configItem.setValue(null, parsedValue);
        ctx.success(itemName + "の値を" + parsedValue + "に設定しました.");
    }


    private boolean isCollectItemName(String itemName) {
        return configItemList.stream().anyMatch(x -> x.name().equals(itemName));
    }
}
