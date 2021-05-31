package me.hypermnesia.simpleenchants;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class renameItem implements CommandExecutor {

    @SuppressWarnings("deprecation")
    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if(label.equalsIgnoreCase("renameitem") || label.equalsIgnoreCase("ri")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                List<String> list = new ArrayList<String>();
                if (player.hasPermission("renameitem.use")) {
                    if (args.length == 0) {
                        player.sendMessage(ChatColor.RED + "Usage: /RENAMEITEM NAME");
                        return true;
                    }
                    try {
                        for (int x = 0; x < args.length; x++) {
                            list.add(args[x]);
                        }
                        StringBuilder sb = new StringBuilder();
                        for (String s : list)
                        {
                            sb.append(s);
                            sb.append(" ");
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        ItemStack i = player.getItemInHand();
                        ItemMeta im = i.getItemMeta();
                        im.setDisplayName(ChatColor.translateAlternateColorCodes('&', sb.toString()));
                        i.setItemMeta(im);
                        player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "The item you were holding has been renamed to " + ChatColor.translateAlternateColorCodes('&', sb.toString()));
                        return true;
                    } catch (NullPointerException e) {
                        player.sendMessage(ChatColor.RED + "A item is required in order to rename an item.");
                        return false;


                    }
                }
                player.sendMessage(ChatColor.RED + "You have no permission to rename items");


            }
            else{
                sender.sendMessage(ChatColor.GREEN + "Changing console's name to: args[0]");

            } return true;

        }

        return false;

    }

    @SuppressWarnings("unused")
    private final SimpleEnchants plugin;
    public renameItem (SimpleEnchants plugin) {
        this.plugin = plugin;
    }
}
