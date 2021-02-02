package me.hypermnesia.hyperplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Expose implements CommandExecutor {

    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if(label.equalsIgnoreCase("expose")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("expose.use")) {
                	if (args.length == 0) {
                		player.sendMessage(ChatColor.RED + "You must specify a player!");
                		return true;
                	}
                	Player target = player.getServer().getPlayer(args[0]);
    				try {

    					}
    						catch (ArrayIndexOutOfBoundsException e) {
    	    					return true;
    					}
    				try {
        				player.sendMessage(ChatColor.DARK_AQUA + target.getName() + ChatColor.GRAY + " is at " + ChatColor.BLUE + target.getLocation().getX() + " , " + target.getLocation().getY() + " , " + target.getLocation().getZ());
    				} catch (NullPointerException e) {
    					player.sendMessage(ChatColor.RED + "Target is not online!");
    					return true;
    					
    				}
    				try {

					if (args[1].equalsIgnoreCase("broadcast")) {
						
					}Bukkit.broadcastMessage(ChatColor.RED + "[Broadcast] " + ChatColor.DARK_AQUA + target.getName() + ChatColor.GRAY + " is at " + ChatColor.BLUE + target.getLocation().getX() + " , " + target.getLocation().getY() + " , " + target.getLocation().getZ());
    				} catch (NullPointerException e) {

					}

                }
                if (!(player.hasPermission("expose.use"))) {
                player.sendMessage(ChatColor.RED + "Insufficient Permission.");
                }

                }
            else {
            	if (args.length == 0) {
            		sender.sendMessage(ChatColor.RED + "You must specify a player!");
            		return true;
            	}
            	Player target = sender.getServer().getPlayer(args[0]);
				try {
				}
					catch (ArrayIndexOutOfBoundsException e) {
    					return true;
				}
				try {
					sender.sendMessage(ChatColor.DARK_AQUA + target.getName() + ChatColor.GRAY + " is at " + ChatColor.BLUE + target.getLocation().getX() + " , " + target.getLocation().getY() + " , " + target.getLocation().getZ());
				} catch (NullPointerException e) {
					sender.sendMessage(ChatColor.RED + "Target is not online!");
					return true;
				}
				try {

				if (args[1].equalsIgnoreCase("broadcast")) {
					Bukkit.broadcastMessage(ChatColor.RED + "[Broadcast] " + ChatColor.DARK_AQUA + target.getName() + ChatColor.GRAY + " is at " + ChatColor.BLUE + target.getLocation().getX() + " , " + target.getLocation().getY() + " , " + target.getLocation().getZ());
				}
				} catch (NullPointerException e) {
}

            }
            } return true;

    }
    @SuppressWarnings("unused")
	private final Main plugin;
    public Expose(Main plugin) {
        this.plugin = plugin;
    }
}