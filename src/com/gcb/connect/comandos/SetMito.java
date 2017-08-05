package com.gcb.connect.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gcb.connect.Main;

public class SetMito implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmnd, String arg2, String[] args) {
		if(cs instanceof Player) {
			if(cmnd.getName().equalsIgnoreCase("setmito")) {
				if(cs.hasPermission("connect.setmito")) {
				if(args.length == 1) {
					Bukkit.broadcastMessage("§c§l[CONNECT PVP] §fO player "+ args[0]  + " é o novo mito!");
					Main.plugin.getConfig().set("Mito", args[0]);
					Main.plugin.saveConfig();
				}else{
					cs.sendMessage("§cUse /setmito <nick>!");
				}
				}else{
					cs.sendMessage("§cVocê não tem permissão!");
				}
			}
		}
		return false;
	}
	
	

}
