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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MyMeth implements Listener, CommandExecutor{
	
	public List<String> list = new ArrayList<String>();


	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("mymeth")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Console does drugs????");
				return true;
			}
			Player player = (Player) sender;
            if (player.hasPermission("mymeth.use")) {
            		if (player.getInventory().firstEmpty() == -1) {
				Location loc = player.getLocation();
				World world = player.getWorld();
				
				world.dropItemNaturally(loc, getItem());
				player.sendMessage(ChatColor.BOLD + "Looks like you dropped something.... Something white.");
				return false;
			}
			player.getInventory().addItem(getItem());
			player.sendMessage(ChatColor.BOLD + "Don't Name your method MyMeth next time.");
			return true;
		}
		 else {
			player.sendMessage(ChatColor.RED + "You have no Permission to.... don't worry about it.");
            }
		return false;
		}
		return false;
	
	}
	
	
	public ItemStack getItem( ) {
		
		
		ItemStack sugar = new ItemStack(Material.SUGAR);
		ItemMeta meta = (ItemMeta) sugar.getItemMeta();
		sugar.setItemMeta(meta);
		meta.setDisplayName(ChatColor.BOLD + "MyMeth");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', ""));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7(Click)&a Become High"));
		meta.setLore(lore);
		meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

		
		sugar.setItemMeta(meta);
		
		return sugar;
	}
	@EventHandler()
	public void	 onClick(PlayerInteractEvent event) {
		 if(event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.SUGAR))
			if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
				Player player = (Player) event.getPlayer();
				if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains(ChatColor.BOLD + "MyMeth"))
				if (event.getAction() == Action.RIGHT_CLICK_AIR) {
					if(!(list.contains(player.getName())))
							list.add(player.getName());
					player.sendMessage(ChatColor.DARK_PURPLE +  "U ok bro?");
		    		player.getEquipment().setItemInMainHand(new ItemStack(Material.AIR));
                    player.addPotionEffect((new PotionEffect(PotionEffectType.WITHER, 327670, 0)));
                    player.addPotionEffect((new PotionEffect(PotionEffectType.BLINDNESS, 327670, 1)));
                    player.addPotionEffect((new PotionEffect(PotionEffectType.WEAKNESS, 327670, 1)));
                    player.addPotionEffect((new PotionEffect(PotionEffectType.CONFUSION, 327670, 1)));
                    player.addPotionEffect((new PotionEffect(PotionEffectType.SPEED, 327670, 9)));
					return;
				}
			}

	}
    @SuppressWarnings("unused")
	private final Main plugin;
    public MyMeth(Main plugin) {
        this.plugin = plugin;
    }
}