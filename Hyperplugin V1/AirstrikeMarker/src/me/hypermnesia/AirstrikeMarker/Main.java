package me.hypermnesia.AirstrikeMarker;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	public List<String> list = new ArrayList<String>();

@Override
public void onEnable() {
	
	this.getServer().getPluginManager().registerEvents(this, this);

	}

@Override
public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("AirstrikeMarker") || label.equalsIgnoreCase("asm")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.DARK_AQUA + "Console has no bombs to drop today. :(");
				return true;
			}
			Player player = (Player) sender;
            if (player.hasPermission("airstrikemarker.use")) {
            		if (player.getInventory().firstEmpty() == -1) {
				Location loc = player.getLocation();
				World world = player.getWorld();
				
				world.dropItemNaturally(loc, getItem());
				player.sendMessage(ChatColor.GOLD + "You found an Airstrike Marker. However your inventory was full so it was dropped on the ground.");
				return false;
			}
			player.getInventory().addItem(getItem());
			player.sendMessage(ChatColor.GOLD + "You found an Airstrike Marker. Boom!");
			return true;
		}
		 else {
			player.sendMessage(ChatColor.RED + "You have no Permission to bomb the terrain.");
            }
		return false;
		}
		return false;
	
	}
	
	
	public ItemStack getItem( ) {
		
		
		ItemStack CROSSBOW = new ItemStack(Material.CROSSBOW);
		ItemMeta meta = (ItemMeta) CROSSBOW.getItemMeta();
		CROSSBOW.setItemMeta(meta);
		meta.setDisplayName(ChatColor.DARK_RED +  "" + ChatColor.BOLD + "Airstrike Marker");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', ""));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7(Left Click)&a Shoot Arrows"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7(Right Click)&a Call Airstrikes &6(Needs Fireworks)"));
		meta.setLore(lore);
		meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.setUnbreakable(true);
		
		CROSSBOW.setItemMeta(meta);
		
		return CROSSBOW;
	}
	@EventHandler()
	public void	 onClick(PlayerInteractEvent event) {
		 if(event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.CROSSBOW))
			if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
				Player player = (Player) event.getPlayer();
				if (event.getAction() == Action.RIGHT_CLICK_AIR) {
					if(!(list.contains(player.getName())))
							list.add(player.getName());
					return;
				}
				if (event.getAction() == Action.LEFT_CLICK_AIR) {
					player.launchProjectile(Arrow.class);
				}
					
			}
		 if(list.contains(event.getPlayer().getName())) {
			 list.remove(event.getPlayer().getName());
		 }
	}
	@EventHandler
	public void onLand(ProjectileHitEvent event) {
		if (event.getEntityType() == EntityType.FIREWORK) {
			if (event.getEntity().getShooter() instanceof Player) {
				Player player = (Player) event.getEntity().getShooter();
				if (list.contains(player.getName())) {
					Location loc = event.getEntity().getLocation();
					loc.setY(loc.getY() + 1);
					
						for (int i = 1; i < 255 ; i++) {
							loc.getWorld().spawnEntity(loc, EntityType.PRIMED_TNT);
							loc.setX(loc.getX() + i);
						}
				}
			}
		}
	}
}