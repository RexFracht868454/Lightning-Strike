package com.finnley.plugin.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerToggleFlightEvent;
import com.finnley.plugin.Main;

public class ToggleFlightListener implements Listener {

    Main plugin;

    public ToggleFlightListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onToggleFlight(PlayerToggleFlightEvent event) {

        if (plugin.onToggleFlight) {
            Main.strikeLightningPlayer(event.getPlayer());
        }
    }
}