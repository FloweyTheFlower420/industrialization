package com.floweytf.industrialization.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryBuilder {
    private Inventory handle = null;
    private Player player;

    private static ItemStack createFiller() {
        ItemStack stack = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS, 1);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(" ");
        stack.setItemMeta(meta);
        return stack;
    }

    private InventoryBuilder(int size, String name, Player p) {
        handle = Bukkit.createInventory(p, size, name);
        player = p;
    }

    public static InventoryBuilder getBuilder(int size, String name, Player p) {
        return new InventoryBuilder(size, name, p);
    }

    public InventoryBuilder restrict() {
        for(int i = 0 ; i < handle.getSize() ; i++)
            handle.setItem(i, createFiller());

        return this;
    }

    public InventoryBuilder restrict(int x, int y) {
        handle.setItem(x * 9 + y, createFiller());
        return this;
    }

    public InventoryBuilder restrict(int x1, int y1, int x2, int y2) {
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                handle.setItem(i * 9 + j, createFiller());
            }
        }
        return this;
    }

    public InventoryBuilder empty() {
        for(int i = 0 ; i < handle.getSize() ; i++)
            handle.setItem(i, new ItemStack(Material.AIR));

        return this;
    }

    public InventoryBuilder empty(int x, int y) {
        handle.setItem(x * 9 + y, new ItemStack(Material.AIR));
        return this;
    }

    public InventoryBuilder empty(int x1, int y1, int x2, int y2) {
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                handle.setItem(i * 9 + j, new ItemStack(Material.AIR));
            }
        }
        return this;
    }

    public InventoryBuilder set(int x, int y, ItemStack s) {
        handle.setItem(x * 9 + y, s);
        return this;
    }

    public Inventory build() {
        GuiManager.getInstance().register(player, handle);
        return handle;
    }
}
