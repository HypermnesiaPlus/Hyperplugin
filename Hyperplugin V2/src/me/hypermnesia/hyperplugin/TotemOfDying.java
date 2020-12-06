//Doesn't work atm and i can't be bothered to fix it. Maybe later.

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
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TotemOfDying implements Listener, CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("totemofdying")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.DARK_GREEN + "Console used Totem of Dying! It wasn't very effective.");
				return true;
			}
			Player player = (Player) sender;
			if(player.hasPermission("totemofdying.use")) {
			if (player.getInventory().firstEmpty() == -1) {
				Location loc = player.getLocation();
				World world = player.getWorld();
				
				world.dropItemNaturally(loc, getItem());
				player.sendMessage(ChatColor.GOLD + "You recieved a Totem of Dying. However your inventory was full so it was dropped on the ground.");
				return false;
			}
			player.getInventory().addItem(getItem());
			player.sendMessage(ChatColor.GOLD + "You recieved a Totem of Dying. Die!");
			return true;
		}
			else {
				player.sendMessage(ChatColor.RED + "You do not have Permission to Become Die");
			}
			
		}	
		return false;
	}
	
	
	public ItemStack getItem( ) {
		
		ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING);
		ItemMeta meta = (ItemMeta) totem.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_GREEN + "Totem of Dying");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Oweif");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.VANISHING_CURSE, 10, true);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.setUnbreakable(true);
		
		totem.setItemMeta(meta);
		
		return totem;
		
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		if(event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
				ItemStack item = player.getInventory().getItemInOffHand();
				if (player.getInventory().getItemInOffHand() != null)
					if (item.getItemMeta() == null || item.getItemMeta().getDisplayName() == null || item.getItemMeta().getLore() == null) {
					if (player.getInventory().getItemInOffHand().getItemMeta().getDisplayName().contains("Totem Of Dying"))
						if (player.getInventory().getItemInOffHand().getItemMeta().hasLore()) {
							player.setHealth(0.0);
						}
					}
		}
		
		}

    @SuppressWarnings("unused")
	private final Main plugin;
    public TotemOfDying(Main plugin) {
        this.plugin = plugin;
    }
}
