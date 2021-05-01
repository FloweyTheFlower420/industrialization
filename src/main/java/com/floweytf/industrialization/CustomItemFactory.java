package com.floweytf.industrialization;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class CustomItemFactory {
    private interface CustomItem {
        ItemStack create();
        void event();
    }

    public static final NamespacedKey DRILL_TEIR = PluginMain.getNamespaceKey("tier");
    public static final NamespacedKey DRILL_UPGRADES = PluginMain.getNamespaceKey("upgrades");
    public static final NamespacedKey ITEM_ENERGY = PluginMain.getNamespaceKey("energy");
    public static final NamespacedKey ITEM_MAX_ENERGY = PluginMain.getNamespaceKey("max_energy");
    public static final NamespacedKey LORE = PluginMain.getNamespaceKey("lore");
    public static final NamespacedKey ID = PluginMain.getNamespaceKey("id");

    private static ItemStack quickGenerate(int model, String id, Material material, String lore, boolean breakable) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer data = meta.getPersistentDataContainer();
        data.set(ID, PersistentDataType.STRING, id);
        data.set(LORE, PersistentDataType.STRING, lore);
        meta.setCustomModelData(model);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
        meta.setUnbreakable(!breakable);
        item.setItemMeta(meta);
        return item;
    }

    private static ItemStack applyEnergy(@NotNull ItemStack item, int max) {
        item.getItemMeta().getPersistentDataContainer().set(ITEM_MAX_ENERGY, PersistentDataType.INTEGER, max);
        item.getItemMeta().getPersistentDataContainer().set(ITEM_ENERGY, PersistentDataType.INTEGER, 0);
        return item;
    }

    public static final Map<String, CustomItem> ID_TO_ITEM = new HashMap<String, CustomItem>() {{
        put("DRILL_T1", new CustomItem() {
                @Override
                public ItemStack create() {
                    return Utils.generateDisplay(applyEnergy(
                        quickGenerate(1001, "DRILL_T1", Material.IRON_PICKAXE, "Mines in an 3x3 area\nHas 3 upgrade slots", false),
                        1000
                    ));
                }

                @Override
                public void event() {

                }
            }
        );

        put("DRILL_T2", new CustomItem() {
                @Override
                public ItemStack create() {
                    return Utils.generateDisplay(applyEnergy(
                        quickGenerate(1002, "DRILL_T2", Material.DIAMOND_PICKAXE, "Mines in an 3x3 area\nHas 5 upgrade slots", false),
                        1000 + 784
                    ));
                }

                @Override
                public void event() {

                }
            }
        );

        put("DRILL_T3", new CustomItem() {
                @Override
                public ItemStack create() {
                    return Utils.generateDisplay(applyEnergy(
                        quickGenerate(1003, "DRILL_T3", Material.NETHERITE_PICKAXE, "Mines in an 3x3 area\nHas 7 upgrade slots", false),
                        1000 + 784 * 2
                    ));
                }

                @Override
                public void event() {

                }
            }
        );

        put("UPGRADE_SPEED", new CustomItem() {
                @Override
                public ItemStack create() {
                    return Utils.generateDisplay(
                        quickGenerate(1011, "UPGRADE_SPEED", Material.PAPER, "Makes things faster!", false)
                    );
                }

                @Override
                public void event() {

                }
            }
        );
    }};
}
