package com.gcb.connect.listeners;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;

import com.gcb.connect.Main;

public class onJoin implements Listener {
	 
	public static List<String> list = Main.plugin.getConfig().getStringList("Staff");
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void join (PlayerJoinEvent event){
		if(event.getPlayer().hasPermission("connect.staff")) {
			list.add(event.getPlayer().getName());
			Main.plugin.getConfig().set("Staff", list);
			Main.plugin.saveConfig();
		}
		if(event.getPlayer().getName().equals(Main.plugin.getConfig().getString("Mito"))){
			Bukkit.broadcastMessage("§c§l[CONNECT PVP] §fO mito "+ event.getPlayer().getName() + " entrou no servidor!");
			for(Player player : Bukkit.getOnlinePlayers()){
			event.setJoinMessage(null);
			event.getPlayer().playSound(player.getLocation(), Sound.LEVEL_UP, 10.0f, 5.0f);	}
		}else{
			event.setJoinMessage(null);
		}
		if(event.getPlayer().hasPermission("entrar.avisar")){
			Bukkit.broadcastMessage(PermissionsEx.getUser(event.getPlayer()).getGroups()[0].getPrefix().replace("&", "§") +"§f "+ event.getPlayer().getName() + " §6entrou no servidor!");
			
		}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		if(event.getPlayer().hasPermission("connect.staff")) {
			list.remove(event.getPlayer().getName());
			Main.plugin.getConfig().set("Staff", list);
			Main.plugin.saveConfig();
		}
	}
}
