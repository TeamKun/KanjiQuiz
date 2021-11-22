package net.kunmc.lab.kanjiquiz.command;

import dev.kotx.flylib.command.Command;

public class Kanji extends Command {
    public Kanji() {
        super("kanji");

        children(new Start(), new Stop(), new Next());
    }
}
