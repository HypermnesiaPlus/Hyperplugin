package me.hypermnesia.hyperplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HUsage implements CommandExecutor {

	
    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if(label.equalsIgnoreCase("husage")) {
            if(sender instanceof Player) {
                Player player =(Player) sender;
                if (player.hasPermission("husage.use")) {
             	   player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "==================Hyperplugin Help Commands==================");
                   player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "1. HHelp - /HHelp.");
                   player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "2. HUsage - /HUsage.");
                   player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "3. Creator - /Creator");
            	   player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "========================Fun Commands=========================");
                   player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "1. AirstrikeMarker - /AirstrikeMarker | Aliases: /asm");
                   player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "2. Botify - /Botify");
                   player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "3. ChangeTeam - /ChangeTeam");
                   player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "4. DiscordBot - /DiscordBot (Doesn't Work rn.)");
                   player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "5. FroggieLegs - /FroggieLegs");
                   player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "6. Getaway - /Getaway");
                   player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "7. Launch - /Launch | Aliases: /lch");
                   player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "8. Medic - /Medic");
                   player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "9. OmegaTrident - /OmegaTrident");
                   player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "10. OPAxe - /OPAxe");
                   player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "11. PVP - /PVP");
                   player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "12. Skydive - /Skydive");
                   player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "13. Suicide - /Suicide");
                   player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "14. WhiteFart - /WhiteFart");
                   player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "============================================================");
                   player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "NOTICE: All Commands require Permission to execute!");
                    return true;
                }
                player.sendMessage(ChatColor.RED + "Imagine not having permission to use help usages.");


                }
            else{
          	   sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "==================Hyperplugin Help Commands==================");
               sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "1. HHelp - /HHelp.");
               sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "2. HUsage - /HUsage.");
               sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "3. Creator - /Creator");
               sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "========================Fun Commands=========================");
               sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "1. AirstrikeMarker - /AirstrikeMarker");
               sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "2. Botify - /Botify");
               sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "3. ChangeTeam - /ChangeTeam");
               sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "4. DiscordBot - /DiscordBot");
               sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "5. FroggieLegs - /FroggieLegs");
               sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "6. Getaway - /Getaway");
               sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "7. Launch - /Launch");
               sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "8. Medic - /Medic");
               sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "9. OmegaTrident - /OmegaTrident");
               sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "10. OPAxe - /OPAxe");
               sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "11. PVP - /PVP");
               sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "12. Skydive - /Skydive");
               sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "13. Suicide - /Suicide");
               sender.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "14. WhiteFart - /WhiteFart");
               sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "============================================================");
               sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Fun Fact! You're Console so you get Diffrent Responses when Executing each command!");
            } return true;

        }

        return false;

    }
    @SuppressWarnings("unused")
	private final Main plugin;
    public HUsage(Main plugin) {
        this.plugin = plugin;
    }
}