package com.rexfracht868454.plugin.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerQuitEvent;
import com.rexfracht868454.plugin.Main;

public class QuitListener implements Listener {

    Main plugin;

    public QuitListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerQuitEvent event) {

        if (!event.getPlayer().hasPermission("lightning.bypass.cmd")) {
            if (plugin.onQuit) {
                Main.strikeLightning(event.getPlayer());
            }
        }
    }
}
