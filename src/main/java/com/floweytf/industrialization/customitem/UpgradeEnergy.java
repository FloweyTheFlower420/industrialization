package com.floweytf.industrialization.customitem;

import com.floweytf.industrialization.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class UpgradeEnergy implements CustomItem{
    @Override
    public ItemStack create() {
        return CustomItemBuilder
            .getBuilder(Material.PAPER)
            .quickGenerate(1014, "UPGRADE_ENERGY", "Drills use less energy!", false)
            .build();
    }
}
