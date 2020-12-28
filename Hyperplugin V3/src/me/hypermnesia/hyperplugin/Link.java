package me.hypermnesia.hyperplugin;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Link implements CommandExecutor {

    DataOutputStream out = null;

    public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) {
        if(label.equalsIgnoreCase("link")) {
            if (args.length == 1){
                try{
                    Player player = (Player) sender;
                    Socket socket = new Socket("127.0.0.1", 5461);
                    out = new DataOutputStream(socket.getOutputStream());
                    out.writeUTF(args[0] + " " + player.getName());
                    out.flush();
                    socket.close();
                }
                catch(IOException e){

                }
                catch (ArrayIndexOutOfBoundsException exc){

                }
            }
                new Thread(new Runnable(){
                    public Socket socket = null;
                    @SuppressWarnings("unused")
					private DataInputStream in = null;
                    @SuppressWarnings("unused")
					DataOutputStream out = null;
                    String id = "";
                    @SuppressWarnings("deprecation")
					@Override
                    public void run() {
                        try {
                            int port = 1234;
                            @SuppressWarnings("resource")
							ServerSocket server = new ServerSocket(port);
                            while (true) {
                                try {
                                    System.out.println("Linking...");
                                    System.out.println("Waiting for a request...");
                                    //sender.sendMessage("Please do the 'verify' command in Discord, then come back.");
                                    socket = server.accept();

                                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                                    String line = "";
                                    line = in.readLine();
                                    System.out.println(line);
                                    char admin = line.charAt(0);
                                    id = line.substring(1, 19);
                                    line = line.substring(19);
                                    Player player = Bukkit.getServer().getPlayer(line);
                                    String command = "/verify " + id + " " + player.getName() + " verify";
                                    if (admin == 'a') {
                                        command = "/verify "+ id + " " + player.getName() + " admin";
                                    }
                                    player.sendMessage(ChatColor.GOLD + "=================================================");
                                    player.sendMessage("Would you like to Link your Account (" + line + ") with Discord?");
                                    TextComponent yes = new TextComponent("[YES] - Link Account");
                                    yes.setColor(net.md_5.bungee.api.ChatColor.GREEN);
                                    yes.setBold(true);
                                    yes.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
                                    yes.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                                            new ComponentBuilder("Click here to verify your account!").color(net.md_5.bungee.api.ChatColor.AQUA).italic(true).create()));
                                    TextComponent no = new TextComponent("[NO] - Dismiss Message");
                                    no.setColor(net.md_5.bungee.api.ChatColor.RED);
                                    no.setBold(true);
                                    no.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/verify " + id + " " + player.getName() + " deny"));
                                    no.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                                            new ComponentBuilder("Click here to dismiss this message.").color(net.md_5.bungee.api.ChatColor.AQUA).italic(true).create()));
                                    player.spigot().sendMessage(yes);
                                    player.spigot().sendMessage(no);
                                    player.sendMessage(ChatColor.GOLD + "=================================================");
                                    socket.close();
                                }
                                catch(NullPointerException err){

                                }
                            }
                            }
                        catch (IOException e) {

                        }
                    }
                }).start();
                return true;


            }
            else{
                sender.sendMessage(ChatColor.DARK_BLUE + "ok");

            } return true;

    }
    @SuppressWarnings("unused")
    private final Main plugin;
    public Link(Main plugin) {
        this.plugin = plugin;
    }
}