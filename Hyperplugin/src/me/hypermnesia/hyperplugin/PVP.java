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
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PVP implements Listener, CommandExecutor {
    
    public Inventory Inv;
    

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("PVP")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.YELLOW + "console do epic axe crits.");
                return true;
                }    
            Player player = (Player) sender;
            if (player.hasPermission("PVP.use")) {
                createInv(); player.openInventory(Inv);

         } 
      		 else {
      			player.sendMessage(ChatColor.RED + "You have no permission to Recieve a kit.");
                  }
      		return false;
            }
               
        return false;
    }
	
    public void createInv() {
        
        Inv = Bukkit.createInventory(null, 9,ChatColor.RED + "PVP KIT");

		ItemStack DA = new ItemStack(Material.DIAMOND_AXE);
		ItemMeta meta = (ItemMeta) DA.getItemMeta();
		meta.setDisplayName(ChatColor.GRAY + "PVP AXE");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "" + ChatColor.ITALIC + "PVP AXE");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.VANISHING_CURSE, 10, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 50, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
		DA.setItemMeta(meta);
        Inv.setItem(0,DA);

		ItemStack IRON_HELMET = new ItemStack(Material.IRON_HELMET);
		ItemMeta meta1 = (ItemMeta) IRON_HELMET.getItemMeta();
		meta1.setDisplayName(ChatColor.GRAY + "PVP HELM");
		List<String> lore1 = new ArrayList<String>();
		lore1.add(ChatColor.GREEN + "" + ChatColor.ITALIC + "PVP HELM");
		meta1.setLore(lore1);
		meta1.addEnchant(Enchantment.VANISHING_CURSE, 10, true);
		meta1.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 100, true);
		meta1.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
		IRON_HELMET.setItemMeta(meta1);
        Inv.setItem(3,IRON_HELMET);
        
		ItemStack IRON_CHESTPLATE = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta meta11 = (ItemMeta) IRON_CHESTPLATE.getItemMeta();
		meta11.setDisplayName(ChatColor.GRAY + "PVP CHESTPLATE");
		List<String> lore11 = new ArrayList<String>();
		lore11.add(ChatColor.GREEN + "" + ChatColor.ITALIC + "PVP CHESTPLATE");
		meta11.setLore(lore11);
		meta11.addEnchant(Enchantment.VANISHING_CURSE, 10, true);
		meta11.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 100, true);
		meta11.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
		IRON_CHESTPLATE.setItemMeta(meta11);
        Inv.setItem(4,IRON_CHESTPLATE);
        
		ItemStack IRON_BOOTS = new ItemStack(Material.IRON_BOOTS);
		ItemMeta meta111 = (ItemMeta) IRON_BOOTS.getItemMeta();
		meta111.setDisplayName(ChatColor.GRAY + "PVP BOOTS");
		List<String> lore111 = new ArrayList<String>();
		lore111.add(ChatColor.GREEN + "" + ChatColor.ITALIC + "PVP BOOTS");
		meta111.setLore(lore111);
		meta111.addEnchant(Enchantment.VANISHING_CURSE, 10, true);
		meta111.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 100, true);
		meta111.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
		IRON_BOOTS.setItemMeta(meta111);
        Inv.setItem(5,IRON_BOOTS);
        
		ItemStack BOW = new ItemStack(Material.BOW);
		ItemMeta meta1111 = (ItemMeta) BOW.getItemMeta();
		meta1111.setDisplayName(ChatColor.GRAY + "PVP BOW");
		List<String> lore1111 = new ArrayList<String>();
		lore1111.add(ChatColor.GREEN + "" + ChatColor.ITALIC + "PVP BOW");
		meta1111.setLore(lore1111);
		meta1111.addEnchant(Enchantment.VANISHING_CURSE, 10, true);
		meta1111.addEnchant(Enchantment.ARROW_DAMAGE, 50, true);
		meta1111.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
		BOW.setItemMeta(meta1111);
        Inv.setItem(2,BOW);
        
		ItemStack COOKED_BEEF = new ItemStack(Material.COOKED_BEEF,4);
		ItemMeta meta11111 = (ItemMeta) COOKED_BEEF.getItemMeta();
		meta11111.setDisplayName(ChatColor.GRAY + "PVP STEK");
		List<String> lore11111 = new ArrayList<String>();
		lore11111.add(ChatColor.GREEN + "" + ChatColor.ITALIC + "lol why is dis a thing");
		meta11111.setLore(lore11111);
		meta11111.addEnchant(Enchantment.VANISHING_CURSE, 10, true);
		meta11111.addEnchant(Enchantment.DAMAGE_ALL, 100, true);
		meta11111.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
		COOKED_BEEF.setItemMeta(meta11111);
        Inv.setItem(1,COOKED_BEEF);
        
		ItemStack ARROW = new ItemStack(Material.ARROW,24);
		ItemMeta meta111111 = (ItemMeta) COOKED_BEEF.getItemMeta();
		meta111111.setDisplayName(ChatColor.GRAY + "PVP BOW SPAM AMMO");
		List<String> lore111111 = new ArrayList<String>();
		lore111111.add(ChatColor.RED + "" + ChatColor.ITALIC + "noooooooo");
		meta111111.setLore(lore111111);
		meta111111.addEnchant(Enchantment.VANISHING_CURSE, 10, true);
		meta111111.addEnchant(Enchantment.DAMAGE_ALL, 100, true);
		meta111111.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
		ARROW.setItemMeta(meta111111);
        Inv.setItem(8,ARROW);
    }
    @SuppressWarnings("unused")
	private final Main plugin;
    public PVP(Main plugin) {
        this.plugin = plugin;
        
}
} 
 