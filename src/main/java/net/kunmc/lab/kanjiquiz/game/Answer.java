package net.kunmc.lab.kanjiquiz.game;

import net.kunmc.lab.kanjiquiz.quiestion.Kanji;
import net.kunmc.lab.kanjiquiz.util.DecorationConst;
import net.kunmc.lab.kanjiquiz.util.MessageUtil;
import net.kunmc.lab.kanjiquiz.util.ScoreBoard;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.entity.Player;

import java.awt.*;
import java.util.UUID;

public class Answer {
    private String answer;
    private UUID uuid;

    Answer(String answer, Player player) {
        this.answer = answer;
        this.uuid = player.getUniqueId();
    }

    UUID uuid() {
        return this.uuid;
    }

    private Player player() {
        return Bukkit.getPlayer(uuid);
    }

    String answer() {
        return answer;
    }

    void judge(Kanji kanji) {
        Player player = this.player();
        Component nameTagStr = Component.text(player.getName() + " : " + this.answer);
        if (kanji.getReading().equals(answer)) {
            // 正解
            nameTagStr = nameTagStr.color(TextColor.color(Color.LIME.asRGB()));
            ScoreBoard.addPoint(this.player());
        } else {
            // 不正解
            nameTagStr = nameTagStr.color(TextColor.color(Color.RED.asRGB()));
        }

        player.playerListName(nameTagStr);
    }

}
