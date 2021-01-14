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
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TimeMaster implements Listener, CommandExecutor{
	
	public List<String> list = new ArrayList<String>();


	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("timemaster")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.GOLD + "Console becom time masta");
				return true;
			}
			Player player = (Player) sender;
            if (player.hasPermission("timemaster.use")) {
            		if (player.getInventory().firstEmpty() == -1) {
				Location loc = player.getLocation();
				World world = player.getWorld();
				
				world.dropItemNaturally(loc, getItem());
				player.sendMessage(ChatColor.GOLD + "You found the ancient timemaster's TV remote. However your inventory was full so it was dropped on the ground.");
				return false;
			}
			player.getInventory().addItem(getItem());
			player.sendMessage(ChatColor.GOLD + "You found the ancient timemaster's TV remote. Start manipulating time!");
			return true;
		}
		 else {
			player.sendMessage(ChatColor.RED + "You have no Permission to change the time with a single click.");
            }
		return false;
		}
		return false;
	
	}
	
	
	public ItemStack getItem( ) {
		
		
		ItemStack clock = new ItemStack(Material.CLOCK);
		ItemMeta meta = (ItemMeta) clock.getItemMeta();
		clock.setItemMeta(meta);
		meta.setDisplayName(ChatColor.GRAY +  "" + ChatColor.BOLD + "The Ancient Timemaster's TV Remote");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', ""));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7(Left Click)&b Change time to night"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7(Right Click)&b Change time to day"));
		meta.setLore(lore);
		meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		clock.setItemMeta(meta);
		
		return clock;
	}
	@EventHandler()
	public void	 onClick(PlayerInteractEvent event) {
		 if(event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.CLOCK))
			if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
				Player player = (Player) event.getPlayer();
				World world = player.getWorld();
				if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains(ChatColor.GRAY +  "" + ChatColor.BOLD + "The Ancient Timemaster's TV Remote"))
				if (event.getAction() == Action.RIGHT_CLICK_AIR) {
					if(!(list.contains(player.getName())))
							list.add(player.getName());
								world.setTime(1000);
				}
				if (event.getAction() == Action.LEFT_CLICK_AIR) {
					if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains(ChatColor.GRAY +  "" + ChatColor.BOLD + "The Ancient Timemaster's TV Remote"))
						if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
					world.setTime(14000);
				}
			}
		 if(list.contains(event.getPlayer().getName())) {
			 list.remove(event.getPlayer().getName());
		 }
	}
	}
	
    @SuppressWarnings("unused")
	private final Main plugin;
    public TimeMaster(Main plugin) {
        this.plugin = plugin;
    }
}