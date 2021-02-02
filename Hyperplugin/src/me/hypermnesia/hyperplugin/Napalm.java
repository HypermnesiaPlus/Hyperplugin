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
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Napalm implements Listener, CommandExecutor {
	
	public List<String> list = new ArrayList<String>();


	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("Napalm")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "console burning intensifies");
				return true;
			}
			Player player = (Player) sender;
            if (player.hasPermission("naplam.use")) {
            		if (player.getInventory().firstEmpty() == -1) {
				Location loc = player.getLocation();
				World world = player.getWorld();
				
				world.dropItemNaturally(loc, getItem());
				player.sendMessage(ChatColor.RED + "Comrade pick up the napalm marker!");
				return false;
			}
			player.getInventory().addItem(getItem());
			player.sendMessage(ChatColor.RED + "Comrade, you may set fire to the world.");
			return true;
		}
		 else {
			player.sendMessage(ChatColor.RED + "You have no Permission to burn the terrain.");
            }
		return false;
		}
		return false;
	
	}
	
	
	public ItemStack getItem( ) {
		
		
		ItemStack bow = new ItemStack(Material.BOW);
		ItemMeta meta = (ItemMeta) bow.getItemMeta();
		bow.setItemMeta(meta);
		meta.setDisplayName(ChatColor.GREEN +  "" + ChatColor.BOLD + "Napalm Marker");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', ""));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7(Right Click)&4 burn land "));
		meta.setLore(lore);
		meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.setUnbreakable(true);
		
		bow.setItemMeta(meta);
		
		return bow;
	}
	@EventHandler()
	public void	 onClick(PlayerInteractEvent event) {
		 if(event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.BOW))
			if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
				Player player = (Player) event.getPlayer();
				if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains(ChatColor.GREEN +  "" + ChatColor.BOLD + "Napalm Marker"));
				if (event.getAction() == Action.RIGHT_CLICK_AIR) {
					if(!(list.contains(player.getName())))
							list.add(player.getName());
					return;
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
					
                    for (int x = 1; x < 100; x++) {
                        int randX = (int) (Math.random() * 1) + 1;
                        int randY = (int) (Math.random() * 1) + 1;
                        loc.setX(loc.getX() + randX);
                        loc.setY(loc.getY() + randY);
                        loc.setPitch(0);
                        player.getPlayer().getWorld().spawnEntity(loc, EntityType.SMALL_FIREBALL);
						}
				}
			}
		}
	}
    @SuppressWarnings("unused")
	private final Main plugin;
    public Napalm(Main plugin) {
        this.plugin = plugin;
    }

	}