package com.floweytf.industrialization.customitem;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class RocketTier1 implements CustomItem{
    @Override
    public ItemStack create() {
        return CustomItemBuilder
            .getBuilder(Material.FIREWORK_ROCKET)
            .quickGenerate(1021, "ROCKET_T1", "Takes you out of this world!\nDestination: The Moon", false)
            .build();
    }
}
