package me.hypermnesia.botify;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	@Override
    public void onEnable() {

    }
	@Override
    public void onDisable() {

    }


    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if(label.equalsIgnoreCase("botify")) {
            if(sender instanceof Player) {
                Player player =(Player) sender;
                if (player.hasPermission("botify.use")) {
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Hey i am a bot lol");
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&1D&2e&3a&4d &5B&6o&7d&8y &9R&ae&bp&co&dr&et&f&1&2d"));
                    return true;
                }
                player.sendMessage(ChatColor.RED + "u has no permission so I h8 u");


                }
            else{
                sender.sendMessage(ChatColor.DARK_BLUE + "Guess console is a bot too");

            } return true;

        }

        return false;

    }

}