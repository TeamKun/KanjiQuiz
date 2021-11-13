package net.kunmc.lab.kanjiquiz.command;

import dev.kotx.flylib.command.Command;
import net.kunmc.lab.kanjiquiz.command.config.Config;

public class Kanji extends Command {
    public Kanji() {
        super("kanji");

        children(new Start(), new Stop(), new Next(), new Config());
    }
}
