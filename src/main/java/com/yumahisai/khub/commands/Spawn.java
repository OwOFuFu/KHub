package com.yumahisai.khub.commands;

import com.yumahisai.khub.Main;
import com.yumahisai.khub.utils.Format;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Spawn Created 4/18/2022
 * By YumaHisai at 3:01 PM
 */

public class Spawn implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            return true;
        }

        Player player = (Player) sender;

        if(command.getName().equals("spawn")){
            if(args.length == 0){
                if(player.hasPermission("khub.commands.spawn")){
                    if(Main.getInstance().getConfig().getString("Spawn.world").equals(null)){
                        player.sendMessage(Format.color("&cSpawn non settato, contatta un amministratore."));
                    } else {
                        Location spawn = new Location(
                                Bukkit.getWorld(Main.getInstance().getConfig().getString("Spawn.world")),
                                Main.getInstance().getConfig().getDouble("Spawn.x"),
                                Main.getInstance().getConfig().getDouble("Spawn.y"),
                                Main.getInstance().getConfig().getDouble("Spawn.z"),
                                (float) Main.getInstance().getConfig().getDouble("Spawn.pitch"),
                                (float) Main.getInstance().getConfig().getDouble("Spawn.yaw")
                        );
                        player.teleport(spawn);
                        player.sendMessage(Format.color("&aHai raggiunto lo spawn..."));
                    }
                }
            }
            if(args.length >= 1){
                if(args[0].equals("set")){
                    if(player.hasPermission("khub.commands.spawn.set")){
                        Main.getInstance().getConfig().set("Spawn.world", player.getWorld().getName());
                        Main.getInstance().getConfig().set("Spawn.x", player.getLocation().getBlockX());
                        Main.getInstance().getConfig().set("Spawn.y", player.getLocation().getBlockY());
                        Main.getInstance().getConfig().set("Spawn.z", player.getLocation().getBlockZ());
                        Main.getInstance().getConfig().set("Spawn.pitch", player.getLocation().getPitch());
                        Main.getInstance().getConfig().set("Spawn.yaw", player.getLocation().getYaw());
                        Main.getInstance().saveConfig();
                    }
                }
            }
        }
        return false;
    }
}
