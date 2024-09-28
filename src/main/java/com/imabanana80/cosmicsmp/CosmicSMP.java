package com.imabanana80.cosmicsmp;

import com.imabanana80.cosmicsmp.listeners.DimensionChangeListener;
import com.imabanana80.cosmicsmp.listeners.PlayerDamageListener;
import com.imabanana80.cosmicsmp.listeners.PlayerJoinListener;
import com.imabanana80.cosmicsmp.listeners.PlayerRespawnListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

@SuppressWarnings("unused")
public final class CosmicSMP extends JavaPlugin {

    @Override
    public void onEnable() {
        List.of(
                new DimensionChangeListener(),
                new PlayerDamageListener(),
                new PlayerJoinListener(),
                new PlayerRespawnListener()
        ).forEach(listener -> Bukkit.getPluginManager().registerEvents(listener, this));
    }
}
