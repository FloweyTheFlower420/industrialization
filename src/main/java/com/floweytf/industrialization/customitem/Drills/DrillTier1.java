package com.floweytf.industrialization.customitem;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class DrillTier1 implements CustomItem {
    @Override
    public ItemStack create() {
        return CustomItemBuilder
            .getBuilder(Material.IRON_PICKAXE)
            .quickGenerate(1001, "DRILL_T1", "Mines in an 3x3 area\nHas 3 upgrade slots", false)
            .applyEnergy(1000)
            .build();
    }
}
