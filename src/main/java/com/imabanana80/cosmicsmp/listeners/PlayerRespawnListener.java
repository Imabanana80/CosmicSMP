package com.imabanana80.cosmicsmp.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import org.bukkit.World.Environment;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public final class PlayerRespawnListener implements Listener {

    @EventHandler
    public void onPlayerRespawn(final PlayerRespawnEvent event) {
        final Player player = event.getPlayer();
        final Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        String teamName = null;

        for (final Team team : scoreboard.getTeams()) {
            if (team.hasEntry(player.getName())) {
                teamName = team.getName();
            }
        }

        final Location respawnLocation = event.getRespawnLocation();
        final Environment dimension = respawnLocation.getWorld().getEnvironment();
        switch (teamName) {
            case "bac_team_red" -> {
                if (dimension == Environment.NETHER) {
                    player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(24.0D);
                } else {
                    player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20.0D);
                }
            }
            case "bac_team_green" -> {
                if (dimension == Environment.NORMAL) {
                    player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(24.0D);
                } else {
                    player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20.0D);
                }
            }
            case "bac_team_dark_purple" -> {
                if (dimension == Environment.THE_END) {
                    player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(24.0D);
                } else {
                    player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20.0D);
                }
            }
            case null -> {
                throw new IllegalArgumentException("Player " + player.getName() + " is not assigned to a team");
            }
            default -> throw new IllegalStateException("Unexpected team: " + teamName);
        }
    }
}
