package com.floweytf.industrialization.customitem;

import com.floweytf.industrialization.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

class SellWand implements CustomItem {
    @Override
    public ItemStack create() {
        return CustomItemBuilder
            .getBuilder( Material.GOLDEN_SHOVEL)
            .quickGenerate(1031, "SELL_WAND", "Sells the contents of a chest instantly!", false)
            .build();
    }
}
