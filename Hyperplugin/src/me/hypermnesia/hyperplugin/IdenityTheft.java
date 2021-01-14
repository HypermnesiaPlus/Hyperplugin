package me.hypermnesia.hyperplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IdenityTheft implements CommandExecutor {

    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if(label.equalsIgnoreCase("idenitytheft")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("idenitytheft.use")) {
                	if (args.length == 0) {
                		player.sendMessage(ChatColor.RED + "You must specifya new name!");
                	}
                	if (args[0].equalsIgnoreCase("reset")) {
                		player.setDisplayName(player.getName());
                		player.sendMessage(ChatColor.BLUE + "Your name has been reset");
                		return true;
                	}
                    player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Your new name is " + ChatColor.GOLD + "" + args[0]);
                    player.setDisplayName(args[0]);
                    return true;
                }
                player.sendMessage(ChatColor.RED + "u has no permission to steall other's idenity");


                }
            else{
                sender.sendMessage(ChatColor.DARK_BLUE + "console cant change nick");

            } return true;

        }

        return false;

    }
    @SuppressWarnings("unused")
	private final Main plugin;
    public IdenityTheft(Main plugin) {
        this.plugin = plugin;
    }
}