package net.kunmc.lab.kanjiquiz.command.config;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;

import java.lang.reflect.Field;

public class Show extends Command {
    public Show() {
        super("show");
    }

    @Override
    public void execute(CommandContext ctx) {
        try {
            for (Field field : ConfigManager.class.getDeclaredFields()) {
                ctx.success(field.getName() + ": " + field.get(null));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
