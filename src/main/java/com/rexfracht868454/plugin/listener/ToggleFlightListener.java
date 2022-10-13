package com.rexfracht868454.plugin.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerToggleFlightEvent;
import com.rexfracht868454.plugin.Main;

public class ToggleFlightListener implements Listener {

    Main plugin;

    public ToggleFlightListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onToggleFlight(PlayerToggleFlightEvent event) {

        if (!event.getPlayer().hasPermission("lightning.bypass.cmd")) {
            if (plugin.onToggleFlight) {
                Main.strikeLightning(event.getPlayer());
            }
        }
    }
}
