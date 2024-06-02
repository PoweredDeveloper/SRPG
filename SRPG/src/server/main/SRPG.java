package server.main;

import org.bukkit.plugin.java.JavaPlugin;

public class SRPG extends JavaPlugin{
	public void onEnable() {
		getLogger().info("SRPG was successfully enabled!");
		getServer().getPluginManager().registerEvents(new PlayerInventoryBlock(), this);
		getServer().getPluginManager().registerEvents(new Skills(), this);
		getServer().getPluginManager().registerEvents(new ProfileMenu(), this);
		getServer().getPluginManager().registerEvents(new StartWindow(), this);
		loadSkills();
	}
	public void onDisable() {
		getLogger().info("SRPG was disabled!");
	}
	public void loadSkills() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
}
