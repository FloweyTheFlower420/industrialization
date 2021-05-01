package com.floweytf.industrialization.customitem;

import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.Map;

public class CustomItemRegistry {
    public final Map<String, CustomItem> ID_TO_ITEM = new HashMap<String, CustomItem>() {{
        put("DRILL_T1", new DrillTier1());
        put("DRILL_T2", new DrillTier2());
        put("DRILL_T3", new DrillTier3());

        put("UPGRADE_SILK_TOUCH", new UpgradeSilkTouch());
        put("UPGRADE_FORTUNE", new UpgradeFortune());
        put("UPGRADE_ENERGY", new UpgradeEnergy());
        put("UPGRADE_SPEED", new UpgradeSpeed());

        put("ROCKET_T1",new RocketTier1());
        put("ROCKET_T2", new RocketTier2());

        put("SELL_WAND", new SellWand());
        put("GENERATOR", new Generator());
        put("SUICIDE_VEST", new SuicideVest());
        put("VALSALVA", new Valsalva());
    }};

    public CustomItem getByItem(ItemStack itemStack) {
        String id = itemStack.getItemMeta().getPersistentDataContainer().get(CustomItemBuilder.ID, PersistentDataType.STRING);
        return ID_TO_ITEM.get(id);
    }

}
