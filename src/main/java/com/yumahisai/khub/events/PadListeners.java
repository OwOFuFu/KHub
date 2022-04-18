package com.yumahisai.khub.events;

import com.yumahisai.khub.api.PadsAPI;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PadListeners implements Listener {

    private final PadsAPI pads = new PadsAPI();

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        pads.LaunchPadNormal(e, p);
        pads.LaunchPadRandom(e, p);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        pads.LaunchBlockNormal(e, p);
        pads.LaunchBlockRandom(e, p);
    }

    @EventHandler
    public void onFall(EntityDamageEvent e) {
        if (e.getEntity().getType() == EntityType.PLAYER && e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            if (pads.LaunchPad.contains(e.getEntity().getName())) {
                pads.LaunchPad.remove(e.getEntity().getName());
                e.setCancelled(true);
            } else if (pads.RandomLaunchPad.contains(e.getEntity().getName())) {
                pads.RandomLaunchPad.remove(e.getEntity().getName());
                e.setCancelled(true);
            }
        }

    }

}
