package me.hypermnesia.suicide;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		this.getCommand("Suicide").setExecutor(new Suicide());
	}
	
	@Override
	public void onDisable() {
		
	}

}
