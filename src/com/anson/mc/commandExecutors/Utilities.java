package com.anson.mc.commandExecutors;

import com.anson.mc.main.LangManager;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

class Utilities {
    static boolean fly(Player player) {
        if (player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SPECTATOR) {
            player.sendMessage("You are in " + player.getGameMode().toString().toLowerCase() + " mode !!");
            return false;
        }
        boolean noFly = !player.getAllowFlight();

        player.setAllowFlight(noFly);
        player.setFlying(noFly);
        player.sendMessage(noFly ? LangManager.fly : LangManager.noFly);
        return true;
    }

    static boolean time(Player player, String strings[]) {
        if (strings.length < 2) {
            player.sendMessage(LangManager.pluginPrefix + LangManager.litArg);
            return false;
        }
        String numText = strings[1];
        long num;
        try {
            num = Long.parseLong(numText);
        } catch (NumberFormatException e) {
            player.sendMessage(LangManager.pluginPrefix + "Not a number!");
            return false;
        }

        //player.getWorld().setTime(num);
        player.setPlayerTime(num, true);
        player.setPlayerListHeaderFooter("Fuck", "Bitch");
        player.setPlayerListName("Fucker");

        return false;
    }

}
