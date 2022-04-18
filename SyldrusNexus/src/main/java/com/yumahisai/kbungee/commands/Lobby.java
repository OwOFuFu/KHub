package com.yumahisai.kbungee.commands;

import com.yumahisai.kbungee.utils.Format;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Lobby extends Command {

    public Lobby(String name, String permission, String... aliases) {
        super("lobby", "khub.command.lobby", "l", "hub");
    }

    ServerInfo mainlobby = ProxyServer.getInstance().getServerInfo("hub");
    ServerInfo survival = ProxyServer.getInstance().getServerInfo("survival");
    ServerInfo skyblock = ProxyServer.getInstance().getServerInfo("skyblock");
    ServerInfo championships = ProxyServer.getInstance().getServerInfo("championships");
    ServerInfo bedwars = ProxyServer.getInstance().getServerInfo("bedwars");
    ServerInfo limbo = ProxyServer.getInstance().getServerInfo("limbo");

    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer player = (ProxiedPlayer) sender;

        if(args.length == 0){
            if(player.hasPermission("khub.lobby.connect")){
                player.connect(mainlobby);
            } else {
                player.sendMessage(Format.color("&cNon hai l'autorizzazione per eseguire questo comando, nel caso pensi che sia un errore contatta un amministratore."));
            }
        }
        if(args.length >= 1){
            switch (args[0].toLowerCase()) {
                case "survival":
                case "sv":
                    if(player.hasPermission("khub.survival.connect")){
                        player.connect(survival);
                    } else {
                        player.sendMessage(Format.color("&cNon hai l'autorizzazione per eseguire questo comando, nel caso pensi che sia un errore contatta un amministratore."));
                    }
                    break;
                case "skyblock":
                case "sb":
                    if(player.hasPermission("khub.skyblock.connect")){
                        player.connect(skyblock);
                    } else {
                        player.sendMessage(Format.color("&cNon hai l'autorizzazione per eseguire questo comando, nel caso pensi che sia un errore contatta un amministratore."));
                    }
                    break;
                case "championships":
                case "ships":
                    if(player.hasPermission("khub.championships.connect")){
                        player.connect(championships);
                    } else {
                        player.sendMessage(Format.color("&cNon hai l'autorizzazione per eseguire questo comando, nel caso pensi che sia un errore contatta un amministratore."));
                    }
                    break;
                case "bedwars":
                case "bw":
                    if(player.hasPermission("khub.bedwars.connect")){
                        player.connect(bedwars);
                    } else {
                        player.sendMessage(Format.color("&cNon hai l'autorizzazione per eseguire questo comando, nel caso pensi che sia un errore contatta un amministratore."));
                    }
                    break;
                case "limbo-pts1":
                    if(player.hasPermission("khub.limbo.connect")){
                        player.connect(limbo);
                    } else {
                        player.sendMessage(Format.color("&cNon hai l'autorizzazione per eseguire questo comando, nel caso pensi che sia un errore contatta un amministratore."));
                    }
                    break;
            }
        }
    }
}
