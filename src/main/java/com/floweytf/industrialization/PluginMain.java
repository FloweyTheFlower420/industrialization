package com.floweytf.industrialization;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginMain extends JavaPlugin {
    private static PluginMain instance = null;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new Events(), this);
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static NamespacedKey getNamespaceKey(String value) {
        return new NamespacedKey(instance, value);
    }
}
