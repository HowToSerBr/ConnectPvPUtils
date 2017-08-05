package com.gcb.connect.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.gcb.connect.Main;

public class onKill implements Listener {

	@EventHandler
	public void kill(PlayerDeathEvent event){
		if(event.getEntity().getKiller() instanceof Player) {
			event.setDeathMessage(null);
		if(event.getEntity().getName().equals(Main.plugin.getConfig().getString("Mito"))){
			Bukkit.broadcastMessage("§c§l[CONNECT PVP] §fO player "+ event.getEntity().getKiller().getName() + " é o novo mito por matar o antigo mito "+ event.getEntity().getName());
		    for(Player all : Bukkit.getOnlinePlayers()){
				all.getPlayer().playSound(all.getLocation(), Sound.LEVEL_UP, 10.0f, 5.0f);
				}
		    	Main.plugin.getConfig().set("Mito", event.getEntity().getKiller().getName());
		    	Main.plugin.saveConfig();
		    }
		}
	}
	}

