package com.yumahisai.khub.events;

import com.yumahisai.khub.api.LuckPermsAPI;
import com.yumahisai.khub.utils.Format;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {

    LuckPermsAPI api = new LuckPermsAPI();

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){

        Player player = event.getPlayer();

        String displayName = player.getDisplayName();

        String messageWithColors = Format.color(event.getMessage());

        String messageWithOutColors = event.getMessage();

        if(player.hasPermission("khub.chat.colors")){
            event.setFormat(Format.color(api.getPrefixGroup(player).toUpperCase()) + Format.color("&7 ") + Format.color(displayName) + " " + messageWithColors);
        } else {
            event.setFormat(Format.color(api.getPrefixGroup(player).toUpperCase()) + Format.color("&7 ") + Format.color(displayName) + " " + messageWithOutColors);
        }
    }

}
