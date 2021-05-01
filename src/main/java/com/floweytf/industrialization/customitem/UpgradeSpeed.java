package com.floweytf.industrialization.customitem;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class UpgradeSpeed implements CustomItem{
    @Override
    public ItemStack create() {
        return CustomItemBuilder
            .getBuilder(Material.PAPER)
            .quickGenerate(1011, "UPGRADE_SPEED", "Makes things faster!", false)
            .build();
    }
}
