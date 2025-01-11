package org.infernworld.inferncustomeggs.command;

import lombok.val;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.infernworld.inferncustomeggs.gui.Menu;
import org.jetbrains.annotations.NotNull;

import static org.infernworld.inferncustomeggs.item.Item.items;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        val player = (Player) sender;
        if (command.getName().equalsIgnoreCase("eggs")) {
            if (args.length == 3 && args[0].equalsIgnoreCase("give")) {
                if (player.hasPermission("inferncustomeggs.give")) {
                    ItemStack item = items();
                    int amount;
                    try {
                        amount = Integer.parseInt(args[2]);
                        item.setAmount(amount);
                        player.getInventory().addItem(item);
                    } catch (NumberFormatException e) {
                        player.sendMessage("неверный симвло!");
                    }
                    return true;
                }
            } else {
                Menu.openMenu(player);
                return true;
            }
        }
        return false;
    }
}
