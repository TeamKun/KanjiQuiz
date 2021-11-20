package net.kunmc.lab.kanjiquiz.util;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Objects;

public class MessageUtil {

    /**
     * 全員にタイトルを表示
     * */
    public static void sendTitleAll(String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendTitle(title, subtitle, fadeIn, stay, fadeOut);
        });
    }

    /**
     * タイトルをクリア
     * */
    public static void clearTitle() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendTitle("", "", 0, 0, 0);
        });
    }

    /**
     * 全員にメッセージを表示
     * */
    public static void broadcast(String message) {
        Bukkit.broadcast(Component.text(message));
    }

    /**
     * ログ出力
     * */
    public static void log(String message) {
        Bukkit.getLogger().info(message);
    }

    /**
     * プレイヤーリスト名をクリア
     * */
    public static void clearPlayerListName() {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            Player player = onlinePlayer.getPlayer();
            player.playerListName(Component.text(player.getName()));
        }
    }

    /**
     * プレイヤーリストに無回答と表示
     * */
    public static void setPlayerListNameNoAnswer() {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            Player player = onlinePlayer.getPlayer();
            player.playerListName(Component.text(player.getName() + " : 無回答"));
        }
    }
}
