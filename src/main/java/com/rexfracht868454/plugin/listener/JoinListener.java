package com.rexfracht868454.plugin.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import com.rexfracht868454.plugin.Main;

public class JoinListener implements Listener {

    Main plugin;

    public JoinListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent event) {

        if (!event.getPlayer().hasPermission("lightning.bypass.cmd")) {
            if (plugin.onJoin) {
                Main.strikeLightning(event.getPlayer());
            }
        }
    }
}
