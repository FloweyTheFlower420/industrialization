package com.floweytf.industrialization.customitem;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class RocketTier2 implements CustomItem{
    @Override
    public ItemStack create() {
        return CustomItemBuilder
            .getBuilder(Material.FIREWORK_ROCKET)
            .quickGenerate(1022, "ROCKET_T2", "Takes you out of this world!\nDestination: Mars", false)
            .build();
    }
}
