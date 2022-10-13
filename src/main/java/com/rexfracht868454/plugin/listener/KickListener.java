package com.rexfracht868454.plugin.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerKickEvent;
import com.rexfracht868454.plugin.Main;

public class KickListener implements Listener {

    Main plugin;

    public KickListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onKick(PlayerKickEvent event) {

        if (!event.getPlayer().hasPermission("lightning.bypass.cmd")) {
            if (plugin.onKick) {
                Main.strikeLightning(event.getPlayer());
            }
        }
    }
}
