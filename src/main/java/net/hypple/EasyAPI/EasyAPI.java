package net.hypple.EasyAPI;

import java.awt.Color;
import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import net.hypple.EasyAPI.Json.JsonManager;
import net.hypple.EasyAPI.Regions.BukkitPlayerMoveEvent;
import net.hypple.EasyAPI.mysql.EasyMySQL;
import net.md_5.bungee.api.ChatColor;

public class EasyAPI extends JavaPlugin {

	private static EasyAPI plugin;
	public static EasyMySQL mysql;
	
	@Override
	public void onEnable() {

		plugin = this;
		
		createFolder();
		defaultFile();

		
			getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
			Bukkit.getPluginManager().registerEvents(new BukkitPlayerMoveEvent(), plugin);
	}

	private void createFolder() {
		String dir = plugin.getServer().getWorldContainer().getAbsolutePath();	
		if(dir.endsWith(".")) {
			dir = dir.substring(0, dir.length() - 1);
		}
		File tempFile = new File(dir + "EasyAPI");
		if(!tempFile.exists()) {
			new File(dir + "EasyAPI").mkdirs();
			Bukkit.getConsoleSender().sendMessage(ChatColor.of(new Color(51,255,255))+"EasyAPI �7- "+ChatColor.of(new Color(0,255,0))+"EasyAPI"+" folder was created.");
		}
	}
	
	public static EasyAPI getInstance() {
		return plugin;
	}
	
	private static void defaultFile() {
		JsonManager.createJsonFile("EasyAPI");
	}
	
	public static void createPluginConfig(Plugin plugin) {
		JsonManager.createJsonFile(plugin.getName());
	}
}

