package com.imabanana80.cosmicSMP;

import com.imabanana80.cosmicSMP.listeners.DimensionChangeListener;
import com.imabanana80.cosmicSMP.listeners.PlayerDamageListener;
import com.imabanana80.cosmicSMP.listeners.PlayerJoinListener;
import com.imabanana80.cosmicSMP.listeners.PlayerRespawnListener;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.World.Environment;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class CosmicSMP extends JavaPlugin {

	public static CosmicSMP i;
	
	public CosmicSMP() {i=this;}
	
    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new DimensionChangeListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerRespawnListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerDamageListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }
    
	public static void setHealthAndMovementSpeed(Player p, String teamName) {
        final double BASE_HEALTH = 20;
        final double ENVIRONMENT_HEALTH_BOOST = 4;
        Map<String, Environment> environmentMap = Map.ofEntries(
        		Map.entry("bac_team_red", Environment.NETHER),
        		Map.entry("bac_team_green", Environment.NORMAL),
        		Map.entry("bac_team_dark_purple", Environment.THE_END)
        		);
        Map<String, Double> movementSpeedMap = Map.ofEntries(
        		Map.entry("bac_team_red", .1),
        		Map.entry("bac_team_green", .115),
        		Map.entry("bac_team_dark_purple", .1)
        		);
        
        p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(p.getWorld().getEnvironment().equals(environmentMap.get(teamName)) ? BASE_HEALTH + ENVIRONMENT_HEALTH_BOOST : BASE_HEALTH);
        p.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(movementSpeedMap.getOrDefault(teamName, .1));
	}
    
}
