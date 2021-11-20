package net.kunmc.lab.kanjiquiz.game;

import net.kunmc.lab.kanjiquiz.command.CommandFeedback;
import net.kunmc.lab.kanjiquiz.quiestion.KanjiList;
import net.kunmc.lab.kanjiquiz.quiestion.Level;
import net.kunmc.lab.kanjiquiz.quiestion.Questions;
import net.kunmc.lab.kanjiquiz.util.MessageUtil;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public class GameManager {
    private static GameState gameState;
    static KanjiList currentQuestions;
    static AnswerList answerList = new AnswerList();

    public static CommandFeedback start(Level level) {
        if (gameState != null) {
            return new CommandFeedback(false, "すでにゲームが実行中です");
        }

        MessageUtil.setPlayerListNameNoAnswer();

        currentQuestions = Questions.selectLevel(level);
        gameState = new AnswerReception();

        return new CommandFeedback(true, level.value() + "の漢字テストを実施します");
    }

    public static CommandFeedback stop() {
        if (gameState == null) {
            return new CommandFeedback(false, "ゲームが開始していません");
        }

        currentQuestions = null;
        gameState = null;

        MessageUtil.clearPlayerListName();
        return new CommandFeedback(true, "テストを終了します");
    }

    public static CommandFeedback next() {
        if (gameState == null) {
            return new CommandFeedback(false, "ゲームが実行中ではありません");
        }
        CommandFeedback feedback = gameState.execute();
        gameState = gameState.next();

        return feedback;
    }

    public static CommandFeedback answer(String answer, Player player) {
        if (!(gameState instanceof AnswerReception)) {
            return new CommandFeedback(false, "現在解答を受け付けていません");
        }
        answerList.add(new Answer(answer, player));
        player.playerListName(Component.text(player.getName() + " : 回答済み"));
        return new CommandFeedback(true, "「" + answer + "」と解答しました。もう一度コマンドを打つことで解答を変更できます");
    }

    public static boolean isRunning() {
        return gameState != null;
    }

    static void display() {
        gameState.display();
    }
}
