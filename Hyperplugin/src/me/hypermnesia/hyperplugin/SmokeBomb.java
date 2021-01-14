package me.hypermnesia.hyperplugin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SmokeBomb implements CommandExecutor {

    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if(label.equalsIgnoreCase("smokebomb")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("smokebomb.use")) {
                        player.sendMessage(ChatColor.GRAY + "ight imma head out");
                            for (int x = 0; x < 10; x++) {
                                Location loc = player.getLocation();
                                loc.setX(loc.getX());
                                loc.setY(loc.getY());
                                player.getPlayer().getWorld().spawnEntity(loc, EntityType.AREA_EFFECT_CLOUD);
                                player.addPotionEffect((new PotionEffect(PotionEffectType.INVISIBILITY, 777, 6)));


                    } 
                            return true;
                }
                player.sendMessage(ChatColor.RED + "You don't have permission head out.");


            }
            else{
                sender.sendMessage(ChatColor.GRAY + "console is already hidden from the slaves commonly refered to as the players.");

            } return true;
            }
		return false;
        

        

    }
    @SuppressWarnings("unused")
    private final Main plugin;
    public SmokeBomb(Main plugin) {
        this.plugin = plugin;
    }
}