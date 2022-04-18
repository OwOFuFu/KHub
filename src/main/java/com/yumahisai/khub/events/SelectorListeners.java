package com.yumahisai.khub.events;

import com.yumahisai.khub.Main;
import com.yumahisai.khub.api.BungeeAPI;
import com.yumahisai.khub.utils.Format;
import com.yumahisai.khub.utils.HubAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.bukkit.Material.COMPASS;

public class SelectorListeners implements Listener {


    // Selector Items .... //

    ArrayList<String> lore_compass = new ArrayList<>();
    ArrayList<String> lore_events = new ArrayList<>();
    ArrayList<String> lore_main_lobby = new ArrayList<>();
    ArrayList<String> lore_all_games = new ArrayList<>();
    ArrayList<String> lore_survival = new ArrayList<>();
    ArrayList<String> lore_lobby_selector = new ArrayList<>();
    ItemStack compass = new ItemStack(COMPASS);
    ItemStack events = new ItemStack(Material.BLAZE_ROD);
    ItemStack main_lobby = new ItemStack(Material.CRAFTING_TABLE);
    ItemStack all_games = new ItemStack(Material.CLOCK);
    ItemStack survival = new ItemStack(Material.GRASS_BLOCK);
    ItemStack lobby_selector = new ItemStack(Material.NETHER_STAR);




    public void ALL(Player player){
        // Player Profile .... //
        lore_compass.clear();
        lore_survival.clear();
        lore_events.clear();
        lore_main_lobby.clear();
        lore_all_games.clear();
        lore_lobby_selector.clear();
        ItemMeta compass_meta = compass.getItemMeta();

        compass_meta.setDisplayName(Format.hex(
                65,
                172,
                242,
                "Selettore Server &7(Tasto Destro)"));

            lore_compass.add(Format.color("&7Tasto Destro per navigare."));
            compass.setItemMeta(compass_meta);
            compass.setLore(lore_compass);


        ItemMeta events_meta = events.getItemMeta();

        events_meta.setDisplayName(Format.hex(
                65,
                172,
                242,
                "Tornei"));

            lore_events.add(Format.color("&8Eventi Speciali"));
            lore_events.add(Format.color("&0"));
            lore_events.add(Format.color("&7Puoi partecipare ad"));
            lore_events.add(Format.color("&7eventi a selezione per competerti il titolo di campione."));
            lore_events.add(Format.color("&0"));
            lore_events.add(Format.color("&fUltimo Torneo: ") + Format.hex(
                    65,
                    172,
                    242,
                    "%khub_tornei_ultimo%"));
            lore_events.add(Format.color("&7Avvenuto il %khub_tornei_ultimo_data%"));
            lore_events.add(Format.color("&0"));
            lore_events.add(Format.color("&3‣ Connettiti"));
            lore_events.add(Format.color("&aLobby Aperta"));
            events.setItemMeta(events_meta);
            events.setLore(lore_events);




        ItemMeta main_lobby_meta = main_lobby.getItemMeta();
        main_lobby_meta.setDisplayName(Format.hex(
                65,
                172,
                242,
                "Lobby Principale"));

            lore_main_lobby.add(Format.color("&0"));
            lore_main_lobby.add(Format.color("&7Ritorna Alla Lobby"));
            main_lobby.setItemMeta(main_lobby_meta);
            main_lobby.setLore(lore_main_lobby);




        ItemMeta all_games_meta = all_games.getItemMeta();
        all_games_meta.setDisplayName(Format.hex(
                65,
                172,
                242,
                "Tutti i giochi"));

            lore_all_games.add(Format.color("&0"));
            lore_all_games.add(Format.hex(
                    65,
                    172,
                    242,
                    "Clicca per aprire"));
            all_games.setItemMeta(all_games_meta);
            all_games.setLore(lore_all_games);




        ItemMeta survival_meta = survival.getItemMeta();
        survival_meta.setDisplayName(Format.hex(
                65,
                172,
                242,
                "Survival &lBETA"));


            lore_survival.add(Format.color("&0"));
            lore_survival.add(Format.color("&7Unico e solo Survival del K-Server"));
            lore_survival.add(Format.color("&7Casa di tutti gli appassionati."));
            lore_survival.add(Format.color("&0"));
            lore_survival.add(Format.color("&3‣ Connettiti"));
            survival.setItemMeta(survival_meta);
            survival.setLore(lore_survival);

        ItemMeta lobby_selector_meta = lobby_selector.getItemMeta();
        lobby_selector_meta.setDisplayName(Format.hex(
                65,
                172,
                242,
                "Selettore Lobby &7(Tasto  Destro)"));
        lore_lobby_selector.add(Format.color("&7Tasto-Destro per cambiare la lobby!"));
        lore_lobby_selector.add(Format.color("&7Usalo per stare insieme ai tuoi amici."));
        lobby_selector.setItemMeta(lobby_selector_meta);
        lobby_selector.setLore(lore_lobby_selector);

    }

