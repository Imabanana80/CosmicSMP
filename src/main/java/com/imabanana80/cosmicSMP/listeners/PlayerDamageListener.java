package com.imabanana80.cosmicSMP.listeners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.scoreboard.Scoreboard;

public class PlayerDamageListener implements Listener {

	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player p)) return;
		Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();

		Map<String, List<DamageCause>> map = Map.ofEntries(
				Map.entry("bac_team_dark_purple", Arrays.asList(DamageCause.FALL)),
				Map.entry("bac_team_red", Arrays.asList(DamageCause.LAVA,DamageCause.FIRE,DamageCause.FIRE_TICK))
				);

		if(sb.getTeams().stream()
				.filter(t->t.hasEntry(p.getName()))
				.filter(t->map.getOrDefault(t.getName(), new ArrayList<DamageCause>()).contains(event.getCause()))
				.findAny()
				.isPresent()) {
			event.setCancelled(true);
		}
	}
}
