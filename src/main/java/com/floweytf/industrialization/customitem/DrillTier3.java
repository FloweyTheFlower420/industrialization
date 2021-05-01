package com.floweytf.industrialization.customitem;

import com.floweytf.industrialization.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class DrillTier3 implements CustomItem{
    @Override
    public ItemStack create() {
       return CustomItemBuilder
           .getBuilder( Material.NETHERITE_PICKAXE)
           .quickGenerate(1003, "DRILL_T3","Mines in an 3x3 area\nHas 7 upgrade slots", false)
           .applyEnergy(1000 + 784 * 2)
           .build();
    }
}
