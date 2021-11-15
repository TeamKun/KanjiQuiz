package net.kunmc.lab.kanjiquiz.command;

import dev.kotx.flylib.command.CommandContext;

public class CommonLogic {
    static void feedback(CommandContext ctx, CommandFeedback feedback) {
        if (feedback.isSuccess()) {
            ctx.success(feedback.message());
        } else {
            ctx.fail(feedback.message());
        }
    }
}
