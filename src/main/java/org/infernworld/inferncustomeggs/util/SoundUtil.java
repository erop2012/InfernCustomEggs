package org.infernworld.inferncustomeggs.util;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.infernworld.inferncustomeggs.InfernCustomEggs;

public class SoundUtil {
    public static void sound(Player player, String key) {
        String name = InfernCustomEggs.getPlugin().getConfig().getString(key);
        if (name != null) {
            Sound sound = Sound.valueOf(name);
            player.playSound(player.getLocation(), sound, 1f, 1f);
        }
    }
}
