package net.kunmc.lab.kanjiquiz.game;

import net.kunmc.lab.kanjiquiz.command.CommandFeedback;
import net.kunmc.lab.kanjiquiz.quiestion.KanjiList;
import net.kunmc.lab.kanjiquiz.quiestion.Level;
import net.kunmc.lab.kanjiquiz.quiestion.Questions;

public class GameManager {
    private static GameState gameState;
    static KanjiList currentQuestions;

    public static CommandFeedback start(Level level) {
        if (gameState != null) {
            return new CommandFeedback(false, "すでにゲームが実行中です");
        }

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

    public static boolean isRunning() {
        return gameState != null;
    }

    static void display() {
        gameState.display();
    }
}
