package net.kunmc.lab.kanjiquiz.util;

import org.bukkit.Bukkit;
import org.bukkit.Sound;

public class SoundUtil {
    /**
     * 全体に音を鳴らす
     * */
    public static void playSoundAll(Sound sound) {
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.playSound(player.getEyeLocation(), sound, 0.4f, 1f);
        });
    }
}
