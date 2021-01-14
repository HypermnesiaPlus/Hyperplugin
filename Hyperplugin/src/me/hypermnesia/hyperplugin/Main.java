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
import org.bukkit.plugin.java.JavaPlugin;

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
		this.getServer().getPluginManager().registerEvents(new FroggieLegs(this), this);
		this.getServer().getPluginManager().registerEvents(new MyMeth(this), this);
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
		new EnderBow(this);
		new FroggieLegs(this);
		new Getaway(this);
		new HyperHelp(this);
		new IdenityTheft(this);
		new Launch(this);
		new Link(this);
		new Medic(this);
		new MyMeth(this);
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
		this.getCommand("EnderBow").setExecutor (new EnderBow(this));
		this.getCommand("FroggieLegs").setExecutor(new FroggieLegs(this));
		this.getCommand("Getaway").setExecutor(new Getaway(this));
		this.getCommand("HyperHelp").setExecutor(new HyperHelp(this));
		this.getCommand("IdenityTheft").setExecutor(new IdenityTheft(this));
		this.getCommand("Launch").setExecutor(new Launch(this));
		this.getCommand("Link").setExecutor(new Link(this));
		this.getCommand("Medic").setExecutor(new Medic(this));
		this.getCommand("MyMeth").setExecutor(new MyMeth(this));
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
		
		config.addDefault("broadcast-death", true);
		config.addDefault("pain", false);
		config.addDefault("pain-info", false);
		config.addDefault("shutdown-message", true);
        config.options().copyDefaults(true);
        saveConfig();

	}
	
	/*---Pain.java---*/
	
	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		if (config.getBoolean("pain")) {
		if (!(event.getEntity() instanceof Player))
			return;
		Player player = (Player) event.getEntity();
		double dmg = event.getDamage();
		event.setDamage(dmg * 4);
		if (config.getBoolean("pain-info")) {
			player.sendMessage(ChatColor.DARK_GRAY + "You were damged by " + event.getCause() + " for " + event.getDamage() + " Damage!");
		}
					}
		else{
			return;
		}
}
	/*---broadcast-death.java---*/
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		if (config.getBoolean("broadcast-death")) {
			if (!(event.getEntity() instanceof Player))
				return;
			Player player = (Player) event.getEntity();
				Bukkit.broadcastMessage(ChatColor.AQUA + player.getName() + ChatColor.DARK_RED + " Was decimated");
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
