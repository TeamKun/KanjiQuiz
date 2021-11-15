package net.kunmc.lab.kanjiquiz.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import net.kunmc.lab.kanjiquiz.game.GameManager;
import net.kunmc.lab.kanjiquiz.quiestion.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

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
