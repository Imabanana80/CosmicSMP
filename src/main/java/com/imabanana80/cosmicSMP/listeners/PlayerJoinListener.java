package com.imabanana80.cosmicSMP.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        Location loc = p.getLocation();
        Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
        String teamName = null;
        for (Team team : sb.getTeams()) {
            if (team.hasEntry(p.getName())) {
                teamName = team.getName();
            }
        }
        World.Environment dimension = loc.getWorld().getEnvironment();
        switch (teamName) {
            case "bac_team_red" -> {
                if (dimension == World.Environment.NETHER) {
                    p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(24.0D);
                } else {
                    p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20.0D);
                }
                p.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.1);
            }
            case "bac_team_green" -> {
                if (dimension == World.Environment.NORMAL) {
                    p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(24.0D);
                } else {
                    p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20.0D);
                }
                p.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.115);
            }
            case "bac_team_dark_purple" -> {
                if (dimension == World.Environment.THE_END) {
                    p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(24.0D);
                } else {
                    p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20.0D);
                }
                p.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.1);
            }
        }
    }
}
