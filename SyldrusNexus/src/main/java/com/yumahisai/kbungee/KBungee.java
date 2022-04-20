package com.yumahisai.kbungee;

import com.yumahisai.kbungee.commands.Lobby;
import net.md_5.bungee.api.plugin.Plugin;

public final class KBungee extends Plugin {

    public void Commands(){
        getProxy().getPluginManager().registerCommand(this, new Lobby("lobby", "khub.command.lobby", "l", "hub"));
    }

    @Override
    public void onEnable() {
        Commands();
    }
}
