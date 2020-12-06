package me.hypermnesia.hyperplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HHelp implements CommandExecutor {


    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if(label.equalsIgnoreCase("hhelp")) {
            if(sender instanceof Player) {
                Player player =(Player) sender;
                if (player.hasPermission("hhelp.use")) {
                	   player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "==================Hyperplugin Help Commands==================");
                       player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "1. HHelp - Displays all the commands.");
                       player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "2. HUsage - Displays all the Usages for al the commands.");
                       player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "3. Creator - Displays the Creator of Hyperplugin");
                	   player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "========================Fun Commands=========================");
                       player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "1. AirstrikeMarker - Recieve a Airstrike Marker! (Needs Fireworks)");
                       player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "2. Botify - My First Command!");
                       player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "3. ChangeTeam - Change your team!");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "4. DiscordBot - Hijack the discord bot! (Doesn't Work rn.)");
                       player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "5. FroggieLegs - Become a frog!");
                       player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "6. Getaway - Recieve a Getaway Pearl!");
                       player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "7. Launch - Launches you into the sky!");
                       player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "8. Medic - Heals you!");
                       player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "9. OmegaTrident - Recieve a Deadly Trident!");
                       player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "10. OPAxe - Recieve an OPAxe!");
                       player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "11. PVP - Recieve a pvp kit!");
                       player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "12. Skydive - Test your MLG Water Bucket Skills!");
                       player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "13. Suicide - Take the easy way out!");
                       player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "14. WhiteFart - NANI!");
                       player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "============================================================");
                       player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "NOTICE: All Commands require Permission to execute!");
                    return true;
                }
                player.sendMessage(ChatColor.RED + "Imagine not having permission to use help commands.");


                }
            else{
         	      sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "==================Hyperplugin Help Commands==================");
                  sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "1. HHelp - Displays all the commands.");
                  sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "2. HUsage - Displays all the Usages for al the commands.");
                  sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "3. Creator - Displays the Creator of Hyperplugin");
        	      sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "========================Fun Commands=========================");
                  sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "1. AirstrikeMarker - Recieve a Airstrike Marker! (Needs Fireworks)");
                  sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "2. Botify - My First Command!");
                  sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "3. Changeteam - Change your team!");
                  sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "4. DiscordBot - Hijack the discord bot!");
                  sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "5. FroggieLegs - Become a frog!");
                  sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "6. Getaway - Recieve a Getaway Pearl!");
                  sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "7. Launch - Launches you into the sky!");
                  sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "8. Medic - Heals you!");
                  sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "9. OmegaTrident - Recieve a Deadly Trident!");
                  sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "10. OPAxe - Recieve an OPAxe!");
                  sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "11. PVP - Recieve a pvp kit!");
                  sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "12. Skydive - Test your MLG Water Bucket Skills!");
                  sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "13. Suicide - Take the easy way out!");
                  sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "14. WhiteFart - NANI!");
                  sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "============================================================");
                  sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Fun Fact! You're Console so you get Diffrent Responses when Executing each command!");
            } return true;

        }

        return false;

    }
    @SuppressWarnings("unused")
	private final Main plugin;
    public HHelp(Main plugin) {
        this.plugin = plugin;
    }
}