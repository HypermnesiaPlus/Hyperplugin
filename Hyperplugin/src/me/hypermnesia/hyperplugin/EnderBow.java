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
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EnderBow implements Listener, CommandExecutor{
	
	public List<String> list = new ArrayList<String>();


	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("enderbow")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.GREEN + "Console teleports. zoom zoom.");
				return true;
			}
			Player player = (Player) sender;
            if (player.hasPermission("enderbow.use")) {
            		if (player.getInventory().firstEmpty() == -1) {
				Location loc = player.getLocation();
				World world = player.getWorld();
				
				world.dropItemNaturally(loc, getItem());
				player.sendMessage(ChatColor.GOLD + "You found an teleporting device. However your inventory was full so it was dropped on the ground.");
				return false;
			}
			player.getInventory().addItem(getItem());
			player.sendMessage(ChatColor.GOLD + "You found an teleporting device. zoom zoom.");
			return true;
		}
		 else {
			player.sendMessage(ChatColor.RED + "You have no Permission get a teleporting device.");
            }
		return false;
		}
		return false;
	
	}
	
	
	public ItemStack getItem( ) {
		
		
		ItemStack bow = new ItemStack(Material.BOW);
		ItemMeta meta = (ItemMeta) bow.getItemMeta();
		bow.setItemMeta(meta);
		meta.setDisplayName(ChatColor.DARK_BLUE + "Ender Bow");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.LIGHT_PURPLE + "You will teleport where the arrow lands!");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.ARROW_DAMAGE, 32767, true);
		meta.addEnchant(Enchantment.ARROW_KNOCKBACK, 32767, true);
		meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.setUnbreakable(true);
		
		bow.setItemMeta(meta);
		
		return bow;
		 }

	@EventHandler
	public void onLand(ProjectileHitEvent event) {
		if (event.getEntityType() == EntityType.ARROW) {
			if (event.getEntity().getShooter() instanceof Player) {
				Player player = (Player) event.getEntity().getShooter();
				Location loc = event.getEntity().getLocation();
				if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains(ChatColor.DARK_BLUE + "Ender Bow"))
                    player.teleport(loc);
				}
			}
		}
	
    @SuppressWarnings("unused")
	private final Main plugin;
    public EnderBow(Main plugin) {
        this.plugin = plugin;
    }
}