package me.hypermnesia.hyperplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HyperHelp implements CommandExecutor {

    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if(label.equalsIgnoreCase("hyperhelp")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("hyperhelp.use")) {
                	player.sendMessage(ChatColor.GOLD + "=============================================================================");
                    player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "You Know... I would make a help command but when you have like 20 commands and you plan to sort them in alphabetical order it quickly gets very boring and time consming to constantly redo the help command. Maybe one day I will add it but that day is not today! Use /help hyperplugin for now.");           
                	player.sendMessage(ChatColor.GOLD + "=============================================================================");
                    return true;
                }

                
                player.sendMessage(ChatColor.RED + "Nu Permission");

                }
                
            }
        if(!(sender instanceof Player)) {
        		sender.sendMessage(ChatColor.GOLD + "=============================================================================");
                sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "You Know... I would make a help command but when you have like 20 commands and you plan to sort them in alphabetical order its very boring and time consming to constantly redo the help command. Maybe one day I will add it but that day is not today! Use /help hyperplugin for now.");
        		sender.sendMessage(ChatColor.GOLD + "=============================================================================");

             return true;
        }
		return false;


    }
    @SuppressWarnings("unused")
	private final Main plugin;
    public HyperHelp(Main plugin) {
        this.plugin = plugin;
    }
}