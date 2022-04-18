package com.yumahisai.kbungee;

import com.yumahisai.kbungee.commands.Lobby;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public final class KBungee extends Plugin {

    public void Commands(){
        getProxy().getPluginManager().registerCommand(this, new Lobby("lobby", "khub.command.lobby", "l", "hub"));
    }

    @Override
    public void onEnable() {
        Commands();
    }
}

class KApi extends PlaceholderExpansion {



    private final KBungee plugin;
    public KApi(KBungee plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean canRegister() {
        return true;
    }
    @Override
    public @NotNull String getAuthor() {
        return "YumaHisai";
    }
    @Override
    public @NotNull String getIdentifier() {
        return "kbungee";
    }
    @Override
    public String getPlugin() {
        return null;
    }
    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }


    @Deprecated
    public String onPlaceholderRequest(ProxiedPlayer p, String identifier) {

        if (identifier.equals("name")) {
            return p.getServer().getInfo().getName().toUpperCase() + "";
        }

        return null;
    }
}
