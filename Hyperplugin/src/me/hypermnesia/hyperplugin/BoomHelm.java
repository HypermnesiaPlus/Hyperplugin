package me.hypermnesia.hyperplugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BoomHelm implements Listener, CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("boomhelm")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.DARK_GREEN + "console boom");
				return true;
			}
			Player player = (Player) sender;
			if(player.hasPermission("boomhelm.use")) {
			if (player.getInventory().firstEmpty() == -1) {
				Location loc = player.getLocation();
				World world = player.getWorld();
				
				world.dropItemNaturally(loc, getItem());
				player.sendMessage(ChatColor.GOLD + "You recieved a boom boom thing. However your inventory was full so it was dropped on the ground.");
				return false;
			}
			player.getInventory().addItem(getItem());
			player.sendMessage(ChatColor.GOLD + "You recieved a boom boom thing. Maybe try wearing it!");
			return true;
		}
			else {
				player.sendMessage(ChatColor.RED + "You do not have Permission to get wierd helm that goes boom.");
			}
			
		}	
		return false;
	}
	
	
	public ItemStack getItem( ) {
		
		
		ItemStack helm = new ItemStack(Material.IRON_HELMET);
		ItemMeta meta = (ItemMeta) helm.getItemMeta();
		helm.setItemMeta(meta);
		meta.setDisplayName(ChatColor.RED +  "" + ChatColor.BOLD + "Boom Helm");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', "&awot&3 BOOM BOOM!"));
		meta.setLore(lore);
		meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 25, true);
		meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.setUnbreakable(true);
		
		helm.setItemMeta(meta);
		
		return helm;
	}
	
	
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		Player player = (Player)event.getPlayer();
        Location loc = player.getLocation();
		if (player.getInventory().getHelmet() != null)
			if (player.getInventory().getHelmet().getItemMeta().getDisplayName().contains(ChatColor.RED +  "" + ChatColor.BOLD + "Boom Helm"))
				if (player.getInventory().getHelmet().getItemMeta().hasLore())
                    player.getPlayer().getWorld().spawnEntity(loc, EntityType.PRIMED_TNT);
					}
	

    @SuppressWarnings("unused")
	private final Main plugin;
    public BoomHelm(Main plugin) {
        this.plugin = plugin;
    }
}
