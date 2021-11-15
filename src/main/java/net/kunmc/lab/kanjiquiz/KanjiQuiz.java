package net.kunmc.lab.kanjiquiz;
import dev.kotx.flylib.FlyLib;
import net.kunmc.lab.kanjiquiz.command.Answer;
import net.kunmc.lab.kanjiquiz.command.Kanji;
import net.kunmc.lab.kanjiquiz.game.DisplayTask;
import net.kunmc.lab.kanjiquiz.quiestion.Questions;
import net.kunmc.lab.kanjiquiz.util.MessageUtil;
import net.kunmc.lab.kanjiquiz.util.ScoreBoard;
import org.bukkit.plugin.java.JavaPlugin;

public final class KanjiQuiz extends JavaPlugin {

    public static KanjiQuiz plugin;
    @Override
    public void onEnable() {
        plugin = this;

        Questions.init();
        // コマンド読み込み
        FlyLib.create(this, builder -> {
            builder.command(new Kanji());
            builder.command(new Answer());
        });

        new DisplayTask().runTaskTimerAsynchronously(this, 0, 1);
        ScoreBoard.init();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        ScoreBoard.clear();
        MessageUtil.clearPlayerListName();
    }
}
