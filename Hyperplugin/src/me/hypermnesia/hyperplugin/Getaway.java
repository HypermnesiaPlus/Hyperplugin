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
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Getaway implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("Getaway")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "What now. Did you commit another crime?");
				return true;
			}
			Player player = (Player) sender;
            if (player.hasPermission("getaway.use")) {
			if (player.getInventory().firstEmpty() == -1) {
				Location loc = player.getLocation();
				World world = player.getWorld();
				
				world.dropItemNaturally(loc, getItem());
				player.sendMessage(ChatColor.GOLD + "You recieved a Getaway Pearl. However your inventory was full so it was dropped on the ground.");
				return false;
			}
			player.getInventory().addItem(getItem());
			player.sendMessage(ChatColor.GOLD + "You recieved a Getaway Pearl. Quick! Make your escape!");
			return true;
            }
            player.sendMessage(ChatColor.RED + "You have no Permission to Make a Quick Escape.");
            }
			
			
		return false;
	}
	
	
	public ItemStack getItem( ) {
		
		
		ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL);
		ItemMeta meta = (ItemMeta) enderpearl.getItemMeta();
		enderpearl.setItemMeta(meta);
		meta.setDisplayName(ChatColor.BLUE +  "" + ChatColor.BOLD + "Getaway Pearl");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.AQUA + "" + ChatColor.ITALIC + "Make your Escape!");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 25, true);
		meta.addEnchant(Enchantment.VANISHING_CURSE, 10, true);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		enderpearl.setItemMeta(meta);
		
		return enderpearl;

	}
    @SuppressWarnings("unused")
	private final Main plugin;
    public Getaway(Main plugin) {
        this.plugin = plugin;
    }
}