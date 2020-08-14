package com.finaldaylight.bobbybandit.events;

import com.finaldaylight.bobbybandit.Main;
import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class EntityDeath implements Listener {

    private Main plugin;
    public EntityDeath(Main plugin){
        this.plugin = plugin;
    }

    private ItemStack[] thiefbag = {
            new ItemStack(Material.BAMBOO_SAPLING, 64),
            new ItemStack(Material.ANVIL, 2),
            new ItemStack(Material.BEEHIVE, 3),
            new ItemStack(Material.ENDER_PEARL, 1),
            new ItemStack(Material.GOLDEN_BOOTS, 3),
            new ItemStack(Material.GOLDEN_AXE, 1),
    };

    @EventHandler
    public void onDamage(EntityDeathEvent event){
        if(!(event.getEntity() instanceof Villager))
            return;
        if (event.getEntity().getCustomName() == null)
            return;
        if (!event.getEntity().getCustomName().contains("Bobby"))
            return;

        Random r = new Random();
        event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), thiefbag[r.nextInt(thiefbag.length)]);

        for (ItemStack item : plugin.stolenItems){
            if (item != null)
                event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), item);

        }
    }
}
