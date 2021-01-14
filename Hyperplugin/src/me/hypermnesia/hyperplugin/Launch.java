package me.hypermnesia.hyperplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Launch implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
		if(label.equalsIgnoreCase("launch") || label.equalsIgnoreCase("lch")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.AQUA + "Err I don't think Consoles can fly");
				return true;
			}
			Player player = (Player) sender;
            if (player.hasPermission("Launch.use")) {
            	if(args.length == 0) {
				player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "You have been Yeeted");
				player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));
				
				return true;
			}
			
		if (isNum(args[0])) {
			if (Integer.parseInt(args[0]) > 25) {
				player.sendMessage(ChatColor.RED + "are you trying to crash the server?");
				return false;
			}
			player.sendMessage(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "You have been Yeeted");
			player.setVelocity(player.getLocation().getDirection().multiply(Integer.parseInt(args[0])).setY(2));
            }
		
		}
		else {
			player.sendMessage(ChatColor.RED + "Lol you have no Permission to get yeeted in the air.");
		}	
			return true;
		}
		return false;
		
	}
	
	public boolean isNum(String num) {
		try {
			Integer.parseInt(num);
		} catch (Exception e) {
				return false;
		}
			return true;
		}

    @SuppressWarnings("unused")
	private final Main plugin;
    public Launch(Main plugin) {
        this.plugin = plugin;
    }

}
