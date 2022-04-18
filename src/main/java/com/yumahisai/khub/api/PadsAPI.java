package com.yumahisai.khub.api;

import com.yumahisai.khub.Main;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("ALL")
public class PadsAPI {

    public final ArrayList<String> LaunchPad = new ArrayList();
    public final ArrayList<String> RandomLaunchPad = new ArrayList();

    public void LaunchPadNormal(PlayerInteractEvent e, Player p) {
        if (e.getAction() == Action.PHYSICAL && e.getClickedBlock().getType() == Material.valueOf(Main.getInstance().getConfig().getString("Launchpad.Normal.Plate")) && e.getClickedBlock().getLocation().getBlock().getRelative(BlockFace.DOWN).getRelative(BlockFace.DOWN).getType() == Material.valueOf(Main.getInstance().getConfig().getString("Launchpad.Normal.UBID"))) {
            if (!this.LaunchPad.contains(e.getPlayer().getName())) {
                this.LaunchPad.add(e.getPlayer().getName());
            }

            e.setCancelled(true);
            p.setVelocity(p.getLocation().getDirection().normalize().setY(1.15D));
            p.playSound(p.getLocation(), Sound.valueOf(Main.getInstance().getConfig().getString("Launchpad.Normal.Sound")), 10000.0F, 1.0F);
        }

    }

    public void LaunchPadRandom(PlayerInteractEvent e, Player p) {
        if (e.getAction() == Action.PHYSICAL && e.getClickedBlock().getType() == Material.valueOf(Main.getInstance().getConfig().getString("Launchpad.Random.Plate")) && e.getClickedBlock().getLocation().getBlock().getRelative(BlockFace.DOWN).getRelative(BlockFace.DOWN).getType() == Material.valueOf(Main.getInstance().getConfig().getString("Launchpad.Random.UBID"))) {
            if (!this.RandomLaunchPad.contains(e.getPlayer().getName())) {
                this.RandomLaunchPad.add(e.getPlayer().getName());
            }

            Random s = new Random(System.currentTimeMillis());
            Vector hola = new Vector(s.nextInt(12), s.nextInt(12), s.nextInt(12));
            e.setCancelled(true);
            p.setVelocity(hola);
            p.playSound(p.getLocation(), Sound.valueOf(Main.getInstance().getConfig().getString("Launchpad.Random.Sound")), 10000.0F, 1.0F);
        }

    }

    public void LaunchBlockNormal(PlayerMoveEvent e, Player p) {
        if (p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.valueOf(Main.getInstance().getConfig().getString("LaunchBlock.Normal.Block")) && p.getLocation().getBlock().getRelative(BlockFace.DOWN).getRelative(BlockFace.DOWN).getRelative(BlockFace.DOWN).getType() == Material.valueOf(Main.getInstance().getConfig().getString("LaunchBlock.Normal.UBID"))) {
            if (!this.LaunchPad.contains(e.getPlayer().getName())) {
                this.LaunchPad.add(e.getPlayer().getName());
            }

            p.setVelocity(p.getLocation().getDirection().normalize().setY(2.5D));
            p.playSound(p.getLocation(), Sound.valueOf(Main.getInstance().getConfig().getString("LaunchBlock.Normal.Sound")), 10000.0F, 1.0F);
        }

    }

    public void LaunchBlockRandom(PlayerMoveEvent e, Player p) {
        if (p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.valueOf(Main.getInstance().getConfig().getString("LaunchBlock.Random.Block")) && p.getLocation().getBlock().getRelative(BlockFace.DOWN).getRelative(BlockFace.DOWN).getRelative(BlockFace.DOWN).getType() == Material.valueOf(Main.getInstance().getConfig().getString("LaunchBlock.Random.UBID"))) {
            if (!this.RandomLaunchPad.contains(e.getPlayer().getName())) {
                this.RandomLaunchPad.add(e.getPlayer().getName());
            }

            Random sa = new Random(System.currentTimeMillis());
            Vector holas = new Vector(sa.nextInt(12), sa.nextInt(12), sa.nextInt(12));
            p.setVelocity(holas);
            p.playSound(p.getLocation(), Sound.valueOf(Main.getInstance().getConfig().getString("LaunchBlock.Random.Sound")), 10000.0F, 1.0F);
        }

    }

}
