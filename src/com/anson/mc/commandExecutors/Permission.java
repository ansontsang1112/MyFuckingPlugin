package com.anson.mc.commandExecutors;

import com.anson.mc.main.LangManager;
import org.bukkit.entity.Player;

class Permission {
    static boolean check(Player player, String string) {
        if (!player.hasPermission(string)) {
            player.sendMessage(LangManager.pluginPrefix + LangManager.noPerm);
            return false;
        }
        return true;
    }

}
