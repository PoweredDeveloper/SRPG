package server.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class StartWindow implements Listener{
	private Plugin plugin = SRPG.getPlugin(SRPG.class);
	@EventHandler
	public void onJoinFirst(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(p.hasPlayedBefore()) return;
		if(!p.hasPlayedBefore()) {
			plugin.getConfig().set("Users." + p.getName() + ".race", "null");
			plugin.saveConfig();
		}
	}
	@EventHandler
	public void InvClose(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(plugin.getConfig().get("Users." + p.getName() + ".race") != "null") return;
		if(plugin.getConfig().get("Users." + p.getName() + ".race") == "null") {
			InventoryRace(p);
		}
	}
	@EventHandler
	public void OnClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		ItemStack clicked = e.getCurrentItem();
		if(clicked == null) return;
		if(!clicked.hasItemMeta()) return;
		if(clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Норды")) {
			plugin.getConfig().set("Users." + p.getName() + ".race", "n");
			p.closeInventory();
			plugin.saveConfig();
		}
		if(clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Полурослики")) {
			plugin.getConfig().set("Users." + p.getName() + ".race", "h");
			p.closeInventory();
			plugin.saveConfig();
		}
		if(clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Люканы")) {
			plugin.getConfig().set("Users." + p.getName() + ".race", "l");
			p.closeInventory();
			plugin.saveConfig();
		}
		if(clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Эльфы")) {
			plugin.getConfig().set("Users." + p.getName() + ".race", "e");
			p.closeInventory();
			plugin.saveConfig();
		}
	}
	public void InventoryRace(Player p) {
		Inventory inv = Bukkit.createInventory(null, 27, ChatColor.translateAlternateColorCodes('&', "&aВыберите рассу"));
		//NullInInv
		ItemStack nullInInv = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
		ItemMeta nullInInvMeta = nullInInv.getItemMeta();
		nullInInvMeta.setDisplayName(" ");
		nullInInv.setItemMeta(nullInInvMeta);
		//setItem
		for (int i = 0; i < 27; i++) {
			inv.setItem(i, nullInInv);
		}
		//Nords
		ItemStack nordsItem = new ItemStack(Material.IRON_AXE, 1);
		ItemMeta nordsItemMeta = nordsItem.getItemMeta();
		nordsItemMeta.setDisplayName(ChatColor.GOLD + "Норды");
		List<String> nordsLore = new ArrayList<String>();
		nordsLore.add(ChatColor.GREEN + "Для выбора рассы нажмите на предмет");
		nordsLore.add("===========================================");
		nordsLore.add(ChatColor.YELLOW + "Северные люди, в чьих жилах");
		nordsLore.add(ChatColor.YELLOW + "течёт чистая и непоколебимая сила!");
		nordsItemMeta.setLore(nordsLore);
		nordsItem.setItemMeta(nordsItemMeta);
		inv.setItem(10, nordsItem);
		//полурослики
		ItemStack poluItem = new ItemStack(Material.GOLD_INGOT, 1);
		ItemMeta poluItemMeta = poluItem.getItemMeta();
		poluItemMeta.setDisplayName(ChatColor.GOLD + "Полурослики");
		List<String> poluLore = new ArrayList<String>();
		poluLore.add(ChatColor.GREEN + "Для выбора рассы нажмите на предмет");
		poluLore.add("===========================================");
		poluLore.add(ChatColor.YELLOW + "Очень быстрые и ловкие войны,");
		poluLore.add(ChatColor.YELLOW + "которые устранят любого кто преградит им путь.");
		poluItemMeta.setLore(poluLore);
		poluItem.setItemMeta(poluItemMeta);
		inv.setItem(12, poluItem);
		//Люканы
		ItemStack lukeItem = new ItemStack(Material.BONE, 1);
		ItemMeta lukeItemMeta = lukeItem.getItemMeta();
		lukeItemMeta.setDisplayName(ChatColor.GOLD + "Люканы");
		List<String> lukeLore = new ArrayList<String>();
		lukeLore.add(ChatColor.GREEN + "Для выбора рассы нажмите на предмет");
		lukeLore.add("===========================================");
		lukeLore.add(ChatColor.YELLOW + "Покрытые шерстью гуманоиды благодаря своим глазам");
		lukeLore.add(ChatColor.YELLOW + "увидят свою цель за три мили, а их обоняние");
		lukeLore.add(ChatColor.YELLOW + "не даст и шанса на то что бы застать их врасплох.");
		lukeItemMeta.setLore(lukeLore);
		lukeItem.setItemMeta(lukeItemMeta);
		inv.setItem(14, lukeItem);
		//Эльфы
		ItemStack elfItem = new ItemStack(Material.OAK_SAPLING, 1);
		ItemMeta elfItemMeta = elfItem.getItemMeta();
		elfItemMeta.setDisplayName(ChatColor.GOLD + "Эльфы");
		List<String> elfLore = new ArrayList<String>();
		elfLore.add(ChatColor.GREEN + "Для выбора рассы нажмите на предмет");
		elfLore.add("===========================================");
		elfLore.add(ChatColor.YELLOW + "Эти остроухие и хрупкие на вид люди");
		elfLore.add(ChatColor.YELLOW + "имеют закалённый как сталь нрав,");
		elfLore.add(ChatColor.YELLOW + "что даёт им огромные способности к магии.");
		elfItemMeta.setLore(elfLore);
		elfItem.setItemMeta(elfItemMeta);
		inv.setItem(16, elfItem);
		
		p.openInventory(inv);
	}
	public void InventoryClasses(Player p) {
		Inventory inv = Bukkit.createInventory(null, 27, ChatColor.translateAlternateColorCodes('&', "&aВыберите класс"));
		//NullInInv
		ItemStack nullInInv = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
		ItemMeta nullInInvMeta = nullInInv.getItemMeta();
		nullInInvMeta.setDisplayName(" ");
		nullInInv.setItemMeta(nullInInvMeta);
		//setItem
		for (int i = 0; i < 27; i++) {
			inv.setItem(i, nullInInv);
		}
	}
}
