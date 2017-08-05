package com.gcb.connect.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Voar implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("voar")){
				if(sender.hasPermission("connect.vip")){
					if(((Player)sender).getAllowFlight()){
						
						sender.sendMessage(" ");
						sender.sendMessage("§cModo voar desativado!");
						sender.sendMessage(" ");
						((Player) sender).setAllowFlight(false);
					}else{
						
						sender.sendMessage(" ");
						sender.sendMessage("§aModo voar ativado!");
						sender.sendMessage(" ");
						((Player) sender).setAllowFlight(true);
						
					}
		
		
	}else{
		sender.sendMessage("§cAdquira VIP para poder voar pelo mundo! ;)");
	}
			}
		}else{
			sender.sendMessage("Este comando deve ser executado apenas por players!");
		}
		return false;
	}
	
}
