package com.rexfracht868454.plugin.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerRespawnEvent;
import com.rexfracht868454.plugin.Main;

public class RespawnListener implements Listener {

    Main plugin;

    public RespawnListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onRespawn(PlayerRespawnEvent event) {

        if (!event.getPlayer().hasPermission("lightning.bypass.cmd")) {
            if (plugin.onRespawn) {
                Main.strikeLightning(event.getPlayer());
            }
        }
    }
}
