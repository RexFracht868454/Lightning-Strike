package com.finnley.plugin.events;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import com.finnley.plugin.Main;

public class PlayerJoinListener implements Listener {

    Main plugin;

    public PlayerJoinListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent event) {

        if (plugin.onJoin) {
            Main.strikeLightning(event.getPlayer());
        }
    }
}
