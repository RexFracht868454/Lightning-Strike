package com.finnley.plugin.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerRespawnEvent;
import com.finnley.plugin.Main;

public class RespawnListener implements Listener {

    Main plugin;

    public RespawnListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onRespawn(PlayerRespawnEvent event) {

        if (plugin.onRespawn) {
            Main.strikeLightningPlayer(event.getPlayer());
        }
    }
}
