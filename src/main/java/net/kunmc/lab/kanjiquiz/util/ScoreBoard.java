package net.kunmc.lab.kanjiquiz.util;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreBoard {
    private static Scoreboard manager;
    private static Objective score;

    public static void init() {
        manager = Bukkit.getServer().getScoreboardManager().getMainScoreboard();
        score = manager.getObjective("score");
        if (score == null) {
            score = manager.registerNewObjective("score", "dummy", Component.text("点数"));
        }
        score.setDisplaySlot(DisplaySlot.PLAYER_LIST);
    }

    public static void clear() {
        manager.clearSlot(DisplaySlot.PLAYER_LIST);
        if (score != null) {
            score.unregister();
        }
    }

    public static void addPoint(Player player) {
        Score point = score.getScore(player.getName());
        point.setScore(point.getScore() + 1);
    }
}
