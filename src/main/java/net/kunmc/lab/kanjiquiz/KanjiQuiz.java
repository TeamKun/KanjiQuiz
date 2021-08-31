package net.kunmc.lab.kanjiquiz;
import dev.kotx.flylib.FlyLib;
import net.kunmc.lab.kanjiquiz.command.Answer;
import net.kunmc.lab.kanjiquiz.command.Kanji;
import org.bukkit.plugin.java.JavaPlugin;

public final class KanjiQuiz extends JavaPlugin {

    public static KanjiQuiz plugin;
    @Override
    public void onEnable() {
        plugin = this;

        // コマンド読み込み
        FlyLib.create(this, builder -> {
            builder.command(new Kanji());
            builder.command(new Answer());
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
