package com.finnley.plugin.events;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import com.finnley.plugin.Main;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(cn.nukkit.event.player.PlayerDeathEvent event) {
        Main.strikeLightning(event.getEntity());
    }
}
