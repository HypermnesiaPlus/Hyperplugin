package me.hypermnesia.hyperplugin;

import java.net.*;
import java.io.*;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Bca extends Thread implements CommandExecutor {

    @SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if(label.equalsIgnoreCase("bca")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("bca.use")) {
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "Hey you just typed me! i will crash the server if you attempt to fix this");
                    Thread thread = new Thread(new Runnable(){
                        public Socket socket = null;
                        @SuppressWarnings("unused")
						private DataInputStream in = null;
                        @Override
                        public void run() {
                            try {
                                int port = 5000;
                                player.sendMessage("class is calling");
                                @SuppressWarnings("resource")
								ServerSocket server = new ServerSocket(port);
                                player.sendMessage("Server started");
                                while (true) {

                                    socket = server.accept();

                                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                                    String line = "";

                                    while(true) {
                                        try {
                                            line = in.readLine();
                                            player.sendMessage(ChatColor.LIGHT_PURPLE + "[Discord]" + ChatColor.WHITE +  line);
                                            throw new IOException("Client has sent their message");
                                        }
                                        catch (IOException i) {
                                            socket.close();
                                            break;
                                        }
                                    }
                                }
                            }
                            catch (IOException e) {

                            }
                        }
                    });
                    Thread info = new Thread(new Runnable(){
                        public Socket socket = null;
                        @SuppressWarnings("unused")
						private DataInputStream in = null;
                        @Override
                        public void run() {
                            try {
                                while (true) {
                                    int port = 8745;
                                    ServerSocket server = new ServerSocket(port);
                                    player.sendMessage("good here");
                                    server.accept();
                                    server.close();
                                    socket = new Socket("127.0.0.1", 7894);
                                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                                    out.writeUTF("Server Name:\r\n");
                                    out.writeUTF(Bukkit.getServer().getName() + "\r\n");
                                    out.flush();
                                    out.writeUTF("Server MOTD:\r\n");
                                    out.writeUTF(Bukkit.getMotd() + "\r\n");
                                    out.flush();
                                    out.writeUTF("Server Version:\r\n");
                                    out.writeUTF(Bukkit.getBukkitVersion() + "\r\n");
                                    out.flush();
                                    out.writeUTF("Server's Ip address:\r\n");
                                    out.writeUTF(Bukkit.getServer().getIp() + "\r\n");
                                    out.flush();
                                    out.writeUTF("Server Limit:\r\n");
                                    out.writeUTF(String.valueOf(Bukkit.getServer().getMaxPlayers()) + "\r\n");
                                    out.flush();
                                    out.writeUTF("Server's Online Player Number:\r\n");
                                    out.writeUTF(String.valueOf(Bukkit.getOnlinePlayers().size()) + "\r\n");
                                    out.flush();
                                    out.writeUTF("Server's Port:\r\n");
                                    out.writeUTF(String.valueOf(Bukkit.getServer().getPort()) + "\r\n");
                                    out.flush();
                                    out.close();
                                    socket.close();
                                    throw new IOException("Finished with Data...");
                                }

                            }
                            catch (IOException e){

                            }
                        }
                    });

                    try {
                        if (args[0].equals("enable")) {
                            player.sendMessage(ChatColor.GREEN + "Successfully enabled BCA!");
                            info.start();
                            thread.start();
                        } else if (args[0].equals("disable")) {
                            player.sendMessage(ChatColor.RED + "Successfully disabled BCA.");
                            info.stop();
                            thread.stop();
                        }
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        player.sendMessage("To Enable BadChatApp, do /bca enable, to disable do /bca disable");
                    }
                    return true;
                }
                player.sendMessage(ChatColor.RED + "NO perma");


            }
            else{
                sender.sendMessage("Bot?");

            } return true;

        }

        return false;

    }
    @SuppressWarnings("unused")
    private final Main plugin;
    public Bca(Main plugin) {
        this.plugin = plugin;
    }
}

