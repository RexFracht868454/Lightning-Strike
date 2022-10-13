package com.rexfracht868454.plugin.command;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParamType;
import cn.nukkit.command.data.CommandParameter;
import cn.nukkit.entity.weather.EntityLightning;
import cn.nukkit.level.Position;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.nbt.tag.DoubleTag;
import cn.nukkit.nbt.tag.FloatTag;
import cn.nukkit.nbt.tag.ListTag;

public class LightningCommand extends Command {

    public LightningCommand(String name) {
        super(name);
        setUsage("/lightning or /lightning <target>");
        commandParameters.clear();
        commandParameters.put("player", new CommandParameter[]{CommandParameter.newType("player", CommandParamType.TARGET)});
        commandParameters.put("all", new CommandParameter[]{CommandParameter.newType("all", CommandParamType.TARGET)});
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.hasPermission("lightning.command.cmd")) {
                if (args.length == 1) {
                    String target = args[0];
                    Player targetPlayer = Server.getInstance().getPlayer(target);
                    if (target.equalsIgnoreCase("all")) {
                        int playerCount = 0;
                        for (Player all: Server.getInstance().getOnlinePlayers().values()) {
                            if (!all.hasPermission("lightning.bypass.cmd")) {
                                Position allPosition = all.getLocation();
                                strikeLighting(allPosition);
                                playerCount++;
                            }
                            commandSender.sendMessage("§aLightning spawned successfully on:§7 " + playerCount + "§a players");
                        }
                    }else {
                        if (targetPlayer != null) {
                            Position position = targetPlayer.getLocation();
                            if (!targetPlayer.hasPermission("lightning.bypass.cmd")) {
                                strikeLighting(position);
                                player.sendMessage("§aLightning spawned successfully on:§e " + targetPlayer.getName());
                            } else {
                                player.sendMessage("§cYou can not summon a lightning on:§e " + targetPlayer.getName());
                            }
                        } else {
                            player.sendMessage("§cThis player is not online!");
                        }
                    }
                } else {
                    Position position = player.getTargetBlock(120);
                    strikeLighting(position);
                    player.sendMessage("§aLightning spawned successfully");
                }
            }
        } else {
            commandSender.sendMessage("§cYou must be a online player to use this command!");
        }
        return false;
    }

    private void strikeLighting(Position pos) {
        FullChunk chunk = pos.getLevel().getChunk((int) pos.getX() >> 4, (int) pos.getZ() >> 4);
        CompoundTag nbt = new CompoundTag()
                .putList(new ListTag<DoubleTag>("Pos")
                        .add(new DoubleTag("", pos.getX()))
                        .add(new DoubleTag("", pos.getY()))
                        .add(new DoubleTag("", pos.getZ())))
                .putList(new ListTag<DoubleTag>("Motion")
                        .add(new DoubleTag("", 0))
                        .add(new DoubleTag("", 0))
                        .add(new DoubleTag("", 0)))
                .putList(new ListTag<FloatTag>("Rotation")
                        .add(new FloatTag("", 0))
                        .add(new FloatTag("", 0)));
        EntityLightning lightning = new EntityLightning(chunk, nbt);
        lightning.spawnToAll();
    }
}