    Inventory selector = Bukkit.createInventory(null, 54, "Selettore Server");

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        ItemStack profile_head = HubAPI.getProfileHead(player);
        ItemStack visibility_visible = HubAPI.getPlayerVisibilityVisible(player);
        ItemStack visibility_hidden = HubAPI.getPlayerVisibilityHidden(player);
        event.setJoinMessage(null);
        event.setJoinMessage(Format.color("%khub_login_messaggio_formattato%"));
        ALL(player);
        selector.setItem(18, events);
        selector.setItem(9, main_lobby);
        selector.setItem(27, all_games);
        selector.setItem(11, survival);
        player.getInventory().removeItem(compass);
        player.getInventory().setItem(0, compass); // Give GameSelector To Player //
        player.getInventory().removeItem(profile_head);
        player.getInventory().setItem(1, profile_head); // Give Profile Head To Player //
        player.getInventory().removeItem(lobby_selector);
        player.getInventory().setItem(8, lobby_selector); // Set Lobby Selector //
        if(player.getInventory().contains(HubAPI.getPlayerVisibilityVisible(player))){
            player.getInventory().removeItem(visibility_visible);
            player.getInventory().setItem(7, visibility_visible); // Set Player Hidder //
        } else if (!(player.getInventory().contains(HubAPI.getPlayerVisibilityHidden(player)))){
            player.getInventory().removeItem(visibility_visible);
            player.getInventory().setItem(7, visibility_visible); // Set Player Hidder //
        }
        if(player.getInventory().contains(HubAPI.getPlayerVisibilityHidden(player))){
            player.getInventory().removeItem(visibility_hidden);
            player.getInventory().setItem(7, visibility_hidden); // Set Player Hidder //
        }
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event){
        Player player = event.getPlayer();

        if(player.getInventory().contains(COMPASS)){

            if(event.getAction().isRightClick() || event.getAction().isLeftClick()){
                if(player.getInventory().getItemInHand().getType().equals(COMPASS)){
                    event.setCancelled(true);
                    player.openInventory(selector);
                }
            }
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event){

        if(event.getPlayer().getInventory().contains(Material.PLAYER_HEAD)
        || event.getPlayer().getInventory().contains(Material.CHEST)
        || event.getPlayer().getInventory().contains(Material.COMPASS)
        || event.getPlayer().getInventory().contains(Material.NETHER_STAR)
        || event.getPlayer().getInventory().contains(Material.LIME_DYE)
        || event.getPlayer().getInventory().contains(Material.GRAY_DYE)){
            event.setCancelled(true);
        }
    }


    @EventHandler
    @Deprecated
    public void InventoryListener(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();

        if(e.getClickedInventory().equals(p.getInventory())){
            switch(e.getCurrentItem().getType()){
                case PLAYER_HEAD:
                case CHEST:
                case COMPASS:
                case NETHER_STAR:
                case LIME_DYE:
                case GRAY_DYE:
                    e.setCancelled(true);
                    break;
            }
        }

        if(e.getView().getTitle().equalsIgnoreCase("Selettore Server")){
            switch (e.getCurrentItem().getType()){
                case CRAFTING_TABLE:
                    if(p.hasPermission("khub.selector.lobby.main")){
                        p.closeInventory();
                        BungeeAPI.sendPlayerToServer(p, "Hub");
                        break;
                    }
                case BLAZE_ROD:
                    if(p.hasPermission("khub.selector.tornei")){
                        p.closeInventory();
                        BungeeAPI.sendPlayerToServer(p, "Tornei");
                        break;
                    }
                case CLOCK:
                    if(p.hasPermission("khub.selector.allgames")){
                        p.closeInventory();
                        // open all games
                        break;
                    }
                case GRASS_BLOCK:
                    if(p.hasPermission("khub.selector.survival")){
                        p.closeInventory();
                        BungeeAPI.sendPlayerToServer(p, "Survival"); // survival
                        break;
                    }
                default:
                    e.setCancelled(true);
                    break;
            }
            e.setCancelled(true);
        }
    }


    @EventHandler
    @Deprecated
    public void InteractListener(PlayerInteractEvent e){
        if(e.getAction().isRightClick()){
            if(e.getItem().getType().equals(Material.LIME_DYE)){

                Map<String, Long> cooldown = new HashMap<>();

                if(cooldown.containsKey(e.getPlayer().getName())){
                    if(cooldown.get(e.getPlayer().getName()) > System.currentTimeMillis()){
                        long timeleft = (cooldown.get(e.getPlayer().getName()) - System.currentTimeMillis()) / 1000L;
                        e.getPlayer().sendMessage(Format.color("&cDevi aspettare &e"+ timeleft +"s prima di riusarlo!"));
                        return;
                    }
                }
                e.getPlayer().getInventory().removeItem(HubAPI.getPlayerVisibilityVisible(e.getPlayer()));
                e.getPlayer().getInventory().setItem(7, HubAPI.getPlayerVisibilityHidden(e.getPlayer()));
                for(Player online : Bukkit.getOnlinePlayers()){
                    e.getPlayer().hidePlayer(online);
                }
                e.getPlayer().sendMessage(Format.color("&cVisibilita' giocatori disabilitata!"));
                cooldown.put(e.getPlayer().getName(), System.currentTimeMillis() + (Main.getInstance().getConfig().getInt("CoolDownVisibility") * 1000L));
            }

            if(e.getItem().getType().equals(Material.GRAY_DYE)){

                Map<String, Long> cooldown = new HashMap<>();

                if(cooldown.containsKey(e.getPlayer().getName())){
                    if(cooldown.get(e.getPlayer().getName()) > System.currentTimeMillis()){
                        long timeleft = (cooldown.get(e.getPlayer().getName()) - System.currentTimeMillis()) / 1000L;
                        e.getPlayer().sendMessage(Format.color("&cDevi aspettare &e"+ timeleft +"s prima di riusarlo!"));
                        return;
                    }
                }
                e.getPlayer().getInventory().removeItem(HubAPI.getPlayerVisibilityHidden(e.getPlayer()));
                e.getPlayer().getInventory().setItem(7, HubAPI.getPlayerVisibilityVisible(e.getPlayer()));
                for(Player online : Bukkit.getOnlinePlayers()){
                    e.getPlayer().showPlayer(online);
                }
                e.getPlayer().sendMessage(Format.color("&aVisibilita' giocatori abilitata!"));
                cooldown.put(e.getPlayer().getName(), System.currentTimeMillis() + (Main.getInstance().getConfig().getInt("CoolDownVisibility") * 1000L));
            }
        }
    }
}
