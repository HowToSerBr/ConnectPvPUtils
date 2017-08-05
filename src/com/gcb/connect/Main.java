package com.gcb.connect;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.gcb.connect.comandos.Classe;
import com.gcb.connect.comandos.Delete;
import com.gcb.connect.comandos.Mito;
import com.gcb.connect.comandos.SetMito;
import com.gcb.connect.comandos.Voar;
import com.gcb.connect.jobsutils.ListenerJobs;
import com.gcb.connect.listeners.Chat;
import com.gcb.connect.listeners.Comando;
import com.gcb.connect.listeners.onJoin;
import com.gcb.connect.listeners.onKill;
import com.gcb.connect.mysql.API;
import com.gcb.connect.mysql.Conexao;
import com.gcb.connect.score.ScoreboardUtil;

import net.milkbowl.vault.economy.Economy;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Main extends JavaPlugin {
	
	public static Main plugin;
	public static Economy economy = null;
	public static List<String> array = new ArrayList<>();
	
	public void onEnable(){
		plugin = this;
		saveDefaultConfig();
		
		Conexao.getConnection();
		API.criarTabelas();
		
		getCommand("voar").setExecutor(new Voar());
		getCommand("mito").setExecutor(new Mito());
		getCommand("setmito").setExecutor(new SetMito());
		getCommand("trabalhar").setExecutor(new Classe());
		getCommand("rtable").setExecutor(new Delete());
		
		Bukkit.getPluginManager().registerEvents(new onJoin(), this);
		Bukkit.getPluginManager().registerEvents(new ListenerJobs(), this);
		Bukkit.getPluginManager().registerEvents(new onKill(), this);
		Bukkit.getPluginManager().registerEvents(new Comando(), this);
		Bukkit.getPluginManager().registerEvents(new Chat(), this);
		
		setupEconomy();
		

		new BukkitRunnable() {
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				for(String string : plugin.getConfig().getStringList("Staff")) {
					if(string != null) {
				for(Player all : Bukkit.getOnlinePlayers()) {
				PermissionUser user = PermissionsEx.getUser(all);
				if(plugin.getConfig().getStringList("Staff").size() == 7) {
					ScoreboardUtil.unrankedSidebarDisplay(all, new String[]{"§6§lConnect PvP",
							"§1",
							"§aCoins: §f"+economy.getBalance(all.getName()),
							"§2",
							"§aRank: §f"+user.getGroups()[0].getPrefix().replaceAll("&", "§").replace("[", "").replace("]", ""),
							"§3",
							"§aStaff Online:",
							"§f"+plugin.getConfig().getStringList("Staff").get(0),
							"§f"+plugin.getConfig().getStringList("Staff").get(1),
							"§f"+plugin.getConfig().getStringList("Staff").get(2),
							"§f"+plugin.getConfig().getStringList("Staff").get(3),
							"§f"+plugin.getConfig().getStringList("Staff").get(4),
							"§f"+plugin.getConfig().getStringList("Staff").get(5),
							"§f"+plugin.getConfig().getStringList("Staff").get(6)});
				} else if(plugin.getConfig().getStringList("Staff").size() == 6) {
					ScoreboardUtil.unrankedSidebarDisplay(all, new String[]{"§6§lConnect PvP",
							"§1",
							"§aCoins: §f"+economy.getBalance(all.getName()),
							"§2",
							"§aRank: §f"+user.getGroups()[0].getPrefix().replaceAll("&", "§").replace("[", "").replace("]", ""),
							"§3",
							"§aStaff Online:",
							"§f"+plugin.getConfig().getStringList("Staff").get(0),
							"§f"+plugin.getConfig().getStringList("Staff").get(1),
							"§f"+plugin.getConfig().getStringList("Staff").get(2),
							"§f"+plugin.getConfig().getStringList("Staff").get(3),
							"§f"+plugin.getConfig().getStringList("Staff").get(4),
							"§f"+plugin.getConfig().getStringList("Staff").get(5)});
				} else if(plugin.getConfig().getStringList("Staff").size() == 5) {
				ScoreboardUtil.unrankedSidebarDisplay(all, new String[]{"§6§lConnect PvP",
						"§1",
						"§aCoins: §f"+economy.getBalance(all.getName()),
						"§2",
						"§aRank: §f"+user.getGroups()[0].getPrefix().replaceAll("&", "§").replace("[", "").replace("]", ""),
						"§3",
						"§aStaff Online:",
						"§f"+plugin.getConfig().getStringList("Staff").get(0),
						"§f"+plugin.getConfig().getStringList("Staff").get(1),
						"§f"+plugin.getConfig().getStringList("Staff").get(2),
						"§f"+plugin.getConfig().getStringList("Staff").get(3),
						"§f"+plugin.getConfig().getStringList("Staff").get(4)});
				} else if(plugin.getConfig().getStringList("Staff").size() == 4) {
					ScoreboardUtil.unrankedSidebarDisplay(all, new String[]{"§6§lConnect PvP",
							"§1",
							"§aCoins: §f"+economy.getBalance(all.getName()),
							"§2",
							"§aRank: §f"+user.getGroups()[0].getPrefix().replaceAll("&", "§").replace("[", "").replace("]", ""),
							"§3",
							"§aStaff Online:",
							"§f"+plugin.getConfig().getStringList("Staff").get(0),
							"§f"+plugin.getConfig().getStringList("Staff").get(1),
							"§f"+plugin.getConfig().getStringList("Staff").get(2),
							"§f"+plugin.getConfig().getStringList("Staff").get(3)});
					} else if(plugin.getConfig().getStringList("Staff").size() == 3) {
						ScoreboardUtil.unrankedSidebarDisplay(all, new String[]{"§6§lConnect PvP",
								"§1",
								"§aCoins: §f"+economy.getBalance(all.getName()),
								"§2",
								"§aRank: §f"+user.getGroups()[0].getPrefix().replaceAll("&", "§").replace("[", "").replace("]", ""),
								"§3",
								"§aStaff Online:",
								"§f"+plugin.getConfig().getStringList("Staff").get(0),
								"§f"+plugin.getConfig().getStringList("Staff").get(1),
								"§f"+plugin.getConfig().getStringList("Staff").get(2)});
						} else if(plugin.getConfig().getStringList("Staff").size() == 2) {
							ScoreboardUtil.unrankedSidebarDisplay(all, new String[]{"§6§lConnect PvP",
									"§1",
									"§aCoins: §f"+economy.getBalance(all.getName()),
									"§2",
									"§aRank: §f"+user.getGroups()[0].getPrefix().replaceAll("&", "§").replace("[", "").replace("]", ""),
									"§3",
									"§aStaff Online:",
									"§f"+plugin.getConfig().getStringList("Staff").get(0),
									"§f"+plugin.getConfig().getStringList("Staff").get(1)});
							} else if(plugin.getConfig().getStringList("Staff").size() == 1) {
								ScoreboardUtil.unrankedSidebarDisplay(all, new String[]{"§6§lConnect PvP",
										"§1",
										"§aCoins: §f"+economy.getBalance(all.getName()),
										"§2",
										"§aRank: §f"+user.getGroups()[0].getPrefix().replaceAll("&", "§").replace("[", "").replace("]", ""),
										"§3",
										"§aStaff Online:",
										"§f"+plugin.getConfig().getStringList("Staff").get(0)});
								} else {
									ScoreboardUtil.unrankedSidebarDisplay(all, new String[]{"§6§lConnect PvP",
											"§1",
											"§aCoins: §f"+economy.getBalance(all.getName()),
											"§2",
											"§aRank: §f"+user.getGroups()[0].getPrefix().replaceAll("&", "§").replace("[", "").replace("]", ""),
											"§3",
											"§aStaff Online:",
											"§cNenhum"});	
								}
			}			
			}
			}
			}
		}.runTaskTimer(this, 6L, 20L);
		
		Calendar calendario = Calendar.getInstance();
		int hora = calendario.get(Calendar.HOUR_OF_DAY);
		
		new BukkitRunnable() {	
			@Override
			public void run() {
				if(hora == 0) {
					API.deletarTabelas();
					API.criarTabelas();
				}
			}
		}.runTaskTimer(this, 6L, 20 * 120L);	
	}
	public void onDisable(){
	getConfig().getStringList("Staff").clear();
	getConfig().set("Staff", null);
	saveConfig();
	}
	
	private Boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager()
				.getRegistration(net.milkbowl.vault.economy.Economy.class);
		if (economyProvider != null) {
			economy = economyProvider.getProvider();
		}
		return null;
	}
}
