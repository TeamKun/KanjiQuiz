package net.kunmc.lab.kanjiquiz.game;

import net.kunmc.lab.kanjiquiz.command.CommandFeedback;
import net.kunmc.lab.kanjiquiz.quiestion.Kanji;
import net.kunmc.lab.kanjiquiz.util.MessageUtil;

public class AnswerReception implements GameState {

    private Kanji currentQuestion;

    public AnswerReception() {
        this.currentQuestion = GameManager.currentQuestions.getQuestion();
    }

    @Override
    public GameState next() {
        return new ResultDisplay(this.currentQuestion);
    }

    @Override
    public void display() {
        MessageUtil.sendTitleAll(this.currentQuestion.getKanji(), "/a <よみ(ひらがな)> で解答", 0, 20, 20);
    }

    @Override
    public CommandFeedback execute() {
        GameManager.answerList.judge(this.currentQuestion);

        return new CommandFeedback(true, "解答を表示します");
    }
}
