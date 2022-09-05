package com.finnley.plugin;

import cn.nukkit.Player;
import cn.nukkit.entity.weather.EntityLightning;
import cn.nukkit.network.protocol.AddEntityPacket;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import com.finnley.plugin.events.PlayerDeathListener;
import com.finnley.plugin.events.PlayerJoinListener;
import com.finnley.plugin.events.PlayerQuitListener;

public class Main extends PluginBase {

    public boolean onJoin;
    public boolean onQuit;
    public boolean onDeath;
    public boolean onRespawn;
    public boolean onKick;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        registerConfigContent();
        registerListener();
        this.getLogger().info("§aLightning plugin enabled");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("§cLightning plugin disabled");
    }

    private void registerListener() {
        final PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerJoinListener(this), this);
        pluginManager.registerEvents(new PlayerQuitListener(this), this);
        pluginManager.registerEvents(new PlayerDeathListener(this), this);
    }


    public static void strikeLightning(Player player) {
        long id = cn.nukkit.entity.Entity.entityCount++;

        AddEntityPacket addEntityPacket = new AddEntityPacket();
        addEntityPacket.entityUniqueId = id;
        addEntityPacket.entityRuntimeId = id;
        addEntityPacket.type = EntityLightning.NETWORK_ID;
        addEntityPacket.x = (float) player.getX();
        addEntityPacket.y = (float) player.getY();
        addEntityPacket.z = (float) player.getZ();
        addEntityPacket.speedX = 0.0f;
        addEntityPacket.speedY = 0.0f;
        addEntityPacket.speedZ = 0.0f;
        addEntityPacket.yaw = (float) player.getYaw();
        addEntityPacket.pitch = (float) player.getPitch();

        for (Player pl : player.getLevel().getPlayers().values()) {
            pl.dataPacket(addEntityPacket);
        }
    }

    private void registerConfigContent() {
        onJoin = getConfig().getBoolean("onJoin", true);
        onQuit = getConfig().getBoolean("onQuit", true);
        onDeath = getConfig().getBoolean("onDeath", true);
        onRespawn = getConfig().getBoolean("onRespawn", true);
        onKick = getConfig().getBoolean("onKick", true);
    }
}