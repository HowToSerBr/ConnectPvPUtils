package com.gcb.connect.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gcb.connect.Main;

public class Mito implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("mito")){
				if(sender.hasPermission("connect.vermito")){
					if (Main.plugin.getConfig().getString("Mito") != null){	
					sender.sendMessage("�aO atual mito �: �c" + Main.plugin.getConfig().getString("Mito"));
				}else{
					sender.sendMessage("�cN�o temos nenhum mito no momento.");
				}	
				}else{
					sender.sendMessage("�cVoc� n�o tem permiss�o!");
				}
			}		
	}
		return false;
}
}
