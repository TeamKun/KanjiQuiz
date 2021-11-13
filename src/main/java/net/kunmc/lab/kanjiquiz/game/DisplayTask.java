package net.kunmc.lab.kanjiquiz.game;

import org.bukkit.scheduler.BukkitRunnable;

public class DisplayTask extends BukkitRunnable {
    @Override
    public void run() {
        if (!GameManager.isRunning()) {
            return;
        }

        GameManager.display();
    }
}
