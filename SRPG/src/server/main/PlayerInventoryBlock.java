package server.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.block.Action;

public class PlayerInventoryBlock implements Listener{
	@EventHandler
	public void BlockInv(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		//closedSlot
		ItemStack closedSlot = new ItemStack(Material.BARRIER);
		ItemMeta closedSlotMeta = closedSlot.getItemMeta();
		closedSlotMeta.setDisplayName(ChatColor.RED + "Это заблокированный слот");
		List<String> closedSlotLore = new ArrayList<String>();
		closedSlotLore.add(ChatColor.translateAlternateColorCodes('&', "&eЧто бы разблокировать слот повысте &fУровень&e."));
		closedSlotMeta.setLore(closedSlotLore);
		closedSlot.setItemMeta(closedSlotMeta);
		//deleteSlot
		ItemStack deleteSlot = new ItemStack(Material.RED_DYE, 1);
		ItemMeta deleteSlotMeta = deleteSlot.getItemMeta();
		deleteSlotMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cУдалить"));
		List<String> deleteSlotLore = new ArrayList<String>();
		deleteSlotLore.add(ChatColor.translateAlternateColorCodes('&', "&aПоложи &eпредмет в слот выше и нажми сюда."));
		deleteSlotLore.add(ChatColor.translateAlternateColorCodes('&', "&b(После удаления его нельзя будет вернуть!)"));
		deleteSlotMeta.setLore(deleteSlotLore);
		deleteSlot.setItemMeta(deleteSlotMeta);
		//inventorySet
		p.getInventory().setItem(3, closedSlot);
		p.getInventory().setItem(4, closedSlot);
		p.getInventory().setItem(5, closedSlot);
		p.getInventory().setItem(6, closedSlot);
		p.getInventory().setItem(7, closedSlot);
		for (int i = 9; i < 25; i++) {
			p.getInventory().setItem(i, closedSlot);
		}
		//player equip
				ItemStack equip = new ItemStack(Material.IRON_CHESTPLATE, 1);
				ItemMeta equipMeta = equip.getItemMeta();
				equipMeta.setDisplayName(ChatColor.GOLD + "Экипировка");
				List<String> equipLore = new ArrayList<String>();
				equipLore.add(ChatColor.translateAlternateColorCodes('&', "&aНажми&e на предмет что бы открыть меню"));
				equip.setItemMeta(equipMeta);
				p.getInventory().setItem(26, equip);
		for (int i = 27; i < 34; i++) {
			p.getInventory().setItem(i, closedSlot);
		}
		//35 skipped //35 slot skipped for ?
		ProfileLoad(p);
	}
	@EventHandler
	public void BlockInvClick(InventoryClickEvent e) {
		ItemStack clicked = e.getCurrentItem();
		Player p = (Player) e.getWhoClicked();
		if(clicked == null) return;
		if(!clicked.hasItemMeta()) return;
		if(clicked.getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', "&aНажми &eчто бы открыть &bпрофиль&e.")) || clicked.getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', "&eЧто бы разблокировать слот повысте &fУровень&e."))) {
			e.setCancelled(true);
		}
		if(clicked.getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', "&aПоложи &eпредмет в слот выше и нажми сюда."))) {
			p.getInventory().clear(17);
			e.setCancelled(true);
		}
		if(clicked.getItemMeta().getDisplayName().contains(ChatColor.translateAlternateColorCodes('&', "&bПрофиль")) && clicked.getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', "&aНажми &eчто бы открыть &bпрофиль&e."))) ProfileMenu.Menu(p);
	}
	@EventHandler
	public void SwapItemEvent(PlayerSwapHandItemsEvent e) {
		Player p = e.getPlayer();
		if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains(ChatColor.RED + "Это заблокированный слот") || p.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', "&aНажми &eчто бы открыть &bпрофиль&e."))) {
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void HotInvBlockPlaceClick(BlockPlaceEvent e) {
		Block b = e.getBlockPlaced();
		Player p = e.getPlayer();
		if(b.getType() == null) return;
		if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "Это заблокированный слот")) {
			e.setCancelled(true);
			b.setType(Material.AIR);
			p.sendMessage(ChatColor.RED + "Это заблокированный слот, ты не можешь его поставить.");
		}
		if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&bПрофиль"))) {
			e.setCancelled(true);
			ProfileMenu.Menu(p);
		}
	}
	@EventHandler
	public void DropBlockItem(PlayerDropItemEvent e) {
		Item drop = e.getItemDrop();
		Player p = e.getPlayer();
		if(drop == null) return;
		if(drop.getItemStack().getItemMeta().getDisplayName().equals(ChatColor.RED + "Это заблокированный слот")) {
			e.setCancelled(true);
			p.sendMessage(ChatColor.RED + "Это заблокированный слот, ты не можешь его выкинуть.");
		}
		if(drop.getItemStack().getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&bПрофиль"))) {
			e.setCancelled(true);
			ProfileMenu.Menu(p);
		}
	}
	@EventHandler
	public void ClickEv(PlayerInteractEvent e) {
		Player p =e.getPlayer();
		if(e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
		if(e.getAction() != Action.LEFT_CLICK_AIR && e.getAction() != Action.LEFT_CLICK_BLOCK) return;
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) EquipMenu.equipOpen(p);
		if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) EquipMenu.equipOpen(p);
	}
	public static void ProfileLoad(Player p) {
		Plugin plugin = SRPG.getPlugin(SRPG.class);
		ItemStack playerMenu = new ItemStack(Material.PLAYER_HEAD, 1);
		ItemMeta playerMenuMeta = playerMenu.getItemMeta();
		playerMenuMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&bПрофиль"));
		List<String> playerMenuLore = new ArrayList<String>();
		playerMenuLore.add(ChatColor.translateAlternateColorCodes('&', "&aНажми &eчто бы открыть &bпрофиль&e."));
		playerMenuLore.add(ChatColor.translateAlternateColorCodes('&', "&eТвой уровень: &f" + plugin.getConfig().getInt("Users." + p.getName() + ".level")));
		playerMenuMeta.setLore(playerMenuLore);
		playerMenu.setItemMeta(playerMenuMeta);
		SkullMeta playerMenuSkullMeta = (SkullMeta) playerMenu.getItemMeta();
		playerMenuSkullMeta.setOwningPlayer(p);
		playerMenu.setItemMeta(playerMenuSkullMeta);
		p.getInventory().setItem(8, playerMenu);
	}
}
