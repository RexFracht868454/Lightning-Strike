package com.finnley.plugin.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerQuitEvent;
import com.finnley.plugin.Main;

public class QuitListener implements Listener {

    Main plugin;

    public QuitListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerQuitEvent event) {

        if (plugin.onQuit) {
            Main.strikeLightningPlayer(event.getPlayer());
        }
    }
}
