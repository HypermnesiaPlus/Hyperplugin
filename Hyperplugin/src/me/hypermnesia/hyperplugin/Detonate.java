package me.hypermnesia.hyperplugin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Detonate implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("detonate")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "boom");
				return true;
			}
			Player player = (Player) sender;
            if (player.hasPermission("detonate.use")) {
                player.sendMessage(ChatColor.RED + "Nuke Inbound in 10 Seconds!");
                player.playSound(player.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 2.0F,1.0F);
                try {
					Thread.sleep(5000);
                    player.sendMessage(ChatColor.RED + "Nuke Inbound in 5 Seconds!");
                    Thread.sleep(1000);
                    player.sendMessage(ChatColor.RED + "Nuke Inbound in 4 Seconds!");
                    Thread.sleep(1000);
                    player.sendMessage(ChatColor.RED + "Nuke Inbound in 3 Seconds!");
                    Thread.sleep(1000);
                    player.sendMessage(ChatColor.RED + "Nuke Inbound in 2 Seconds!");
                    Thread.sleep(1000);
                    player.sendMessage(ChatColor.RED + "Nuke Inbound in 1 Seconds!");
                    Thread.sleep(1000);
                    player.sendMessage(ChatColor.DARK_RED + "I am detonating.");
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_DEATH, 2.0F,1.0F);
                    Thread.sleep(500);
        			World world = player.getWorld();
    				Location loc = player.getLocation();
        			world.createExplosion(loc, 100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
		}
		return false;

            }

    @SuppressWarnings("unused")
	private final Main plugin;
    public Detonate(Main plugin) {
        this.plugin = plugin;
    }
}