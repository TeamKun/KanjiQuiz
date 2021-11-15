package net.kunmc.lab.kanjiquiz.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import dev.kotx.flylib.command.Permission;
import dev.kotx.flylib.command.arguments.TextArgument;
import net.kunmc.lab.kanjiquiz.game.GameManager;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public class Answer extends Command {
    public Answer() {
        super("a");
        this.permission(Permission.getEVERYONE());

        usage(usageBuilder -> {
        usageBuilder.textArgument("[よみ]", TextArgument.Type.PHRASE);
        });
    }

    @Override
    public void execute(@NotNull CommandContext ctx) {
        Player player = ctx.getPlayer();
        String answer = ctx.getTypedArgs().get(0).toString();

        // ひらがなチェック
        Pattern pattern = Pattern.compile("^[\u3040-\u309F]+$");
        if (!pattern.matcher(answer).matches()) {
            ctx.fail("エラー:ひらがなで回答してください");
            return;
        }

        CommandFeedback feedback = GameManager.answer(answer, player);
        CommonLogic.feedback(ctx, feedback);

    }
}
