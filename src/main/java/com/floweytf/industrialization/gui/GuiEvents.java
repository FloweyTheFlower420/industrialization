package com.floweytf.industrialization.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class GuiEvents implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player))
            return;

        if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
            return;
        }
        Inventory gui = GuiManager.getInstance().get((Player) e.getWhoClicked());

        if (gui == null)
            return;

        if(e.getCurrentItem().getType() == Material.LIGHT_GRAY_STAINED_GLASS_PANE && e.getCurrentItem().getItemMeta().getDisplayName().equals(" "))
            e.setCancelled(true);
    }
}
