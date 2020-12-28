package me.hypermnesia.hyperplugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChangeTeam implements Listener, CommandExecutor{
	
	public Inventory Inv;
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("changeteam")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.YELLOW + "Console only has one team. The God Team.");
                return true;
                }    
            Player player = (Player) sender;
            if (player.hasPermission("changeteam.use")) {
                createInv();  player.openInventory(Inv);

         } 
      		 else {
      			player.sendMessage(ChatColor.RED + "You have no permission to change team.");
                  }
      		return false;
            }
               
        return false;
    }
    
    @EventHandler
    public void onCLick(InventoryClickEvent event) {
    	if (!event.getView().getTitle().contains(ChatColor.DARK_GREEN + "Change Team"))
    	    return;
    	if(event.getCurrentItem() == null) return;
    	if(event.getCurrentItem().getItemMeta()== null) return;
    	if(event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
    	
    	event.setCancelled(true);
    	
    	Player player = (Player) event.getWhoClicked();
    	
    	if(event.getSlot() == 0) {
    		player.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
    		player.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
    		player.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
    		player.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));
    		player.getEquipment().setItemInMainHand(new ItemStack(Material.NETHERITE_SWORD));
    		player.sendMessage(ChatColor.GOLD + "You changed your team!"); }
    	
    	if(event.getSlot() == 1) {
    		player.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
    		player.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
    		player.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
    		player.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
    		player.getEquipment().setItemInMainHand(new ItemStack(Material.WOODEN_SWORD));
    		player.sendMessage(ChatColor.GOLD + "You changed your team!"); }
    			
    	}

    
    public void createInv() {
        
        Inv = Bukkit.createInventory(null, 9,ChatColor.DARK_GREEN + "Change Team");

		ItemStack NETHERITE_BLOCK = new ItemStack(Material.NETHERITE_BLOCK);
		ItemMeta meta = (ItemMeta) NETHERITE_BLOCK.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + "Wealthy");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Click to change team!");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.VANISHING_CURSE, 10, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
		NETHERITE_BLOCK.setItemMeta(meta);
        Inv.setItem(0,NETHERITE_BLOCK);

		ItemStack COARSE_DIRT = new ItemStack(Material.COARSE_DIRT);
		ItemMeta meta1 = (ItemMeta) COARSE_DIRT.getItemMeta();
		meta1.setDisplayName(ChatColor.GRAY + "Poor");
		List<String> lore1 = new ArrayList<String>();
		lore1.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Click to change team!");
		meta1.setLore(lore);
		meta1.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
		COARSE_DIRT.setItemMeta(meta1);
        Inv.setItem(1,COARSE_DIRT);
    	
		ItemStack BARRIER = new ItemStack(Material.BARRIER);
		ItemMeta meta2 = (ItemMeta) BARRIER.getItemMeta();
		meta2.setDisplayName(ChatColor.RED + "Close Menu");
		meta2.addEnchant(Enchantment.VANISHING_CURSE, 10, true);
		meta2.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
		BARRIER.setItemMeta(meta2);
        Inv.setItem(8,BARRIER);
    	}
    @SuppressWarnings("unused")
	private final Main plugin;
    public ChangeTeam(Main plugin) {
        this.plugin = plugin;
    }




}
    