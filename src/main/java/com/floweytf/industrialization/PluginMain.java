package com.floweytf.industrialization;

import com.floweytf.industrialization.customitem.CustomItemRegistry;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginMain extends JavaPlugin {
    private static PluginMain instance = null;
    public final CustomItemRegistry ITEM_REGISTRY = new CustomItemRegistry();

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new Events(), this);
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static PluginMain getInstance() {
        return instance;
    }

    public static NamespacedKey getNamespaceKey(String value) {
        return new NamespacedKey(instance, value);
    }
}
