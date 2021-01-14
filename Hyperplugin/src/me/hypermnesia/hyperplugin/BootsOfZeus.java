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
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BootsOfZeus implements Listener, CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("bootsofzeus")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.DARK_GREEN + "console is console not zeus");
				return true;
			}
			Player player = (Player) sender;
			if(player.hasPermission("bootsofzeus.use")) {
			if (player.getInventory().firstEmpty() == -1) {
				Location loc = player.getLocation();
				World world = player.getWorld();
				
				world.dropItemNaturally(loc, getItem());
				player.sendMessage(ChatColor.GOLD + "You recieved a thing that fell out of the sky. However your inventory was full so it was dropped on the ground.");
				return false;
			}
			player.getInventory().addItem(getItem());
			player.sendMessage(ChatColor.GOLD + "You recieved a thing that fell out of the sky. Maybe try wearing them!");
			return true;
		}
			else {
				player.sendMessage(ChatColor.RED + "You do not have Permission to get wierd boots that fell out of the sky.");
			}
			
		}	
		return false;
	}
	
	
	public ItemStack getItem( ) {
		
		
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta meta = (ItemMeta) boots.getItemMeta();
		boots.setItemMeta(meta);
		meta.setDisplayName(ChatColor.GOLD +  "" + ChatColor.BOLD + "Boots of Zeus");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', "&1ooh&b SHINY!"));
		meta.setLore(lore);
		meta.addEnchant(Enchantment.DEPTH_STRIDER, 25, true);
		meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.setUnbreakable(true);
		
		boots.setItemMeta(meta);
		
		return boots;
	}
	
	
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		Player player = (Player)event.getPlayer();
        Location loc = player.getLocation();
		if (player.getInventory().getBoots() != null)
			if (player.getInventory().getBoots().getItemMeta().getDisplayName().contains(ChatColor.GOLD +  "" + ChatColor.BOLD + "Boots of Zeus"))
				if (player.getInventory().getBoots().getItemMeta().hasLore())
                    loc.getWorld().strikeLightning(loc);
					}
	

    @SuppressWarnings("unused")
	private final Main plugin;
    public BootsOfZeus(Main plugin) {
        this.plugin = plugin;
    }
}
