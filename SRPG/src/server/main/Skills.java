package server.main;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;       
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class Skills implements Listener{
	
	private Plugin plugin = SRPG.getPlugin(SRPG.class);
	public int mainLevel = 1;
	public int skillPoints = 2;
	private int kills;
	private int mined;
	private int wood;
	
	public ArrayList<Material> woodList = new ArrayList<Material>();
	public HashMap<Material, Integer> oreList = new HashMap<Material, Integer>();
	
	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		mainLevel = plugin.getConfig().getInt("Users." + p.getName() + ".level");
		kills = plugin.getConfig().getInt("Users." + p.getName() + ".skills.strength");
		mined = plugin.getConfig().getInt("Users." + p.getName() + ".skills.mining");
		wood = plugin.getConfig().getInt("Users." + p.getName() + ".skills.wood");
		skillPoints = plugin.getConfig().getInt("Users." + p.getName() + ".skillPoints");
	}
	@EventHandler
	public void StrengthSkills(EntityDeathEvent e){
	    Player killer = (Player) e.getEntity().getKiller();
	    if(killer instanceof Player) return;
	    if(killer instanceof Player) {
	    	kills++;
		    plugin.getConfig().set("Users." + killer.getName() + ".skills.strength", kills);
		    plugin.saveConfig();
		    mainLevel(killer);
	    }
	 }
	@EventHandler
	public void MiningSkills(BlockBreakEvent e){
		oreList.put(Material.COAL_ORE, 2);
		oreList.put(Material.GOLD_ORE, 2);
		oreList.put(Material.LAPIS_ORE, 2);
		oreList.put(Material.DIAMOND_ORE, 2);
		oreList.put(Material.REDSTONE_ORE, 2);
		oreList.put(Material.EMERALD_ORE, 2);
		oreList.put(Material.IRON_ORE, 2);
		oreList.put(Material.NETHER_QUARTZ_ORE, 2);
	    Player p = e.getPlayer();
	    Block b = e.getBlock();
	    Material hand = p.getInventory().getItemInMainHand().getType();
	    if(hand == null) return;
	    if(hand == Material.WOODEN_SWORD || hand == Material.STONE_SWORD || hand == Material.IRON_SWORD || hand == Material.GOLDEN_SWORD || hand == Material.DIAMOND_SWORD) return;
	    else {
		    if(oreList.containsKey(b.getType())) {
		    	mined = mined + oreList.get(b.getType());
		    	plugin.getConfig().set("Users." + p.getName() + ".skills.mining", mined);
		    	plugin.saveConfig();
		    	mainLevel(p);
		    }
	    }
	 }
	@EventHandler
	public void WoodCutingSkills(BlockBreakEvent e){
		woodList.add(Material.ACACIA_LOG);
		woodList.add(Material.BIRCH_LOG);
		woodList.add(Material.DARK_OAK_LOG);
		woodList.add(Material.OAK_LOG);
		woodList.add(Material.SPRUCE_LOG);
		woodList.add(Material.JUNGLE_LOG);
	    Player p = e.getPlayer();
	    Block b = e.getBlock();
	    Material hand = p.getInventory().getItemInMainHand().getType();
	    if(hand == null) return;
	    if(hand == Material.WOODEN_SWORD || hand == Material.STONE_SWORD || hand == Material.IRON_SWORD || hand == Material.GOLDEN_SWORD || hand == Material.DIAMOND_SWORD) return;
	    else {
		    if(woodList.contains(b.getType())) {
		    	wood++;
		    	plugin.getConfig().set("Users." + p.getName() + ".skills.wood", wood);
		    	plugin.saveConfig();
		    	mainLevel(p);
		    }
	    }
	 }
	public void mainLevel(Player p) {
		if(kills >= 200 && mined >= 500 && wood >= 200) {
			PlayerInventoryBlock.ProfileLoad(p);
			mainLevel++;
			skillPoints = skillPoints + 2;
			plugin.getConfig().set("Users." + p.getName() + ".level", mainLevel);
			plugin.getConfig().set("Users." + p.getName() + ".skillPoints", skillPoints);
			plugin.saveConfig();
		}
	}
}
