package net.kunmc.lab.kanjiquiz.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import net.kunmc.lab.kanjiquiz.game.GameManager;
import org.jetbrains.annotations.NotNull;

public class Stop extends Command {
    public Stop() {
        super("stop");
    }

    @Override
    public void execute(@NotNull CommandContext ctx) {
        CommandFeedback feedback = GameManager.stop();

        CommonLogic.feedback(ctx, feedback);
    }
}
