package com.gcb.connect.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.gcb.connect.Main;

import br.com.devpaulo.legendchat.api.events.ChatMessageEvent;

public class Chat implements Listener {
	
	@EventHandler
	public void onChat(ChatMessageEvent event) {
		if(event.getTags().contains("mito") && Main.plugin.getConfig().getString("Mito").equals(event.getSender().getName())) {
			event.setTagValue("mito", "§5[Mito] §r");
		}
	}

}
