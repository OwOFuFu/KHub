package com.yumahisai.khub.api;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.yumahisai.khub.Main;
import org.bukkit.entity.Player;

public class BungeeAPI {

    public static void sendPlayerToServer(Player p,String server){

        ByteArrayDataOutput out = ByteStreams.newDataOutput();

        try{

            out.writeUTF("Connect");
            out.writeUTF(server);

        } catch (Exception e) {

            e.printStackTrace();

        }

        p.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());

    }

}
