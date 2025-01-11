package org.infernworld.inferncustomeggs.item;

import lombok.val;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.infernworld.inferncustomeggs.InfernCustomEggs;
import org.infernworld.inferncustomeggs.util.Color;
import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

public class Item {
    public static ItemStack items() {
        String material = InfernCustomEggs.getPlugin().getConfig().getString("item.material");
        ItemStack item = new ItemStack(Material.valueOf(material));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Color.hex(InfernCustomEggs.getPlugin().getConfig().getString("item.name")));
        List<String> lore = Color.hexList(InfernCustomEggs.getPlugin().getConfig().getStringList("item.lore"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}