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
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OPAxe implements CommandExecutor {
	

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("OPAxe")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.YELLOW + "Console Get OPAxe");
				return true;
			}
			Player player = (Player) sender;
            if (player.hasPermission("opaxe.use")) {
			if (player.getInventory().firstEmpty() == -1) {
				Location loc = player.getLocation();
				World world = player.getWorld();
				
				world.dropItemNaturally(loc, getItem());
				player.sendMessage(ChatColor.GOLD + "You recieved a OPAxe. However your inventory was full so it was dropped on the ground.");
				return false;
			}
			player.getInventory().addItem(getItem());
			player.sendMessage(ChatColor.GOLD + "You recieved a OPAxe. Stabby Stabby.");
			return true;
		}
		 else {
			player.sendMessage(ChatColor.RED + "You have no Permission to Recieve Stabby Stabby.");
			return false;
		}

	}
		return false;
	
	}
	
	
	public ItemStack getItem() {
		
		
		ItemStack AXE = new ItemStack(Material.STONE_AXE);
		ItemMeta meta = (ItemMeta) AXE.getItemMeta();
		AXE.setItemMeta(meta);
		meta.setDisplayName(ChatColor.RED + "Just a Normal Axe");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Pro tip. Axes disable shields.");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.VANISHING_CURSE, 10, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 250, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 50, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setUnbreakable(true);
		
		AXE.setItemMeta(meta);
		
		return AXE;
	}
    @SuppressWarnings("unused")
	private final Main plugin;
    public OPAxe(Main plugin) {
        this.plugin = plugin;
    }
}
	
