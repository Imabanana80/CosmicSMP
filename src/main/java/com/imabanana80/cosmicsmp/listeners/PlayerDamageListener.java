package com.imabanana80.cosmicsmp.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public final class PlayerDamageListener implements Listener {

    @EventHandler
    public void onEntityDamage(final EntityDamageEvent event) {
        if (!(event.getEntity() instanceof final Player player)) return;

        final Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        String teamName = null;

        for (final Team team : scoreboard.getTeams()) {
            if (team.hasEntry(player.getName())) {
                teamName = team.getName();
                break;
            }
        }

        switch (teamName) {
            case "bac_team_dark_purple" -> {
                if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                    event.setCancelled(true);
                }
            }
            case "bac_team_red" -> {
                if (event.getCause() == EntityDamageEvent.DamageCause.LAVA
                        || event.getCause() == EntityDamageEvent.DamageCause.FIRE
                        || event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {
                    event.setCancelled(true);
                }
            }
            case null -> {
                throw new IllegalArgumentException("Player " + player.getName() + " is not assigned to any team.");
            }
            default -> {
                throw new IllegalStateException("Unexpected team: " + teamName);
            }
        }
    }
}
