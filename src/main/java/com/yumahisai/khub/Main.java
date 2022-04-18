package com.yumahisai.khub;

import com.yumahisai.khub.commands.Spawn;
import com.yumahisai.khub.events.Chat;
import com.yumahisai.khub.events.PadListeners;
import com.yumahisai.khub.events.SelectorListeners;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;

    public static Main getInstance(){
        return instance;
    }

    public void Events(){
        this.getServer().getPluginManager().registerEvents(new PadListeners(), this);
        this.getServer().getPluginManager().registerEvents(new SelectorListeners(), this);
        this.getServer().getPluginManager().registerEvents(new Chat(), this);
    }

    public void Commands(){
        this.getCommand("spawn").setExecutor(new Spawn());
    }

    @Override
    public void onEnable() {
        instance = this;
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if(provider != null){
            LuckPerms api = provider.getProvider();
        }
        saveDefaultConfig();
        getServer().getMessenger().registerOutgoingPluginChannel(Main.getInstance(),"BungeeCord");
        this.getConfig().options().copyDefaults(true);
        this.getConfig().options().parseComments(true);
        Events();
        Commands();
    }
}
