package me.hypermnesia.hyperplugin;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Medic implements CommandExecutor {
	

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("Medic")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.DARK_RED + "You're console. You have infinite health. Why in the world would you need a medic. For crying out loud you cant even be damaged. Stop wasting the medic's time");
				return true;
		}
		Player player = (Player) sender;
		if (!player.hasPermission("Medic.use")) {
			player.sendMessage(ChatColor.RED + "The Medic says you have no Permission to Call for the Medic's Help");
			return true;
		}
		if (args.length == 0) {
			TextComponent message = new TextComponent("Would you like to be Healed?");
			message.setColor(ChatColor.GOLD);
			message.setBold(true);
			message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/medic healme"));
			message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
					new ComponentBuilder("Click here to grab the Medic's Attention!").color(ChatColor.AQUA).italic(true).create()));
			player.spigot().sendMessage(message);
			return true;
					
		}
		if (args[0].equalsIgnoreCase("healme")) {
			player.setHealth(20.0);
			//Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"heal " + player.getName());
			player.sendMessage(ChatColor.DARK_GREEN + "The Medic has healed you!");
			return true;
			}
			player.sendMessage(ChatColor.RED + "Usage: /Medic Big Nerd.");
			return true;
			
		}
		return false;
	}
    @SuppressWarnings("unused")
	private final Main plugin;
    public Medic(Main plugin) {
        this.plugin = plugin;
    }
}
