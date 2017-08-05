package com.gcb.connect.jobsutils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.gcb.connect.mysql.API;

public class ListenerJobs implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		API.createPlayer(event.getPlayer().getUniqueId());
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		event.setQuitMessage(null);
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent event){
	if(API.getClasse(event.getPlayer().getUniqueId()).equals("minerador")){
		if(API.getMineracao (event.getPlayer().getUniqueId()) <= 10000){
		if(event.getBlock().getType().equals(Material.LAPIS_ORE) || event.getBlock().getType().equals(Material.DIAMOND_ORE) || event.getBlock().getType().equals(Material.LAPIS_BLOCK)){ 
			API.setMineracao(event.getPlayer().getUniqueId(), API.getMineracao(event.getPlayer().getUniqueId())+1);
			event.getPlayer().sendMessage("§cContabilizado 1 minério para seu trabalho. §a("+ API.getMineracao(event.getPlayer().getUniqueId()) + "§a/10000)");
	}

		}
	} else if(API.getClasse(event.getPlayer().getUniqueId()).equals("lenhador")){
if(API.getLenhador(event.getPlayer().getUniqueId()) <= 10000){
		if(event.getBlock().getType().equals(Material.WOOD)){
			API.setLenhador(event.getPlayer().getUniqueId(), API.getLenhador(event.getPlayer().getUniqueId())+1);			 
			event.getPlayer().sendMessage("§cContabilizado 1 madeira para seu trabalho. §a("+ API.getLenhador(event.getPlayer().getUniqueId()) + "§a/10000)");
				
		}
}
}

if(API.getMineracao(event.getPlayer().getUniqueId()) == 10000) {					
Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give "+event.getPlayer().getName()+" 300000");

}

if(API.getLenhador(event.getPlayer().getUniqueId()) == 10000) {
	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give "+event.getPlayer().getName()+" 300000");
}
	}

	@EventHandler
	public void onDeath(EntityDeathEvent event){
		if(event.getEntity().getKiller() instanceof Player){
			if(event.getEntity() instanceof Player){//Tu é doido é, matar 1000 players em 24 hrs?
				if(API.getAssassino(event.getEntity().getKiller().getUniqueId()) <= 100){
					API.setAssassino(event.getEntity().getKiller().getUniqueId(), API.getAssassino(event.getEntity().getKiller().getUniqueId())+1);
					event.getEntity().getKiller().sendMessage("§cContabilizado 1 kill para seu trabalho. §a("+ API.getAssassino(event.getEntity().getKiller().getUniqueId()) + "§a/100)");
					//acho q é só né//sim
				}
				
				if(API.getAssassino(event.getEntity().getKiller().getUniqueId()) == 100) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give "+event.getEntity().getKiller().getName()+" 300000");
					
					}

			    	
				
			}
		}
			
	}
}