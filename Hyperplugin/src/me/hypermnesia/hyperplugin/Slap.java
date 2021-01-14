package me.hypermnesia.hyperplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Slap implements CommandExecutor {

    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if(label.equalsIgnoreCase("slap")) {
            if(sender instanceof Player) {
                Player player =(Player) sender;
                if (player.hasPermission("slap.use")) {
                	if (args.length == 0) {
                		player.sendMessage(ChatColor.RED + "You must specify a player!");
                		return true;
                	}
                	Player target = player.getServer().getPlayer(args[0]);
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Target Has Been Slapped");
					target.setVelocity(player.getLocation().getDirection().multiply(2).setX(5));

                    
                    return true;
                }
                player.sendMessage(ChatColor.RED + "You dont have permissions to slap nerds.");


                }
            else{
                sender.sendMessage(ChatColor.LIGHT_PURPLE + "Thou hath been Slapped. jk");

            } return true;

        }

        return false;

    }
    @SuppressWarnings("unused")
	private final Main plugin;
    public Slap(Main plugin) {
        this.plugin = plugin;
    }
}