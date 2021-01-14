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
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WhiteFart implements Listener, CommandExecutor{
	
	public List<String> list = new ArrayList<String>();


	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("WhiteFart")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.WHITE + "Console has farts");
				return true;
			}
			Player player = (Player) sender;
            if (player.hasPermission("WhiteFart.use")) {
            		if (player.getInventory().firstEmpty() == -1) {
				Location loc = player.getLocation();
				World world = player.getWorld();
				
				world.dropItemNaturally(loc, getItem());
				player.sendMessage(ChatColor.GOLD + "You found an weird snowball. However your inventory was full so it was dropped on the ground.");
				return false;
			}
			player.getInventory().addItem(getItem());
			player.sendMessage(ChatColor.GOLD + "You found an weird snowball. Hmmm");
			return true;
		}
		 else {
			player.sendMessage(ChatColor.RED + "You have no Permission to grab white farts.");
            }
		return false;
		}
		return false;
	
	}
	
	
	public ItemStack getItem( ) {
		
		
		ItemStack SNOWBALL = new ItemStack(Material.SNOWBALL);
		ItemMeta meta = (ItemMeta) SNOWBALL.getItemMeta();
		SNOWBALL.setItemMeta(meta);
		meta.setDisplayName(ChatColor.WHITE +  "" + ChatColor.BOLD + "White Fart");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', ""));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7(Left Click)&a Boomba"));
		meta.setLore(lore);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 32767, true);
		meta.addEnchant(Enchantment.LOYALTY, 10, true);
		meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.setUnbreakable(true);
		
		SNOWBALL.setItemMeta(meta);
		
		return SNOWBALL;
	}
	@EventHandler()
	public void	 onClick(PlayerInteractEvent event) {
		 if(event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.SNOWBALL))
			if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
				Player player = (Player) event.getPlayer();
				if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains(ChatColor.WHITE +  "" + ChatColor.BOLD + "White Fart"))
				if (event.getAction() == Action.RIGHT_CLICK_AIR) {
					if(!(list.contains(player.getName())))
							list.add(player.getName());
					return;
				}
				if (event.getAction() == Action.LEFT_CLICK_AIR) {
					if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains(ChatColor.WHITE +  "" + ChatColor.BOLD + "White Fart"))
						if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
					for (int i = 1; i < 55 ; i++) {
					player.launchProjectile(Fireball.class);
				}
			}
		 if(list.contains(event.getPlayer().getName())) {
			 list.remove(event.getPlayer().getName());
		 }
			}
			}
	}
	@EventHandler
	public void onLand(ProjectileHitEvent event) {
		if (event.getEntityType() == EntityType.ARROW) {
			if (event.getEntity().getShooter() instanceof Player) {
				Player player = (Player) event.getEntity().getShooter();
				if (list.contains(player.getName())) {
					Location loc = event.getEntity().getLocation();
					loc.setY(loc.getY() + 1);

						for (int i = 1; i < 3 ; i++) {
						loc.getWorld().spawnEntity(loc, EntityType.WITHER);			
							loc.setX(loc.getX() + i);
						}
				}
			}
		}
	}
    @SuppressWarnings("unused")
	private final Main plugin;
    public WhiteFart(Main plugin) {
        this.plugin = plugin;
    }
}