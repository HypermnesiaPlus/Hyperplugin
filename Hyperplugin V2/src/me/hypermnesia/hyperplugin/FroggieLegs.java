package me.hypermnesia.hyperplugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Color;
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
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class FroggieLegs implements Listener, CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("FroggieLegs")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.DARK_GREEN + "Console become frog");
				return true;
			}
			Player player = (Player) sender;
			if(player.hasPermission("FroggieLegs.use")) {
			if (player.getInventory().firstEmpty() == -1) {
				Location loc = player.getLocation();
				World world = player.getWorld();
				
				world.dropItemNaturally(loc, getItem());
				player.sendMessage(ChatColor.GOLD + "You recieved a pair Frog Leggings. However your inventory was full so it was dropped on the ground.");
				return false;
			}
			player.getInventory().addItem(getItem());
			player.sendMessage(ChatColor.GOLD + "You recieved a pair Frog Leggings. Have Fun!");
			return true;
		}
			else {
				player.sendMessage(ChatColor.RED + "You do not have Permission to Become Frog");
			}
			
		}	
		return false;
	}
	
	
	public ItemStack getItem( ) {
		
		
		ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
		LeatherArmorMeta meta = (LeatherArmorMeta) leggings.getItemMeta();
		meta.setColor(Color.fromRGB(0,130,0));
		leggings.setItemMeta(meta);
		meta.setDisplayName(ChatColor.DARK_GREEN + "Froggie Leggings");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Extreme Jump Boost while Worn");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 20, true);
		meta.addEnchant(Enchantment.THORNS, 15, true);
		meta.addEnchant(Enchantment.DEPTH_STRIDER, 15, true);
		meta.addEnchant(Enchantment.VANISHING_CURSE, 10, true);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.setUnbreakable(true);
		
		leggings.setItemMeta(meta);
		
		return leggings;
	}
	
	
	@EventHandler
	public void onJump(PlayerMoveEvent event) {
		Player player = (Player)event.getPlayer();
		if (player.getInventory().getLeggings() != null)
			if (player.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Froggie Leggings"))
				if (player.getInventory().getLeggings().getItemMeta().hasLore())
					if(event.getFrom().getY() < event.getTo().getY() &&
							player.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR) {
						player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));
					}
	}
	
	@EventHandler
	public void onFall(EntityDamageEvent event) {
		if(event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			if (event.getCause() == DamageCause.FALL) {
				if (player.getInventory().getLeggings() != null)
					if (player.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Froggie Leggings"))
						if (player.getInventory().getLeggings().getItemMeta().hasLore()) {
							event.setCancelled(true);
						}
			}
		}
	}
    @SuppressWarnings("unused")
	private final Main plugin;
    public FroggieLegs(Main plugin) {
        this.plugin = plugin;
    }
}
