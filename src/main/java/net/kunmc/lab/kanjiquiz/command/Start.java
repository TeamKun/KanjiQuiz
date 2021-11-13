package net.kunmc.lab.kanjiquiz.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import net.kunmc.lab.kanjiquiz.game.GameManager;
import net.kunmc.lab.kanjiquiz.quiestion.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Start extends Command {
    public Start() {
        super("start");
        usage(usageBuilder -> {
            usageBuilder.textArgument("level", suggestionBuilder -> {
                for (Level value : Level.values()) {
                    suggestionBuilder.suggest(value.level());
                }
            });
        });
    }

    @Override
    public void execute(@NotNull CommandContext ctx) {
        List<Object> args = ctx.getTypedArgs();

        if (args.size() == 0) {
            ctx.fail("引数が不正です");
            return;
        }

        Level level = null;
        for (Level value : Level.values()) {
            if (value.level().equals(args.get(0))) {
                level = value;
            }
        }

        if (level == null) {
            ctx.fail("引数が不正です");
            return;
        }
        CommandFeedback feedback = GameManager.start(level);

        if (feedback.isSuccess()) {
            ctx.success(feedback.message());
        } else {
            ctx.fail(feedback.message());
        }
    }
}
