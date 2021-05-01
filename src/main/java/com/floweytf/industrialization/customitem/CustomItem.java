package com.floweytf.industrialization.customitem;

import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

public interface CustomItem {
    ItemStack create();

    default void onInventoryClickEvent(InventoryClickEvent event) {
    }

    default void onPlayerDropItemEvent(PlayerDropItemEvent event) {
    }

    default void onBlockPlaceEvent(BlockPlaceEvent event) {
    }

    default void onPlayerInteractEvent(PlayerInteractEvent event) {
    }

    default void onEntityDeathEvent(EntityDeathEvent event) {
    }

    default void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
    }

    default void onPlayerSwapHandItemsEvent(PlayerSwapHandItemsEvent event) {
    }
}
