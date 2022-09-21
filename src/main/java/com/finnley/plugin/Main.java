package com.finnley.plugin;

import cn.nukkit.Player;
import cn.nukkit.command.SimpleCommandMap;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.weather.EntityLightning;
import cn.nukkit.network.protocol.AddEntityPacket;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import com.finnley.plugin.command.LightningCommand;
import com.finnley.plugin.listener.*;

public class Main extends PluginBase {
    public boolean onJoin;
    public boolean onQuit;
    public boolean onDeath;
    public boolean onRespawn;
    public boolean onKick;
    public boolean onChangeGamemode;
    public boolean onToggleFlight;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        configValues();
        registerPlayerListener();
        registerMobListener();
        registerCommand();
        this.getLogger().info("§aLightning plugin enabled");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("§cLightning plugin disabled");
    }

    private void registerPlayerListener() {
        PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new JoinListener(this), this);
        pluginManager.registerEvents(new QuitListener(this), this);
        pluginManager.registerEvents(new DeathListener(this), this);
        pluginManager.registerEvents(new RespawnListener(this), this);
        pluginManager.registerEvents(new KickListener(this), this);
        pluginManager.registerEvents(new ChangeGamemodeListener(this), this);
        pluginManager.registerEvents(new ToggleFlightListener(this), this);
    }

    private void registerMobListener() {
        PluginManager pluginManager = this.getServer().getPluginManager();
    }

    private void registerCommand() {
        SimpleCommandMap commandMap = this.getServer().getCommandMap();
        commandMap.register("lightning", new LightningCommand("lightning"));
    }

    public static void strikeLightningPlayer(Player player) {
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

        for (Player pl: player.getLevel().getPlayers().values()) {
            pl.dataPacket(addEntityPacket);
        }

    }

    private void configValues() {
        onJoin = getConfig().getBoolean("onJoin", true);
        onQuit = getConfig().getBoolean("onQuit", true);
        onDeath = getConfig().getBoolean("onDeath", true);
        onRespawn = getConfig().getBoolean("onRespawn", true);
        onKick = getConfig().getBoolean("onKick", true);
        onChangeGamemode = getConfig().getBoolean("onChangeGamemode", true);
        onToggleFlight = getConfig().getBoolean("onToggleFlight", true);
    }
}