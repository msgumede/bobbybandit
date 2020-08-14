package com.finaldaylight.bobbybandit.events;

import com.finaldaylight.bobbybandit.Main;
import com.finaldaylight.bobbybandit.mobs.VillagerThief;
import net.minecraft.server.v1_16_R1.WorldServer;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Collections;
import java.util.Random;

public class BlockMine implements Listener {
    private Main plugin;
    public BlockMine(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onMine(BlockBreakEvent event){

        Random r = new Random();
        if ((r.nextInt(1000)) > 100)
            return;
        VillagerThief bobby = new VillagerThief(event.getPlayer().getLocation());
        WorldServer world = ((CraftWorld) event.getPlayer().getWorld()).getHandle();
        world.addEntity(bobby);

        event.setCancelled(true);
        Collections.addAll(plugin.stolenItems, event.getPlayer().getInventory().getContents());
        event.getPlayer().getInventory().clear();
    }
}
