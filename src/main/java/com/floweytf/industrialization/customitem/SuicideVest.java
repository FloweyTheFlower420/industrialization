package com.floweytf.industrialization.customitem;

import com.floweytf.industrialization.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

class SuicideVest implements CustomItem {
    @Override
    public ItemStack create() {
        return CustomItemBuilder
            .getBuilder( Material.CHAINMAIL_CHESTPLATE)
            .quickGenerate(1051, "SUICIDE_VEST","Sacrifice yourself for your country!", false)
            .build();
    }
}
