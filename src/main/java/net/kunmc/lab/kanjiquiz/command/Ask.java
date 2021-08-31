package net.kunmc.lab.kanjiquiz.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Ask extends Command {
    public Ask() {
        super("ask");

    }

    @Override
    public void execute(@NotNull CommandContext ctx) {
        List<Object> args = ctx.getTypedArgs();
    }
}
