package org.infernworld.inferncustomeggs;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.infernworld.inferncustomeggs.command.CmdTabCompleter;
import org.infernworld.inferncustomeggs.command.Commands;
import org.infernworld.inferncustomeggs.listener.Event;

import java.io.File;
import java.io.IOException;

public final class InfernCustomEggs extends JavaPlugin {

    @Getter
    public static InfernCustomEggs plugin;
    public static File Menu;
    @Getter
    public static FileConfiguration menu;
    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        Menu = new File(getDataFolder(), "menu.yml");
        if (!Menu.exists()) {
            saveResource("menu.yml", false);
        }
        menu = YamlConfiguration.loadConfiguration(Menu);
        Bukkit.getPluginCommand("eggs").setExecutor(new Commands());
        Bukkit.getPluginCommand("eggs").setTabCompleter(new CmdTabCompleter());
        Bukkit.getPluginManager().registerEvents(new Event(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
