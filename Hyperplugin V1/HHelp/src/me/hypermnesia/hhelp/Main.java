package me.hypermnesia.hhelp;

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
        if(label.equalsIgnoreCase("hhelp")) {
            if(sender instanceof Player) {
                Player player =(Player) sender;
                if (player.hasPermission("hhelp.use")) {
                	   player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "===================Hyperplugin Help Commands===================");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "1. HHelp - Displays all the commands.");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "2. HUsage - Displays all the Usages for al the commands.");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "3. Botify - My First Command!");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "4. Launch - Launches you into the sky!");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "5. Medic - Heals you!");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "6. Suicide - Take the easy way out!");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "7. Skydive - Test your MLG Water Bucket Skills!");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "8. FroggieLegs - Become a frog!");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "9. Axe - Recieve an axe!");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "10. Getaway - Recieve a Getaway Pearl!");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "11. OmegaTrident - Recieve a Deadly Trident!");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "12. AirstrikeMarker - Recieve a Airstrike Marker! (Needs Fireworks)");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "13. Changeteam - Change your team!");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "14. PVP - Recieve a pvp kit!");
                       player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "============================================================");
                       player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "NOTICE: All Commands require OP to execute!");
                    return true;
                }
                player.sendMessage(ChatColor.RED + "Imagine not having permission to use help commands.");


                }
            else{
            	  sender.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "===================Hyperplugin Help Commands===================");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "1. HHelp - Displays all the commands.");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "2. HUsage - Displays all the Usages for all the commands.");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "3. Botify - My First Command!");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "4. Launch - Launches you into the sky!");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "5. Medic - Heals you!");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "6. Suicide - Take the easy way out!");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "7. Skydive - Test your MLG Water Bucket Skills!");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "8. FroggieLegs - Become a frog!");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "9. Axe - Recieve an axe!");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "10. Getaway - Recieve a Getaway Pearl!");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "11. OmegaTrident - Recieve a Deadly Trident!");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "12. AirstrikeMarker - Recieve a Airstrike Marker! (Requires Fireworks)");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "13. Changeteam - Change your team!");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "14. PVP - Recieve a pvp kit!");
                  sender.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "================================================================");
                  sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Fun Fact! You're Console so you get Diffrent Responses when Executing each command!");
            } return true;

        }

        return false;

    }

}