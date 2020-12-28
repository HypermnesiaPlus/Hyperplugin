package me.hypermnesia.hyperplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetHelp implements CommandExecutor {

    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if(label.equalsIgnoreCase("gethelp")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("gethelp.use")) {
                    player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "You Know... I would make a help command but when you have like 20 commands and you plan to sort them in alphabetical order its very boring and time consming to constantly redo the help command. Maybe one day I will add it but that day is not today! Use /help hyperplugin for now.");           
                    }

                
                player.sendMessage(ChatColor.RED + "Nu Permission");

                }
                
            }
            else{
                sender.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "You Know... I would make a help command but when you have like 20 commands and you plan to sort them in alphabetical order its very boring and time consming to constantly redo the help command. Maybe one day I will add it but that day is not today! Use /help hyperplugin for now.");

            } return true;


    }
    @SuppressWarnings("unused")
	private final Main plugin;
    public GetHelp(Main plugin) {
        this.plugin = plugin;
    }
}