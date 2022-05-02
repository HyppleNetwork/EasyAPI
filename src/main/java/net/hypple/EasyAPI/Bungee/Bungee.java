package net.hypple.EasyAPI.Bungee;

import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import net.hypple.EasyAPI.EasyAPI;

public class Bungee {

	public static void sendPlayerToServer(Player player, String server) {
		ByteArrayDataOutput byteArrayDataOutput = ByteStreams.newDataOutput();
        byteArrayDataOutput.writeUTF("Connect");
        byteArrayDataOutput.writeUTF(server);
        player.sendPluginMessage(EasyAPI.getInstance(), "BungeeCord", byteArrayDataOutput.toByteArray());
	}
}