package me.hypermnesia.hyperplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Creator implements CommandExecutor {

    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if(label.equalsIgnoreCase("creator")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("creator.use")) {
                	player.sendMessage(ChatColor.DARK_BLUE + "Hyperplugin Developement began on‎ September ‎30, ‎2020");
                	player.sendMessage(ChatColor.BLUE + "Hyperplugin was made by Hypermnesia (Discord:Hypermnesia#6007)");
                	player.sendMessage(ChatColor.LIGHT_PURPLE + "Hope you Enjoy it :D");
                	player.sendMessage(ChatColor.RED + "You Better Enjoy it");
                	player.sendMessage(ChatColor.DARK_RED + "OR ELSE");
                    return true;
                }
                player.sendMessage(ChatColor.RED + "You have no permission to view the creator of Hyperplugin");


                }
            else{
            	sender.sendMessage(ChatColor.DARK_BLUE + "Hyperplugin Developement began on‎ September ‎30, ‎2020");
            	sender.sendMessage(ChatColor.BLUE + "Hyperplugin was made by Hypermnesia (Discord:Hypermnesia#6007)");
            	sender.sendMessage(ChatColor.LIGHT_PURPLE + "Hope you Enjoy it :D");
            	sender.sendMessage(ChatColor.RED + "You Better Enjoy it");
            	sender.sendMessage(ChatColor.DARK_RED + "OR ELSE");

            } return true;

        }

        return false;

    }
    @SuppressWarnings("unused")
	private final Main plugin;
    public Creator(Main plugin) {
        this.plugin = plugin;
    }
}
