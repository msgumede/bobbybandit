package com.finaldaylight.bobbybandit;


import com.finaldaylight.bobbybandit.events.BlockMine;
import com.finaldaylight.bobbybandit.events.EntityDamage;
import com.finaldaylight.bobbybandit.events.EntityDeath;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin {

    public List<ItemStack> stolenItems = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new EntityDamage(), this);
        pm.registerEvents(new EntityDeath(this), this);
        pm.registerEvents(new BlockMine(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
