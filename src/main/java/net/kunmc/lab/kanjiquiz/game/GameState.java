package net.kunmc.lab.kanjiquiz.game;

import net.kunmc.lab.kanjiquiz.command.CommandFeedback;

public interface GameState {
    GameState next();

    void display();

    CommandFeedback execute();
}
