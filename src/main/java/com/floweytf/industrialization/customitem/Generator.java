package com.floweytf.industrialization.customitem;

import com.floweytf.industrialization.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

class Generator implements CustomItem {
    @Override
    public ItemStack create() {
        return CustomItemBuilder
            .getBuilder(Material.SMOKER)
            .quickGenerate(1041, "GENERATOR", "Makes energy from fuels", false)
            .build();
    }
}
