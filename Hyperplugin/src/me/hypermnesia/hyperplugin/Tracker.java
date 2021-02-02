package me.hypermnesia.hyperplugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Tracker implements Listener, CommandExecutor {

    public List<String> list = new ArrayList<String>();


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("tracker")) {
            Player player = Bukkit.getServer().getPlayer(args[0]);
                if (player.getInventory().firstEmpty() == -1) {
                    player.sendMessage("You suck.");
                    return false;
                }
                Player requester = (Player) sender;
                Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
                    public void run(){
                        Location loc = player.getLocation();
                        requester.setCompassTarget(loc);
                    }
                }, 1, 1);
                requester.getInventory().addItem(getItem(player.getName()));
                requester.sendMessage(ChatColor.GREEN + "Now tracking " + ChatColor.LIGHT_PURPLE + player.getName());
        }
        return false;

    }

    public ItemStack getItem(String name){


        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta meta = (ItemMeta) compass.getItemMeta();
        compass.setItemMeta(meta);
        meta.setDisplayName(ChatColor.DARK_GREEN+ name + " Tracker");
        meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setUnbreakable(true);

        compass.setItemMeta(meta);

        return compass;
    }

    private final Main plugin;
    public Tracker(Main plugin) {
        this.plugin = plugin;
    }

}