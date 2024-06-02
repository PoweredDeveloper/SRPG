package server.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EquipMenu {
	public static void equipOpen(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.GOLD + "Ёкипировка");
		p.openInventory(inv);
		//null slot
		ItemStack nullInSlot = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta nullInSlotMeta = nullInSlot.getItemMeta();
		nullInSlotMeta.setDisplayName(" ");
		nullInSlot.setItemMeta(nullInSlotMeta);
		//Inv
		for (int i = 0; i < 53; i++) {
			inv.setItem(i, nullInSlot);
		}
	}
}
