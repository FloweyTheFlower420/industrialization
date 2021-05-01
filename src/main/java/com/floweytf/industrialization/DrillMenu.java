package com.floweytf.industrialization;

import com.floweytf.industrialization.gui.InventoryBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DrillMenu {
    public void open(ItemStack item, Player player) {
        player.openInventory(
            InventoryBuilder.getBuilder(3, "Drill", player)
            .restrict()
            .build()
        );
    }
}
