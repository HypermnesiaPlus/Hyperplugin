package me.hypermnesia.hyperplugin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Brainstorm implements CommandExecutor {

    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if(label.equalsIgnoreCase("brainstorm")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("brainstorm.use")) {
                        player.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "become big smort");
                            for (int x = 2; x < 1000; x++) {
                                player.giveExp(777);
                                int randX = (int) (Math.random() * 50) + 1;
                                int randY = (int) (Math.random() * 50) + 1;
                                Location loc = player.getLocation();
                                loc.setX(loc.getX() + randX);
                                loc.setY(loc.getY() + randY);
                                player.getPlayer().getWorld().spawnEntity(loc, EntityType.EXPERIENCE_ORB);


                    } 
                            return true;
                }
                player.sendMessage(ChatColor.RED + "You don't have permission to become big smort.");


            }
            else{
                sender.sendMessage(ChatColor.GREEN + "console smort.");

            } return true;
            }
		return false;
        

        

    }
    @SuppressWarnings("unused")
    private final Main plugin;
    public Brainstorm(Main plugin) {
        this.plugin = plugin;
    }
}