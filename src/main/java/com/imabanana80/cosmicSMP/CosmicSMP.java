package com.imabanana80.cosmicSMP;

import com.imabanana80.cosmicSMP.listeners.DimensionChangeListener;
import com.imabanana80.cosmicSMP.listeners.PlayerDamageListener;
import com.imabanana80.cosmicSMP.listeners.PlayerJoinListener;
import com.imabanana80.cosmicSMP.listeners.PlayerRespawnListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CosmicSMP extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new DimensionChangeListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerRespawnListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerDamageListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }
}
