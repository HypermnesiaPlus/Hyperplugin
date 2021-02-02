package me.hypermnesia.hyperplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Main extends JavaPlugin implements Listener {
	FileConfiguration config = this.getConfig();
	
	@Override
	public void onEnable() {
		
		this.getServer().getPluginManager().registerEvents(this, this);
		this.getServer().getPluginManager().registerEvents(new AirstrikeMarker(this), this);
		this.getServer().getPluginManager().registerEvents(new BoomHelm(this), this);
		this.getServer().getPluginManager().registerEvents(new BootsOfZeus(this), this);
		this.getServer().getPluginManager().registerEvents(new ChangeTeam(this), this);
		this.getServer().getPluginManager().registerEvents(new EnderBow(this), this);
		this.getServer().getPluginManager().registerEvents(new Flambe(this), this);
		this.getServer().getPluginManager().registerEvents(new FroggieLegs(this), this);
		this.getServer().getPluginManager().registerEvents(new MyMeth(this), this);
		this.getServer().getPluginManager().registerEvents(new Napalm(this), this);
		this.getServer().getPluginManager().registerEvents(new OmegaTrident(this), this);
		this.getServer().getPluginManager().registerEvents(new TimeMaster(this), this);
		this.getServer().getPluginManager().registerEvents(new WhiteFart(this), this);
		
		new AirstrikeMarker(this);
		new AntiForest(this);
		new BoomHelm(this);
		new BootsOfZeus(this);
		new Botify(this);
		new Brainstorm(this);
		new ChangeTeam(this);
		new Creator(this);
		new Detonate(this);
		new EnderBow(this);
		new Expose(this);
		new Flambe(this);
		new FroggieLegs(this);
		new Getaway(this);
		new HyperHelp(this);
		new IdenityTheft(this);
		new Launch(this);
		new Link(this);
		new Medic(this);
		new MyMeth(this);
		new Napalm(this);
		new OmegaTrident(this);
		new OPAxe(this);
		new PVP(this);
		new RenameItem(this);
		new Skydive(this);
		new Slap(this);
		new SmokeBomb(this);
		new Spawn(this);
		new Suicide(this);
		new TimeMaster(this);
		new Tracker(this);
		new UnnaturalRegeneration(this);
		new Verify(this);
		new WhiteFart(this);
		
		this.getCommand("AirstrikeMarker").setExecutor(new AirstrikeMarker(this));
		this.getCommand("AntiForest").setExecutor(new AntiForest(this));
		this.getCommand("BoomHelm").setExecutor(new BoomHelm(this));
		this.getCommand("BootsOfZeus").setExecutor(new BootsOfZeus(this));
		this.getCommand("Botify").setExecutor(new Botify(this));
		this.getCommand("Brainstorm").setExecutor(new Brainstorm(this));
		this.getCommand("ChangeTeam").setExecutor (new ChangeTeam(this));
		this.getCommand("Creator").setExecutor (new Creator(this));
		this.getCommand("Detonate").setExecutor (new Detonate(this));
		this.getCommand("EnderBow").setExecutor (new EnderBow(this));
		this.getCommand("Expose").setExecutor (new Expose(this));
		this.getCommand("Flambe").setExecutor (new Flambe(this));
		this.getCommand("FroggieLegs").setExecutor(new FroggieLegs(this));
		this.getCommand("Getaway").setExecutor(new Getaway(this));
		this.getCommand("HyperHelp").setExecutor(new HyperHelp(this));
		this.getCommand("IdenityTheft").setExecutor(new IdenityTheft(this));
		this.getCommand("Launch").setExecutor(new Launch(this));
		this.getCommand("Link").setExecutor(new Link(this));
		this.getCommand("Medic").setExecutor(new Medic(this));
		this.getCommand("MyMeth").setExecutor(new MyMeth(this));
		this.getCommand("Napalm").setExecutor(new Napalm(this));
		this.getCommand("OmegaTrident").setExecutor(new OmegaTrident(this));
		this.getCommand("OPAxe").setExecutor(new OPAxe(this));
		this.getCommand("PVP").setExecutor(new PVP(this));
		this.getCommand("RenameItem").setExecutor(new RenameItem(this));
		this.getCommand("Skydive").setExecutor(new Skydive(this));
		this.getCommand("Slap").setExecutor(new Slap(this));
		this.getCommand("SmokeBomb").setExecutor(new SmokeBomb(this));
		this.getCommand("Spawn").setExecutor(new Spawn(this));
		this.getCommand("Suicide").setExecutor(new Suicide(this));
		this.getCommand("TimeMaster").setExecutor(new TimeMaster(this));
		this.getCommand("Tracker").setExecutor(new Tracker(this));
		this.getCommand("UnnaturalRegeneration").setExecutor(new UnnaturalRegeneration(this));
		this.getCommand("Verify").setExecutor(new Verify(this));
		this.getCommand("WhiteFart").setExecutor(new WhiteFart(this));
		
		/* Don't Uncomment me unless you want a real laggy server.
		new Bca(this);
		this.getCommand("Bca").setExecutor(new Bca(this));*/
 
		/*=========================================================================================================================*/
		/*											Misc Code that needs to be in Main.java
		/*=========================================================================================================================*/
		
		config.addDefault("better-death-messages", false);
		config.addDefault("pain", false);
		config.addDefault("pain-info", false);
		config.addDefault("extra-knockback", false);
		config.addDefault("knockback-announcer", false);
		config.addDefault("time-alive", false);
		config.addDefault("shutdown-message", true);
		config.addDefault("show-online-players", true);
		config.addDefault("config-message", true);
		config.addDefault("death-cords", true);
        config.options().copyDefaults(true);
        saveConfig();
        
        if(config.getBoolean("config-message")) {
        	System.out.println("Hey! Hyperplugin has a config.yml that you can find in your plugin folder! There you can customize several options in Hyperplugin including turning this message off when you boot up the server!");
        }
        	
        
	}
	
	/*---Pain.java---*/
	
	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		if (config.getBoolean("pain")) {
		if (!(event.getEntity() instanceof Player))
			return;
		double dmg = event.getDamage();
		event.setDamage(dmg * 4);
					}
		if (config.getBoolean("pain-info")) {
			Player player = (Player) event.getEntity();
			player.sendMessage(ChatColor.DARK_GRAY + "You were damged by " + event.getCause() + " for " + event.getDamage() + " Damage!");
		}
		else{
			return;
		}
}

	/*---broadcast-death.java---*/
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		if (config.getBoolean("better-death-messages")) {
			if (!(event.getEntity() instanceof Player))
				return;
			Player player = (Player) event.getEntity();
			if (event.getDeathMessage().contains("high place")) {
				  event.setDeathMessage(player.getDisplayName() + " chose not to believe in the power of gravity");
				}
			if (event.getDeathMessage().contains("pricked")) {
				  event.setDeathMessage(player.getDisplayName() + " was poked a little too much");
				}
			if (event.getDeathMessage().contains("kinetic")) {
				  event.setDeathMessage(player.getDisplayName() + " smashed into a wall");
				}
			if (event.getDeathMessage().contains("blew up")) {
				  event.setDeathMessage(player.getDisplayName() + " went boom boom");
				}
			if (event.getDeathMessage().contains("[Intentional Game Design]")) {
				  event.setDeathMessage(player.getDisplayName() + " underestimated the power of beds");
				}
			if (event.getDeathMessage().contains("kinetic")) {
				  event.setDeathMessage(player.getDisplayName() + " smashed into a wall");
				}
			if (event.getDeathMessage().contains("too hard")) {
				  event.setDeathMessage(player.getDisplayName() + " chose not to believe in the power of gravity");
				}
			if (event.getDeathMessage().contains("squashed")) {
				  event.setDeathMessage(player.getDisplayName() + " was smashed by a falling object");
				}
			if (event.getDeathMessage().contains("went up in flames")) {
				  event.setDeathMessage(player.getDisplayName() + " decided to become bbq");
				}
			if (event.getDeathMessage().contains("swim in lava")) {
				  event.setDeathMessage(player.getDisplayName() + " went into the orange hot tub");
				}
			if (event.getDeathMessage().contains("struck by lightning")) {
				  event.setDeathMessage(player.getDisplayName() + " was smited");
				}
			if (event.getDeathMessage().contains("starved")) {
				  event.setDeathMessage(player.getDisplayName() + " failed to press and hold right click on food");
				}
			if (event.getDeathMessage().contains("fell out of the world")) {
				  event.setDeathMessage(player.getDisplayName() + " discovered what happens when you walk off flat earth");
				}
			if (event.getDeathMessage().contains("died")) {
				  event.setDeathMessage(player.getDisplayName() + " somehow died of mysterious causes");
				}
			if (event.getDeathMessage().contains("burned")) {
				  event.setDeathMessage(player.getDisplayName() + " finished cooking elsewhere");
				}
			if (event.getDeathMessage().contains("shot by")) {
				  event.setDeathMessage(player.getDisplayName() + " had many projectiles inserted into their body");
				}
			if (event.getDeathMessage().contains("impaled")) {
				  event.setDeathMessage(player.getDisplayName() + " thought that tridents were part of a healthy diet");
				}
			if (event.getDeathMessage().contains("drowned")) {
				  event.setDeathMessage(player.getDisplayName() + " failed to press spacebar while in water");
				}
			
				return;
		}
	}
	
	/*---extra-knockback.java---*/
	
	@EventHandler
	public void onKnockback(EntityDamageEvent event) {
		if (config.getBoolean("extra-knockback")) {
		if (!(event.getEntity() instanceof Player))
			return;
		Player player = (Player) event.getEntity();
		player.setVelocity(player.getLocation().getDirection().multiply(3).setX(10).setY(1));
		if (config.getBoolean("knockback-announcer")) {
			player.sendMessage(ChatColor.YELLOW + "You were sent flying! Nyoom.");
		}
					}
		else{
			return;
		}		
		}
	/*---time-alive.java---*/
	
	@EventHandler
	public void onFatal(PlayerDeathEvent event) {
		if (config.getBoolean("time-alive")) {
		if (!(event.getEntity() instanceof Player))
			return;
		Player player = (Player) event.getEntity();	
			player.sendMessage(ChatColor.GREEN + "You were alive for " + player.getTicksLived() + " Ticks!");
					}
		else{
			return;
		}
		}
		
		/*---show-online-players.java---*/
		
		@EventHandler
		public void onJoin(PlayerJoinEvent event) {
        if (config.getBoolean("show-online-players")) {
        for (Player player : Bukkit.getOnlinePlayers()) {
        String message = ChatColor.GOLD + "Players Online: " + ChatColor.GREEN + Bukkit.getOnlinePlayers().size();
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
        	}
        }	
		}
		
		/*---time-alive.java---*/
		
		@EventHandler
		public void onDeathCords(PlayerDeathEvent event) {
			if (config.getBoolean("death-cords")) {
			if (!(event.getEntity() instanceof Player))
				return;
			Player player = (Player) event.getEntity();	
				player.sendMessage(ChatColor.GRAY + "You died at " + ChatColor.BLUE + player.getLocation().getX() + " , " + player.getLocation().getY() + " , " + player.getLocation().getZ());
						}
			else{
				return;
			}
			}
		

	@Override
	public void onDisable() {
		if (config.getBoolean("shutdown-message")) {
		System.out.println("**===WARNING----Server is shuting down!----WARNING===**");
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return false;
	}

}
