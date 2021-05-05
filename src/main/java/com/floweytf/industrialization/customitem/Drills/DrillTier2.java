package com.floweytf.industrialization.customitem;

import com.floweytf.industrialization.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class DrillTier2 implements CustomItem {
    @Override
    public ItemStack create() {
        return CustomItemBuilder
            .getBuilder(Material.DIAMOND_PICKAXE)
            .quickGenerate(1002, "DRILL_T2","Mines in an 3x3 area\nHas 5 upgrade slots", false)
            .applyEnergy(1000 + 784)
            .build();
    }
}
