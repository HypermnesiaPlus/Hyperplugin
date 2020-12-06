package me.hypermnesia.hyperplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		
		this.getServer().getPluginManager().registerEvents(this, this);
		this.getServer().getPluginManager().registerEvents(new AirstrikeMarker(this), this);
		this.getServer().getPluginManager().registerEvents(new ChangeTeam(this), this);
		this.getServer().getPluginManager().registerEvents(new FroggieLegs(this), this);
		this.getServer().getPluginManager().registerEvents(new OmegaTrident(this), this);
		this.getServer().getPluginManager().registerEvents(new TotemOfDying(this), this);
		this.getServer().getPluginManager().registerEvents(new WhiteFart(this), this);
		
		new AirstrikeMarker(this);
		new Botify(this);
		new ChangeTeam(this);
		new Creator(this);
		new DiscordBot(this);
		new FroggieLegs(this);
		new Getaway(this);
		new HHelp(this);
		new HUsage(this);
		new Launch(this);
		new Medic(this);
		new OmegaTrident(this);
		new OPAxe(this);
		new PVP(this);
		new Skydive(this);
		new Slap(this);
		new Suicide(this);
		new TotemOfDying(this);
		new WhiteFart(this);
		
		this.getCommand("AirstrikeMarker").setExecutor(new AirstrikeMarker(this));
		this.getCommand("Botify").setExecutor(new Botify(this));
		this.getCommand("ChangeTeam").setExecutor (new ChangeTeam(this));
		this.getCommand("Creator").setExecutor (new Creator(this));
		this.getCommand("DiscordBot").setExecutor (new DiscordBot(this));
		this.getCommand("FroggieLegs").setExecutor(new FroggieLegs(this));
		this.getCommand("Getaway").setExecutor(new Getaway(this));
		this.getCommand("HHelp").setExecutor(new HHelp(this));
		this.getCommand("HUsage").setExecutor(new HUsage(this));
		this.getCommand("Launch").setExecutor(new Launch(this));
		this.getCommand("Medic").setExecutor(new Medic(this));
		this.getCommand("OmegaTrident").setExecutor(new OmegaTrident(this));
		this.getCommand("OPAxe").setExecutor(new OPAxe(this));
		this.getCommand("PVP").setExecutor(new PVP(this));
		this.getCommand("Skydive").setExecutor(new Skydive(this));
		this.getCommand("Slap").setExecutor(new Slap(this));
		this.getCommand("Suicide").setExecutor(new Suicide(this));
		this.getCommand("TotemOfDying").setExecutor(new TotemOfDying(this));
		this.getCommand("WhiteFart").setExecutor(new WhiteFart(this));
	}

	@Override
	public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return false;
	}

}
