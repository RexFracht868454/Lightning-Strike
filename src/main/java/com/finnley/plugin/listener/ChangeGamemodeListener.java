package com.finnley.plugin.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerGameModeChangeEvent;
import com.finnley.plugin.Main;

public class ChangeGamemodeListener implements Listener {

    Main plugin;

    public ChangeGamemodeListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onXpChange(PlayerGameModeChangeEvent event) {

        if (plugin.onChangeGamemode) {
            Main.strikeLightning(event.getPlayer());
        }
    }
}
