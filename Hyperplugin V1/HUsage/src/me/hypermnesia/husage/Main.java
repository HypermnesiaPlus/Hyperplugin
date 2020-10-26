package me.hypermnesia.husage;

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
        if(label.equalsIgnoreCase("husage")) {
            if(sender instanceof Player) {
                Player player =(Player) sender;
                if (player.hasPermission("husage.use")) {
                	   player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "=================Hyperplugin Commands Usages=================");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "1. HHelp - /HHelp");
              	       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "2. HUsage - /HUsage");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "3. Botify - /Botify");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "4. Launch - /Launch <number>");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "5. Medic - /Medic");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "6. Suicide - /Suicide");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "7. Skydive - /Sydive");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "8. FroggieLegs - /FroggieLegs");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "9. Axe - /Axe");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "10. Getaway - /Getaway");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "11. OmegaTrident - /OmegaTrident");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "12. AirstrikeMarker - /AirstrikeMarker");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "13. Changeteam - /ChangeTeam");
                       player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "14. PVP - /PVP");
                       player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "===========================================================");
                       player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "NOTICE: All Commands require OP to execute!");
                    return true;
                }
                player.sendMessage(ChatColor.RED + "Imagine not having permission to use help usages.");


                }
            else{
            	  sender.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "==================Hyperplugin Commands Usages==================");
         	      sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "1. HHelp - /HHelp");
         	      sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "2. HUsage - /HUsage");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "3. Botify - /Botify");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "4. Launch - /Launch <number>");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "5. Medic - /Medic");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "6. Suicide - /Suicide");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "7. Skydive - /Sydive");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "8. FroggieLegs - /FroggieLegs");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "9. Axe - /Axe");
               	  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "10. Getaway - /Getaway");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "11. OmegaTrident - /OmegaTrident");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "12. AirstrikeMarker - /AirstrikeMarker");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "13. Changeteam - /ChangeTeam");
                  sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "14. PVP - /PVP");
                  sender.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "===============================================================");
                  sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Fun Fact! You're Console so you get Diffrent Responses when Executing each command!");
            } return true;

        }

        return false;

    }

}