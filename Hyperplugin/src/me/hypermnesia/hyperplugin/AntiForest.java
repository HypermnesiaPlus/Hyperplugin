package me.hypermnesia.hyperplugin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AntiForest implements CommandExecutor {

    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if(label.equalsIgnoreCase("antiforest")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("antiforest.use")) {
                        player.sendMessage(ChatColor.RED + "FOREST FIREEEEEE wait u r on fire");
                            for (int x = 1; x < 20; x++) {
                                int randX = (int) (Math.random() * 50) + 1;
                                int randY = (int) (Math.random() * 50) + 1;
                                Location loc = player.getLocation();
                                loc.setX(loc.getX() + randX);
                                loc.setY(loc.getY() + randY);
                                loc.getWorld().strikeLightning(loc);
                            }
                    return true;
                }
                player.sendMessage(ChatColor.RED + "You hav no permission to burn forests");


            }
            else{
                sender.sendMessage(ChatColor.DARK_BLUE + "e fire");

            } return true;

        }

        return false;

    }
    @SuppressWarnings("unused")
    private final Main plugin;
    public AntiForest(Main plugin) {
        this.plugin = plugin;
    }
}