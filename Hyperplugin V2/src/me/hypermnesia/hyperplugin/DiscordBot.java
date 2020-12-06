package me.hypermnesia.hyperplugin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscordBot implements CommandExecutor {

	public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if(label.equalsIgnoreCase("discordbot")) {
            if(sender instanceof Player) {
                Player player =(Player) sender;
                if (player.hasPermission("discordbot.use")) {
                    if (args.length == 0) {
                    	player.sendMessage(ChatColor.DARK_RED + "Invalid Answer");
                    	
                    } else {
                    	if (args[0].equalsIgnoreCase("@everyone")) {
                            player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "OK SENT");
                            File file = new File(Main.getPlugin(Main.class).getDataFolder() + "/file.tx");
                            try {
                        	    FileWriter fileWriter = new FileWriter(file);
                        	    PrintWriter printWriter = new PrintWriter(fileWriter);
                        	    printWriter.print(args[0] + "\n");
                        	    printWriter.flush();
                        	    printWriter.close();
                        	}
                             catch (IOException e) {
                            	 e.printStackTrace();
                             }
                          }
                       
                            else {
                            player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "OK SENT");
                            File file = new File(Main.getPlugin(Main.class).getDataFolder() + "/file.tx");
                            try {
                        	    FileWriter fileWriter = new FileWriter(file);
                        	    PrintWriter printWriter = new PrintWriter(fileWriter);
                        	    printWriter.print(args[0] + "\n");
                        	    printWriter.flush();
                        	    printWriter.close();
                        	}
                             catch (IOException e) {
                            	 e.printStackTrace();
                             }
                    	}
                    	}
                    return false;
                }
                player.sendMessage(ChatColor.RED + "U has no perm to make ppl mad");
                	return false;}}
		return false;
		
    }
    @SuppressWarnings("unused")
	private final Main plugin;
    public DiscordBot(Main plugin) {
        this.plugin = plugin;
    }
}
