package org.infernworld.inferncustomeggs.gui;

import lombok.val;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.infernworld.inferncustomeggs.InfernCustomEggs;
import org.infernworld.inferncustomeggs.util.Color;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class Menu implements InventoryHolder {
    private static Inventory inventory =
            Bukkit.createInventory(null, InfernCustomEggs.getMenu().getInt("inventory.size"),
                    Color.hex(Objects.requireNonNull(InfernCustomEggs.getMenu().getString("inventory.title"))));
    public static void openMenu(Player player) {

        val material = InfernCustomEggs.getMenu().getString("inventory.item.eggs-1.material");
        val item = new ItemStack(Material.valueOf(material),InfernCustomEggs.getMenu().getInt("inventory.item.eggs-1.amount"));
        val meta = item.getItemMeta();
        meta.setDisplayName(Color.hex(InfernCustomEggs.getMenu().getString("inventory.item.eggs-1.name")));
        List<String> lore = Color.hexList(InfernCustomEggs.getMenu().getStringList("inventory.item.eggs-1.lore"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        inventory.setItem(InfernCustomEggs.getMenu().getInt("inventory.item.eggs-1.slot"), item);

        val material1 = InfernCustomEggs.getMenu().getString("inventory.item.eggs-2.material");
        val item1 = new ItemStack(Material.valueOf(material1),InfernCustomEggs.getMenu().getInt("inventory.item.eggs-2.amount"));
        val meta1 = item1.getItemMeta();
        meta1.setDisplayName(Color.hex(InfernCustomEggs.getMenu().getString("inventory.item.eggs-2.name")));
        List<String> lore1 = Color.hexList(InfernCustomEggs.getMenu().getStringList("inventory.item.eggs-2.lore"));
        meta1.setLore(lore1);
        item1.setItemMeta(meta1);
        inventory.setItem(InfernCustomEggs.getMenu().getInt("inventory.item.eggs-2.slot"), item1);

        val material2 = InfernCustomEggs.getMenu().getString("inventory.item.eggs-3.material");
        val item2 = new ItemStack(Material.valueOf(material2),InfernCustomEggs.getMenu().getInt("inventory.item.eggs-3.amount"));
        val meta2 = item2.getItemMeta();
        meta2.setDisplayName(Color.hex(InfernCustomEggs.getMenu().getString("inventory.item.eggs-3.name")));
        List<String> lore2 = Color.hexList(InfernCustomEggs.getMenu().getStringList("inventory.item.eggs-3.lore"));
        meta2.setLore(lore2);
        item2.setItemMeta(meta2);
        inventory.setItem(InfernCustomEggs.getMenu().getInt("inventory.item.eggs-3.slot"), item2);

        player.openInventory(inventory);
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }
}
