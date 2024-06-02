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
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

public class ProfileMenu implements Listener{
	public static void Menu(Player p) {
		Plugin plugin = SRPG.getPlugin(SRPG.class);
		p.updateInventory();
		Inventory inv = Bukkit.createInventory(null, 27, ChatColor.translateAlternateColorCodes('&', "&b������� &f" + p.getName()));
		//nullInInv
		ItemStack nullInInv = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
		ItemMeta nullInInvMeta = nullInInv.getItemMeta();
		nullInInvMeta.setDisplayName(" ");
		nullInInv.setItemMeta(nullInInvMeta);
		//player skills
		ItemStack skills = new ItemStack(Material.BLAZE_POWDER, 1);
		ItemMeta skillsMeta = skills.getItemMeta();
		skillsMeta.setDisplayName(ChatColor.GOLD + "������");
		List<String> skillsLore = new ArrayList<String>();
		skillsLore.add(ChatColor.translateAlternateColorCodes('&', "&a�����&e �� ������� ��� �� ������� ����"));
		skills.setItemMeta(skillsMeta);
		//player equip
		ItemStack equip = new ItemStack(Material.IRON_CHESTPLATE, 1);
		ItemMeta equipMeta = equip.getItemMeta();
		equipMeta.setDisplayName(ChatColor.GOLD + "����������");
		List<String> equipLore = new ArrayList<String>();
		equipLore.add(ChatColor.translateAlternateColorCodes('&', "&a�����&e �� ������� ��� �� ������� ����"));
		equip.setItemMeta(equipMeta);
		//player profile
		ItemStack profile = new ItemStack(Material.PLAYER_HEAD, 1);
		ItemMeta profileMeta = profile.getItemMeta();
		profileMeta.setDisplayName(ChatColor.GOLD + "�������");
		List<String> profileLore = new ArrayList<String>();
		profileLore.add(ChatColor.translateAlternateColorCodes('&', "&b���� ��������������:"));
		profileLore.add(ChatColor.translateAlternateColorCodes('&', "&e����: &f&l" + plugin.getConfig().getInt("Users." + p.getName() + ".skills.strength")));
		profileLore.add(ChatColor.translateAlternateColorCodes('&', "&e������ ����: &f&l" + plugin.getConfig().getInt("Users." + p.getName() + ".skills.mining")));
		profileLore.add(ChatColor.translateAlternateColorCodes('&', "&e��������� ����: &f&l" + plugin.getConfig().getInt("Users." + p.getName() + ".skills.wood")));
		profileLore.add(ChatColor.translateAlternateColorCodes('&', "&a=================="));
		profileLore.add(ChatColor.translateAlternateColorCodes('&', "&e���� �����: &f&l" + plugin.getConfig().getInt("Users." + p.getName() + ".skillPoints")));
		profileMeta.setLore(profileLore);
		profile.setItemMeta(profileMeta);
		SkullMeta profileSkullMeta = (SkullMeta) profile.getItemMeta();
		profileSkullMeta.setOwningPlayer(p);
		profile.setItemMeta(profileSkullMeta);
		
		//server menu
		//����� chest  command
		//donate menu
		//����� chest command
		for (int i = 0; i < 26; i++) {
			inv.setItem(i, nullInInv);
		}
		inv.setItem(10, skills);
		inv.setItem(11, equip);
		inv.setItem(13, profile);
		p.openInventory(inv);
	}
	@EventHandler
	public void BlockInvClick(InventoryClickEvent e) {
		ItemStack clicked = e.getCurrentItem();
		Player p = (Player) e.getWhoClicked();
		if(clicked == null) return;
		if(!clicked.hasItemMeta()) return;
		if(clicked.getItemMeta().getDisplayName().equals(" ")) {
			e.setCancelled(true);
		}
		if(clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "������")) {
			e.setCancelled(true);
		}
		if(clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "����������")) {
			e.setCancelled(true);
			EquipMenu.equipOpen(p);
		}
		if(clicked.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "�������")) {
			e.setCancelled(true);
		}
	}
}
