package com.finnley.plugin.events;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerDeathEvent;
import com.finnley.plugin.Main;

public class PlayerDeathListener implements Listener {

    Main plugin;

    public PlayerDeathListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerDeath(PlayerDeathEvent event) {

        if (plugin.onDeath) {
            Main.strikeLightning(event.getEntity());
        }
    }
}
