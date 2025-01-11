package org.infernworld.inferncustomeggs.listener;

import lombok.val;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.infernworld.inferncustomeggs.InfernCustomEggs;
import org.infernworld.inferncustomeggs.util.Color;

import static org.infernworld.inferncustomeggs.item.Item.items;
import static org.infernworld.inferncustomeggs.util.RandomEggs.RandomEggs;
import static org.infernworld.inferncustomeggs.util.SoundUtil.sound;

public class EggsClick {
    public static void EggClick(Player player, int slot) {
        String category = "";
        int price;
        val slot1 = InfernCustomEggs.getMenu().getInt("inventory.item.eggs-1.slot");
        val slot2 = InfernCustomEggs.getMenu().getInt("inventory.item.eggs-2.slot");
        val slot3 = InfernCustomEggs.getMenu().getInt("inventory.item.eggs-3.slot");
        if (slot == slot1) {
            category = "default";
            price = InfernCustomEggs.getMenu().getInt("inventory.item.eggs-1.price");
        } else if (slot == slot2) {
            category = "Lite";
            price = InfernCustomEggs.getMenu().getInt("inventory.item.eggs-2.price");
        } else if (slot == slot3) {
            category = "Epic";
            price = InfernCustomEggs.getMenu().getInt("inventory.item.eggs-3.price");
        } else {
            return;
        }
        int eggsAmount = getEggs(player);
        if (eggsAmount >= price) {
            EggsAmount(player, price);
            ItemStack egg = RandomEggs(category);
            player.getInventory().addItem(egg);
            player.sendMessage(Color.hex(InfernCustomEggs.getPlugin().getConfig().getString("message.give-eggs")));
            sound(player, "settings.sound-complete");
        } else {
            player.sendMessage(Color.hex(InfernCustomEggs.getPlugin().getConfig().getString("message.not-eggs")));
            sound(player, "settings.sound-not-eggs");
        }
    }
    public static int getEggs(Player player) {
        int totalAmount = 0;
        for (ItemStack stack : player.getInventory().getStorageContents()) {
            if (stack != null && stack.isSimilar(items())) {
                totalAmount += stack.getAmount();
            }
        }
        return totalAmount;
    }
    public static void EggsAmount(Player player, int price) {
        for (ItemStack item : player.getInventory().getStorageContents()) {
            if (item != null && item.isSimilar(items())) {
                int countAmount = item.getAmount();
                if (countAmount >= price) {
                    item.setAmount(countAmount - price);
                    break;
                } else {
                    price -= countAmount;
                    player.getInventory().setItem(player.getInventory().first(item), null);
                }
                if (price <= 0) {
                    break;
                }
            }
        }
    }
}
