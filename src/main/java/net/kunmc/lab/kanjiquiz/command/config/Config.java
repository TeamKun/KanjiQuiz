package net.kunmc.lab.kanjiquiz.command.config;

import dev.kotx.flylib.command.Command;

public class Config extends Command {
    public Config() {
        super("config");

        children(new Set(), new Show());
    }
}
