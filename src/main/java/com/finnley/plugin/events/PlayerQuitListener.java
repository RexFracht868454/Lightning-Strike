package com.finnley.plugin.events;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import com.finnley.plugin.Main;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onPlayerJoin(cn.nukkit.event.player.PlayerQuitEvent event) {
        Main.strikeLightning(event.getPlayer());
    }
}
