package me.hypermnesia.suicide;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Suicide implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("Suicide")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.DARK_RED + "Consoles never die.");
				return true;
		}
		Player player = (Player) sender;
		if (!player.hasPermission("Suicide.use")) {
			player.sendMessage(ChatColor.RED + "You don't have permission to kill yourself with this method.");
			return true;
		}
		if (args.length == 0) {
			TextComponent message = new TextComponent("Click here if you're sure you want to Suicide!");
			message.setColor(ChatColor.DARK_RED);
			message.setBold(true);
			message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/suicide killme"));
			message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
					new ComponentBuilder("There's NO going back!").color(ChatColor.RED).italic(true).create()));
			player.spigot().sendMessage(message);
			return true;
					
		}
		if (args[0].equalsIgnoreCase("killme")) {
			player.setHealth(0.0);
			//Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"heal " + player.getName());
			player.sendMessage(ChatColor.DARK_RED + "RIP!");
			return true;
			}
			player.sendMessage(ChatColor.RED + "Usage: /Suicide Big Nerd.");
			return true;
			
		}
		return false;
	}

}
