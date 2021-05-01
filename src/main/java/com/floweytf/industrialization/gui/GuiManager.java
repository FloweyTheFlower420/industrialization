package com.floweytf.industrialization.gui;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class GuiManager {
    private static GuiManager INSTANCE = null;
    private Map<Player, Inventory> openUI = new HashMap<>();

    private GuiManager() {}

    public static GuiManager getInstance() {
        if(INSTANCE == null)
            INSTANCE = new GuiManager();

        return INSTANCE;
    }

    public Inventory get(Player p) { return openUI.get(p); }

    public void register(Player p, Inventory i) { openUI.put(p, i); }
}
