package org.infernworld.inferncustomeggs.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.infernworld.inferncustomeggs.InfernCustomEggs;

import java.util.List;
import java.util.Random;

public class RandomEggs {
    public static ItemStack RandomEggs(String category) {
        List<String> eggs = InfernCustomEggs.getPlugin().getConfig().getStringList("spawn-eggs." + category);
        Random random = new Random();
        String randomEggName = eggs.get(random.nextInt(eggs.size()));
        return new ItemStack(Material.valueOf(randomEggName));
    }
}
