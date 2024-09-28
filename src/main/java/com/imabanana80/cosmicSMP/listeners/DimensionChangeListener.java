package com.imabanana80.cosmicSMP.listeners;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.imabanana80.cosmicSMP.CosmicSMP;

public class DimensionChangeListener implements Listener {
	
	//FIXME add and remove this instead of changing default value (plugin compat)
	AttributeModifier DIMENSION_BOOST = new AttributeModifier(new NamespacedKey(CosmicSMP.i, ""), 4.0, Operation.ADD_NUMBER, EquipmentSlotGroup.ANY);
	
	@EventHandler
	public void onPlayerDimensionChange(PlayerPortalEvent event) {
		Location to = event.getTo();
		Player p = event.getPlayer();
		Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
		String teamName = null;
		for (Team team : sb.getTeams()) {
			if (team.hasEntry(p.getName())) {
				teamName = team.getName();
			}
		}
		World.Environment dimension = to.getWorld().getEnvironment();

		double boosted = 24;
		double regular = 20;

		Map<String, Environment> map = Map.ofEntries(
				Map.entry("bac_team_red", Environment.NETHER),
				Map.entry("bac_team_green", Environment.NORMAL),
				Map.entry("bac_team_red", Environment.THE_END)
				);

		p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(map.get(teamName) == dimension ? boosted : regular);
		
	}
}
