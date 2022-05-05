package net.hypple.EasyAPI.Bungee;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import net.hypple.EasyAPI.EasyAPI;
import net.md_5.bungee.api.ChatColor;

public class Bungee {

	private static List<String> channels = new ArrayList<>();

	public static void sendPlayerToServer(Player player, String server) {
		ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput();
		byteArrayDataOutput.writeUTF("Connect");
		byteArrayDataOutput.writeUTF(server);
		player.sendPluginMessage(EasyAPI.getInstance(), "BungeeCord", byteArrayDataOutput.toByteArray());
	}

	public static void registerPluginChannel(String channelName) {
		if(!channels.contains(channelName)) {
			channels.add(channelName);
			EasyAPI.getInstance().getServer().getMessenger().registerOutgoingPluginChannel(EasyAPI.getInstance(), channelName);
			Bukkit.getConsoleSender().sendMessage(ChatColor.of(new Color(51,255,255))+"EasyAPI §7- "+ChatColor.of(new Color(0,255,0))+"plugin channel "+channelName+" is registerd.");
		}
	}

	public static void sendPluginMessage(Player player, ByteArrayDataOutput byteArrayDataOutput, String channel) {
		player.sendPluginMessage(EasyAPI.getInstance(), channel, byteArrayDataOutput.toByteArray());
	}
}