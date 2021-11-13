package net.kunmc.lab.kanjiquiz.game;

import net.kunmc.lab.kanjiquiz.command.CommandFeedback;
import net.kunmc.lab.kanjiquiz.quiestion.Kanji;
import net.kunmc.lab.kanjiquiz.util.MessageUtil;

public class ResultDisplay implements GameState {

    private Kanji question;

    public ResultDisplay(Kanji question) {
        this.question = question;
    }

    @Override
    public GameState next() {
        return new AnswerReception();
    }

    @Override
    public void display() {
        MessageUtil.sendTitleAll("A." + this.question.getReading(), "", 0, 20 , 20);
    }

    @Override
    public CommandFeedback execute() {
        return new CommandFeedback(true, "次の問題を表示します");
    }
}
