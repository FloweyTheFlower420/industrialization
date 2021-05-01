package com.floweytf.industrialization;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public static ItemStack generateDisplay(@NotNull ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer data = meta.getPersistentDataContainer();
        List<String> lore = new ArrayList<>();
        if (data.getOrDefault(CustomItemFactory.LORE, PersistentDataType.STRING, "").length() != 0)
            lore.addAll(Arrays.asList(data.get(CustomItemFactory.LORE, PersistentDataType.STRING).split("\n")));
        if(isEnergy(item))
            lore.add(colorFromItem(item) + data.get(CustomItemFactory.ITEM_ENERGY, PersistentDataType.INTEGER) + "&r/" + data.get(CustomItemFactory.ITEM_MAX_ENERGY, PersistentDataType.INTEGER));
        lore.add("&7ID: " + data.getOrDefault(CustomItemFactory.ID, PersistentDataType.STRING, "UNKNOWN_ID"));
        return item;
    }

    public static boolean isDrill(@NotNull ItemStack item) {
        return item.getItemMeta().getPersistentDataContainer().getOrDefault(CustomItemFactory.DRILL_TEIR, PersistentDataType.INTEGER, 0) > 0;
    }

    public static boolean isEnergy(@NotNull ItemStack item) {
        return item.getItemMeta().getPersistentDataContainer().getOrDefault(CustomItemFactory.ITEM_ENERGY, PersistentDataType.INTEGER, -1) > -1;
    }

    public static String colorFromItem(@NotNull ItemStack item) {
        PersistentDataContainer data = item.getItemMeta().getPersistentDataContainer();
        double charge = (double)data.get(CustomItemFactory.ITEM_MAX_ENERGY, PersistentDataType.INTEGER) / (double)data.get(CustomItemFactory.ITEM_ENERGY, PersistentDataType.INTEGER);

        if(charge >  2.0 / 3.0)
            return "&a";
        if(charge > 1.0 / 3.0)
            return "&6";
        return "&c";
    }


}
