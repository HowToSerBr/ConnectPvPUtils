package com.gcb.connect.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gcb.connect.mysql.API;

public class Delete implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmnd, String arg2, String[] args) {
		if(cs instanceof Player) {
			if(cmnd.getName().equalsIgnoreCase("rtable")) {
				if(cs.hasPermission("connect.rtable")) {
					API.deletarTabelas();
					API.criarTabelas();
					cs.sendMessage("§aTrabalhos reiniciados.");
				}
			}
		} else {
			API.deletarTabelas();
			API.criarTabelas();
			cs.sendMessage("§aTrabalhos reiniciados.");
		}
		return false;
	}
	
	
	

}
