package me.hypermnesia.hyperplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class UnnaturalRegeneration implements CommandExecutor {

    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if(label.equalsIgnoreCase("unnaturalregeneration")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("unnaturalregeneration")) {
                    player.sendMessage(ChatColor.BLUE + "Thats not normal...");
                    player.addPotionEffect((new PotionEffect(PotionEffectType.HEAL, 777, 0)));
                    return true;
                }
                player.sendMessage(ChatColor.RED + "You have no permission to heal like mad");


                }
            else{
                sender.sendMessage(ChatColor.RED + "console regens");

            } return true;

        }

        return false;

    }
    @SuppressWarnings("unused")
	private final Main plugin;
    public UnnaturalRegeneration(Main plugin) {
        this.plugin = plugin;
    }
}