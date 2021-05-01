package com.floweytf.industrialization;

import com.floweytf.industrialization.customitem.CustomItemBuilder;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

public class Events implements Listener {
    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) { //YOU ARE BAD
        CustomItemBuilder.getByItem(event.getCurrentItem()).onInventoryClickEvent(event);
    }
    @EventHandler
    public void onPlayerDropItemEvent(PlayerDropItemEvent event) { //BAD 2.0
        CustomItemBuilder.getByItem(event.getItemDrop().getItemStack()).onPlayerDropItemEvent(event);
    }
    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        CustomItemBuilder.getByItem(event.getItemInHand()).onBlockPlaceEvent(event);
    }
    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        CustomItemBuilder.getByItem(event.getItem()).onPlayerInteractEvent(event);
    }
    @EventHandler
    public void onEntityDeathEvent(EntityDeathEvent event) {
        for (ItemStack itemStack : event.getDrops()) {
            CustomItemBuilder.getByItem(itemStack).onEntityDeathEvent(event);
        }
    }
    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof LivingEntity && ((LivingEntity) event.getDamager()).getEquipment() != null)
            CustomItemBuilder.getByItem(((LivingEntity) event.getDamager()).getEquipment().getItemInMainHand())
                    .onEntityDamageByEntityEvent(event);
    }
    @EventHandler
    public void onPlayerSwapHandItemsEvent(PlayerSwapHandItemsEvent event) {
        CustomItemBuilder.getByItem(event.getMainHandItem()).onPlayerSwapHandItemsEvent(event);
    }
}