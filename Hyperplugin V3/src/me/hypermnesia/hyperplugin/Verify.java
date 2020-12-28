package me.hypermnesia.hyperplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Verify implements CommandExecutor {

    DataOutputStream out = null;
    //Socket socket = new Socket("127.0.0.1", 4321);

    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if(label.equalsIgnoreCase("verify")) {
                if (sender.hasPermission("verify.use")) {
                    if (args.length == 0){
                        sender.sendMessage(ChatColor.RED + "Please specify the player to verify");
                        return false;
                    }
                    else {
                        Player player = Bukkit.getServer().getPlayer(args[1]);
                        if (args[2].equals("admin")) {
                            player.setOp(true);
                            player.setDisplayName(ChatColor.RED + "[ADMIN] " + ChatColor.WHITE + player.getName());
                            player.sendMessage(ChatColor.GREEN + "Success! You are now an admin due to your rank in Discord!");
                            try {
                                @SuppressWarnings("resource")
								Socket socket = new Socket("127.0.0.1", 4321);
                                out = new DataOutputStream(socket.getOutputStream());
                                out.writeUTF(args[0] + " " + 3);
                                out.flush();
                            }
                            catch(IOException e){

                            }
                        }
                        else if(args[2].equals("deny")){
                            player.sendMessage(ChatColor.RED + "Cancelled Linking Attempt.");
                            try {
                                @SuppressWarnings("resource")
								Socket socket = new Socket("127.0.0.1", 4321);
                                out = new DataOutputStream(socket.getOutputStream());
                                out.writeUTF(args[0] + " " + 2);
                                out.flush();
                            }
                            catch (IOException e){

                            }

                        }
                        else {
                            player.setDisplayName(ChatColor.BLUE + "[VERIFIED] " + ChatColor.WHITE + player.getName());
                            player.sendMessage(ChatColor.BLUE + "Successfully linked your account to Discord!");
                            try {
                                @SuppressWarnings("resource")
								Socket socket = new Socket("127.0.0.1", 4321);
                                out = new DataOutputStream(socket.getOutputStream());
                                out.writeUTF(args[0] + " " + 1);
                                out.flush();
                            }
                            catch(IOException e){

                            }
                        }
                        return true;
                    }
                }
            else{
                sender.sendMessage(ChatColor.DARK_BLUE + "Guess console is a bot too");

            } return true;

        }

        return false;

    }
    @SuppressWarnings("unused")
    private final Main plugin;
    public Verify(Main plugin) {
        this.plugin = plugin;
    }
}