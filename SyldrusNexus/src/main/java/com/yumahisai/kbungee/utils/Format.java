package com.yumahisai.kbungee.utils;


import net.md_5.bungee.api.ChatColor;

import java.awt.*;

public class Format {

    public static String color(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static String hex(int r, int g, int b, String s){
        return ChatColor.of(new Color(r,g,b)) + color(s);
    }
}
