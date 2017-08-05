package com.gcb.connect.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Comando implements Listener {
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		if(event.getMessage().startsWith("/warp") || event.getMessage().startsWith("/warps")) {
			String[] split = event.getMessage().split(" ");
			if(split[1] != null) {
				if(event.getPlayer().getAllowFlight()) {
				event.getPlayer().setAllowFlight(false);
				event.getPlayer().sendMessage(" ");
				event.getPlayer().sendMessage("§cModo voar desativado!");
				event.getPlayer().sendMessage(" ");
				}
			}
		}
	}	

}
