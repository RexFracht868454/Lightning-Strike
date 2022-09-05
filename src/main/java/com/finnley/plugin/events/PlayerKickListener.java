package com.finnley.plugin.events;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerKickEvent;
import com.finnley.plugin.Main;

public class PlayerKickListener implements Listener {

    Main plugin;

    public PlayerKickListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onKick(PlayerKickEvent event) {

        if (plugin.onKick) {
            Main.strikeLightning(event.getPlayer());
        }
    }
}
