package com.floweytf.industrialization.customitem;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class UpgradeSilkTouch implements CustomItem{
    @Override
    public ItemStack create() {
        return CustomItemBuilder
            .getBuilder(Material.PAPER)
            .quickGenerate(1012, "UPGRADE_SILK_TOUCH", "Lets drills pick up delicate materials!", false)
            .build();
    }
}
