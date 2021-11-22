package net.kunmc.lab.kanjiquiz.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import net.kunmc.lab.kanjiquiz.game.GameManager;
import org.jetbrains.annotations.NotNull;

public class Next extends Command {
    public Next() {
        super("next");
    }

    @Override
    public void execute(@NotNull CommandContext ctx) {
        CommandFeedback feedback = GameManager.next();

        CommonLogic.feedback(ctx, feedback);
    }
}
