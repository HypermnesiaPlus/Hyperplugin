package me.hypermnesia.hyperplugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Flambe implements Listener, CommandExecutor{
	

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("flambe") || label.equalsIgnoreCase("flamethrower")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "flambe");
				return true;
			}
			Player player = (Player) sender;
            if (player.hasPermission("flambe.use")) {
            		if (player.getInventory().firstEmpty() == -1) {
				Location loc = player.getLocation();
				World world = player.getWorld();
				
				world.dropItemNaturally(loc, getItem());
				player.sendMessage(ChatColor.RED + "Flame dropped");
				return false;
			}
			player.getInventory().addItem(getItem());
			player.sendMessage(ChatColor.GOLD + "flambe");
			return true;
		}
		 else {
			player.sendMessage(ChatColor.RED + "You have no Permission to burn things using a hand held flamethrower");
            }
		return false;
		}
		return false;
	
	}
	
	
	public ItemStack getItem( ) {
		
		
		ItemStack powder = new ItemStack(Material.BLAZE_ROD);
		ItemMeta meta = (ItemMeta) powder.getItemMeta();
		powder.setItemMeta(meta);
		meta.setDisplayName(ChatColor.RED + "Flammenwerfer 35");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7(Right Click)&c Spread fires"));
		meta.setLore(lore);
		meta.addEnchant(Enchantment.FIRE_ASPECT, 32767, true);
		meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.setUnbreakable(true);
		
		powder.setItemMeta(meta);
		
		return powder;
	}
	@EventHandler()
	public void	 onClick(PlayerInteractEvent event) {
		 if(event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.BLAZE_ROD))
			if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
				Player player = (Player) event.getPlayer();
				if (event.getAction() == Action.RIGHT_CLICK_AIR ||event.getAction() == Action.RIGHT_CLICK_BLOCK) {
					if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains(ChatColor.RED + "Flammenwerfer 35"))
						if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
					player.launchProjectile(SmallFireball.class);
					player.playSound(player.getLocation(), Sound.ITEM_FIRECHARGE_USE, 2.0F, 1.0F);
				}
			}
			}
	}

    @SuppressWarnings("unused")
	private final Main plugin;
    public Flambe(Main plugin) {
        this.plugin = plugin;
    }
}