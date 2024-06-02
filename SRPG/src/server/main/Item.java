package server.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import com.google.common.collect.Multimap;

public class Item {
	public static void sw_StartSword(Player p) {
		ItemStack i = new ItemStack(Material.STONE_SWORD, 1);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(ChatColor.GRAY + "Поломанный меч");
		ArrayList<String> il = new ArrayList<String>();
		il.add(ChatColor.translateAlternateColorCodes('&', "&f&l======================"));
		il.add(ChatColor.translateAlternateColorCodes('&', "&f&l======================"));
		il.add(ChatColor.translateAlternateColorCodes('&', "&f&l======================"));
		il.add(ChatColor.translateAlternateColorCodes('&', "&f&l======================"));
	}
}
