package com.imabanana80.cosmicSMP.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.imabanana80.cosmicSMP.CosmicSMP;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
        String teamName = null;
        for (Team team : sb.getTeams()) {
            if (team.hasEntry(p.getName())) {
                teamName = team.getName();
            }
        }
        CosmicSMP.setHealthAndMovementSpeed(p, teamName);
    }
}
