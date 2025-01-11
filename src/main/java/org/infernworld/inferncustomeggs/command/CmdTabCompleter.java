package org.infernworld.inferncustomeggs.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CmdTabCompleter implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> completer = new ArrayList<>();
        if (command.getName().equalsIgnoreCase("eggs")) {
            if (sender.hasPermission("inferncustomeggs.give")) {
                if (args.length == 1) {
                    completer.add("give");
                } else if (args.length == 2 && args[0].equalsIgnoreCase("give")) {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        completer.add(p.getName());
                    }
                } else if (args.length == 3 && args[0].equalsIgnoreCase("give")) {
                    for (int i = 1; i <= 64; i++) {
                        completer.add(String.valueOf(i));
                    }
                }
            }
        }
        return completer;
    }
}
