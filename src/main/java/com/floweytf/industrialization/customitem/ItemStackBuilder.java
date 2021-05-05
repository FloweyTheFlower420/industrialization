package com.floweytf.industrialization.customitem;

import com.floweytf.industrialization.PluginMain;
import com.floweytf.industrialization.Utils;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CustomItemBuilder {
    public static final NamespacedKey ITEM_ENERGY = PluginMain.getNamespaceKey("energy");
    public static final NamespacedKey ITEM_MAX_ENERGY = PluginMain.getNamespaceKey("max_energy");
    public static final NamespacedKey LORE = PluginMain.getNamespaceKey("lore");
    public static final NamespacedKey ID = PluginMain.getNamespaceKey("id");

    private ItemStack item;
    private ItemMeta meta;

    private CustomItemBuilder(Material m ) {
        item = new ItemStack(m);
        meta = item.getItemMeta();
    }

    public static CustomItemBuilder getBuilder(Material m) {
        return new CustomItemBuilder(m);
    }

    public CustomItemBuilder setDisplayName(String name) {
        meta.setDisplayName(name);
        return this;
    }

    <T, Z> CustomItemBuilder setData(@NotNull NamespacedKey key, @NotNull PersistentDataType<T, Z> type, @NotNull Z value) {
        meta.getPersistentDataContainer().set(key, type, value);
        return this;
    }

    public CustomItemBuilder setCustomModelData(int v) {
        meta.setCustomModelData(v);
        return this;
    }

    public CustomItemBuilder setFlags(ItemFlag... flags) {
        meta.addItemFlags(flags);
        return this;
    }

    public CustomItemBuilder setUnbreakable(boolean b) {
        meta.setUnbreakable(b);
        return this;
    }

    public ItemStack build() {
        generateDisplay();
        item.setItemMeta(meta);
        return item;
    }

    public CustomItemBuilder quickGenerate(String id, int model, String lore, boolean breakable) {
        return this
            .setData(ID, PersistentDataType.STRING, id)
            .setData(LORE, PersistentDataType.STRING, lore)
            .setCustomModelData(model)
            .setFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE)
            .setUnbreakable(!breakable);
    }

    public CustomItemBuilder applyEnergy(int max) {
        return this
            .setData(ITEM_MAX_ENERGY, PersistentDataType.INTEGER, max)
            .setData(ITEM_ENERGY, PersistentDataType.INTEGER, 0);
    }

    private CustomItemBuilder generateDisplay() {
        PersistentDataContainer data = meta.getPersistentDataContainer();
        List<String> lore = new ArrayList<>();
        if (data.getOrDefault(CustomItemBuilder.LORE, PersistentDataType.STRING, "").length() != 0)
            lore.addAll(Arrays.asList(data.get(CustomItemBuilder.LORE, PersistentDataType.STRING).split("\n")));
        if(Utils.isEnergy(item))
            lore.add(Utils.colorFromItem(item) + data.get(CustomItemBuilder.ITEM_ENERGY, PersistentDataType.INTEGER) + "&r/" + data.get(CustomItemBuilder.ITEM_MAX_ENERGY, PersistentDataType.INTEGER));
        lore.add("&7ID: " + data.getOrDefault(CustomItemBuilder.ID, PersistentDataType.STRING, "UNKNOWN_ID"));
        return this;
    }
}
