package com.imabanana80.cosmicSMP.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class PlayerDamageListener implements Listener {
    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            if (event.getEntity() instanceof Player p) {
                Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
                String teamName = null;
                for (Team team : sb.getTeams()) {
                    if (team.hasEntry(p.getName())) {
                        teamName = team.getName();
                    }
                }
                switch (teamName) {
                    case "bac_team_purple" -> {
                        if (event.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
                            event.setCancelled(true);
                        }
                    }
                    case "bac_team_red" -> {
                        if (event.getCause().equals(EntityDamageEvent.DamageCause.LAVA) || event.getCause().equals(EntityDamageEvent.DamageCause.FIRE) || event.getCause().equals(EntityDamageEvent.DamageCause.FIRE_TICK)) {
                            event.setCancelled(true);
                        }
                    }
                }
            }
        }

    }
}
