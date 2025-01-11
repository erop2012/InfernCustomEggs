package org.infernworld.inferncustomeggs.listener;

import lombok.val;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.infernworld.inferncustomeggs.InfernCustomEggs;
import org.infernworld.inferncustomeggs.util.Color;

import java.util.Objects;

import static org.infernworld.inferncustomeggs.item.Item.items;
import static org.infernworld.inferncustomeggs.listener.EggsClick.EggClick;

public class Event implements Listener {
    @EventHandler
    public static void onClickEvent(InventoryClickEvent e) {
        String title = Color.hex(Objects.requireNonNull
                (InfernCustomEggs.getMenu().getString("inventory.title")));
        if (e.getView().getTitle().equalsIgnoreCase(title)) {
            e.setCancelled(true);
            val player = (Player) e.getWhoClicked();
            val slot = e.getSlot();
            EggClick(player, slot);
        }
    }
    @EventHandler
    public static void onInteractEvent(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getItem() != null && e.getItem().isSimilar(items())) {
            e.setCancelled(true);
        }
    }
}
