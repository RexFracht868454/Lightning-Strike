package com.finnley.plugin.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerKickEvent;
import com.finnley.plugin.Main;

public class KickListener implements Listener {

    Main plugin;

    public KickListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onKick(PlayerKickEvent event) {

        if (plugin.onKick) {
            Main.strikeLightning(event.getPlayer());
        }
    }
}
