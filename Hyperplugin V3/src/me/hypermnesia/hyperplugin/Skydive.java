package me.hypermnesia.hyperplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Skydive implements CommandExecutor {

    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if(label.equalsIgnoreCase("Skydive")) {
                if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_GREEN + "Consoles can't MLG water bucket :(");
                return true;
            }
               Player player = (Player) sender;
            if(player.hasPermission("skydive.use")){
                if(args.length == 0) {
                player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Good Luck trying to MLG. Your life depends on it.");
                player.setVelocity(player.getLocation().getDirection().multiply(1).setY(1000));
                  return true;
                }
            }
            else {
                player.sendMessage(ChatColor.RED + "You have no Permission to go Skydiving.");
                return false;
        }
        }   
        return false;
        
    }
    @SuppressWarnings("unused")
	private final Main plugin;
    public Skydive(Main plugin) {
        this.plugin = plugin;
    }
}
