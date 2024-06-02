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
		if(clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "�����")) {
			plugin.getConfig().set("Users." + p.getName() + ".race", "n");
			p.closeInventory();
			plugin.saveConfig();
		}
		if(clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "�����������")) {
			plugin.getConfig().set("Users." + p.getName() + ".race", "h");
			p.closeInventory();
			plugin.saveConfig();
		}
		if(clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "������")) {
			plugin.getConfig().set("Users." + p.getName() + ".race", "l");
			p.closeInventory();
			plugin.saveConfig();
		}
		if(clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "�����")) {
			plugin.getConfig().set("Users." + p.getName() + ".race", "e");
			p.closeInventory();
			plugin.saveConfig();
		}
	}
	public void InventoryRace(Player p) {
		Inventory inv = Bukkit.createInventory(null, 27, ChatColor.translateAlternateColorCodes('&', "&a�������� �����"));
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
		nordsItemMeta.setDisplayName(ChatColor.GOLD + "�����");
		List<String> nordsLore = new ArrayList<String>();
		nordsLore.add(ChatColor.GREEN + "��� ������ ����� ������� �� �������");
		nordsLore.add("===========================================");
		nordsLore.add(ChatColor.YELLOW + "�������� ����, � ���� �����");
		nordsLore.add(ChatColor.YELLOW + "����� ������ � ������������� ����!");
		nordsItemMeta.setLore(nordsLore);
		nordsItem.setItemMeta(nordsItemMeta);
		inv.setItem(10, nordsItem);
		//�����������
		ItemStack poluItem = new ItemStack(Material.GOLD_INGOT, 1);
		ItemMeta poluItemMeta = poluItem.getItemMeta();
		poluItemMeta.setDisplayName(ChatColor.GOLD + "�����������");
		List<String> poluLore = new ArrayList<String>();
		poluLore.add(ChatColor.GREEN + "��� ������ ����� ������� �� �������");
		poluLore.add("===========================================");
		poluLore.add(ChatColor.YELLOW + "����� ������� � ������ �����,");
		poluLore.add(ChatColor.YELLOW + "������� �������� ������ ��� ��������� �� ����.");
		poluItemMeta.setLore(poluLore);
		poluItem.setItemMeta(poluItemMeta);
		inv.setItem(12, poluItem);
		//������
		ItemStack lukeItem = new ItemStack(Material.BONE, 1);
		ItemMeta lukeItemMeta = lukeItem.getItemMeta();
		lukeItemMeta.setDisplayName(ChatColor.GOLD + "������");
		List<String> lukeLore = new ArrayList<String>();
		lukeLore.add(ChatColor.GREEN + "��� ������ ����� ������� �� �������");
		lukeLore.add("===========================================");
		lukeLore.add(ChatColor.YELLOW + "�������� ������� ��������� ��������� ����� ������");
		lukeLore.add(ChatColor.YELLOW + "������ ���� ���� �� ��� ����, � �� ��������");
		lukeLore.add(ChatColor.YELLOW + "�� ���� � ����� �� �� ��� �� ������� �� ��������.");
		lukeItemMeta.setLore(lukeLore);
		lukeItem.setItemMeta(lukeItemMeta);
		inv.setItem(14, lukeItem);
		//�����
		ItemStack elfItem = new ItemStack(Material.OAK_SAPLING, 1);
		ItemMeta elfItemMeta = elfItem.getItemMeta();
		elfItemMeta.setDisplayName(ChatColor.GOLD + "�����");
		List<String> elfLore = new ArrayList<String>();
		elfLore.add(ChatColor.GREEN + "��� ������ ����� ������� �� �������");
		elfLore.add("===========================================");
		elfLore.add(ChatColor.YELLOW + "��� ��������� � ������� �� ��� ����");
		elfLore.add(ChatColor.YELLOW + "����� ��������� ��� ����� ����,");
		elfLore.add(ChatColor.YELLOW + "��� ��� �� �������� ����������� � �����.");
		elfItemMeta.setLore(elfLore);
		elfItem.setItemMeta(elfItemMeta);
		inv.setItem(16, elfItem);
		
		p.openInventory(inv);
	}
	public void InventoryClasses(Player p) {
		Inventory inv = Bukkit.createInventory(null, 27, ChatColor.translateAlternateColorCodes('&', "&a�������� �����"));
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
