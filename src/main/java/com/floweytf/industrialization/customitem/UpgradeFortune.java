package com.floweytf.industrialization.customitem;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class UpgradeFortune implements CustomItem{
    @Override
    public ItemStack create() {
        return CustomItemBuilder
            .getBuilder(Material.PAPER)
            .quickGenerate(1013, "UPGRADE_FORTUNE", "Recieve more items from drilled blocks!", false)
            .build();
    }
}
