package me.hypermnesia.hyperplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.Location;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {

    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if(label.equalsIgnoreCase("spawn")) {
            if(sender instanceof Player) {
                Player player =(Player) sender;
                if (player.hasPermission("spawn.use")) {
                    Location spawnpoint = Bukkit.getServer().getWorld("world").getSpawnLocation();
                    Location loc = new Location(Bukkit.getWorld("world"), spawnpoint.getX(),spawnpoint.getY(),spawnpoint.getZ());
                    player.teleport(loc);
                    player.sendMessage(ChatColor.GREEN + "You have been sent to the world spawnpoint!");
                    return true;
                }
                player.sendMessage(ChatColor.RED + "You have no permission to teleport to spawn lol.");


            }
            else{
                sender.sendMessage(ChatColor.DARK_BLUE + "Console, you cant teleport!");

            } return true;

        }

        return false;

    }
    @SuppressWarnings("unused")
    private final Main plugin;
    public Spawn(Main plugin) {
        this.plugin = plugin;
    }
}