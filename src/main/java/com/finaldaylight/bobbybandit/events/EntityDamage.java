package com.finaldaylight.bobbybandit.events;

import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class EntityDamage implements Listener {

    private ItemStack[] thiefbag = {
            new ItemStack(Material.BAMBOO_SAPLING, 20),
            new ItemStack(Material.ANVIL, 1),
            new ItemStack(Material.BEEHIVE, 3),
            new ItemStack(Material.ENDER_PEARL, 1),
            new ItemStack(Material.DIAMOND_BOOTS, 1),
            new ItemStack(Material.DIAMOND_AXE, 3),
    };

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if(!(event.getEntity() instanceof Villager))
            return;
        if (event.getEntity().getCustomName() == null)
            return;
        if (!event.getEntity().getCustomName().contains("Bobby"))
            return;

        Random r = new Random();
        event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), thiefbag[r.nextInt(thiefbag.length)]);
    }
}
