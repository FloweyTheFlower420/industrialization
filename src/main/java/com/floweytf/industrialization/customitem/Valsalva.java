package com.floweytf.industrialization.customitem;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

class Valsalva implements CustomItem {
    @Override
    public ItemStack create() {
        return CustomItemBuilder
            .getBuilder(Material.NETHERITE_HELMET)
            .quickGenerate(1061, "VALSALVA","Lets you breath in space", false)
            .build();
    }
}
