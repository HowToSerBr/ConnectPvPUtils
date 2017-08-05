package com.gcb.connect.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gcb.connect.mysql.API;

public class Classe implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("trabalhar")) {
			if(args.length == 1) {
				if (args[0].equals("minerador")){
					API.setClasse(((Player) sender).getUniqueId(), "minerador");
					sender.sendMessage("§cSeu trabalho foi alterado para minerador!");
				} else if(args[0].equals("lenhador")){
					API.setClasse(((Player) sender).getUniqueId(), "lenhador");
					sender.sendMessage("§cSeu trabalho foi alterado para lenhador!");
				} else if(args[0].equals("assassino")){
				API.setClasse(((Player) sender).getUniqueId(), "assassino");
				sender.sendMessage("§cSeu trabalho foi alterado para assassino!");
				} else {
					sender.sendMessage("§cUse /trabalho <assassino, minerador, lenhador>!");
				}
			}else{
				sender.sendMessage("§cUse /trabalho <assassino, minerador, lenhador>!");
			}
		}
	}
		return false;	
}
}
