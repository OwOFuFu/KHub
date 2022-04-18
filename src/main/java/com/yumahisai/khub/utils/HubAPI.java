package com.yumahisai.khub.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class HubAPI {

    /**
     * @param player
     * @return
     */
    public static ItemStack getProfileHead(Player player ) {
        ArrayList<String> lore_profile = new ArrayList<>();
        lore_profile.add(Format.color("&7Questo e' il tuo profilo privato qui potrai,"));
        lore_profile.add(Format.color("&7Attivare i booster del network e anche altre cose!"));
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        char first = player.getName().charAt(0);
        char after = player.getName().toUpperCase().charAt(0);
        meta.setDisplayName(Format.hex(65,
                172,
                242,
                "Profilo di " + player.getName().replace(first, after) +  " &7(Tasto Destro)"));
        meta.setOwningPlayer(Bukkit.getOfflinePlayer(player.getUniqueId()));
        item.setItemMeta(meta);
        item.setLore(lore_profile);
        return item;
    }

    public static ItemStack getPlayerVisibilityVisible(Player player ) {
        ArrayList<String> lore_visibility = new ArrayList<>();
        lore_visibility.add(Format.color("&7Fai click con il pulsante destro del mouse per attivare/disattivare la visibilità del giocatore!"));
        ItemStack item = new ItemStack(Material.LIME_DYE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Format.hex(65,
                172,
                242,
                "&fGiocatori: &aVisibili &7(Tasto Destro)"));
        item.setItemMeta(meta);
        item.setLore(lore_visibility);
        return item;
    }

    public static ItemStack getPlayerVisibilityHidden(Player player ) {
        ArrayList<String> lore_visibility_hidden = new ArrayList<>();
        lore_visibility_hidden.add(Format.color("&7Fai click con il pulsante destro del mouse per attivare/disattivare la visibilità del giocatore!"));
        ItemStack item = new ItemStack(Material.GRAY_DYE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Format.hex(65,
                172,
                242,
                "&fGiocatori: &cNascosti &7(Tasto Destro)"));
        item.setItemMeta(meta);
        item.setLore(lore_visibility_hidden);
        return item;
    }
}
