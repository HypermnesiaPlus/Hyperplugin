package me.hypermnesia.Medic;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		this.getCommand("Medic").setExecutor(new Medic());
	}
	
	@Override
	public void onDisable() {
		
	}

}
