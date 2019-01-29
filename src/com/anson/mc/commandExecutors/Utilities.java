package com.anson.mc.commandExecutors;

import com.anson.mc.main.LangManager;
import com.anson.mc.main.TestPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class Utilities {
    private static int times = 0;

    static boolean walkSpeed(Player player, String strings[]) {
        String permission = "test.utility.walk.speed";
        if (Permission.check(player, permission) == false) return false;
        if (strings.length == 2) {
            player.sendMessage(LangManager.pluginPrefix + LangManager.litArg);
            return false;
        }
        String numText = strings[2];
        float num;
        try {
            num = Float.parseFloat(numText);
            if (num < -1 || num > 1) {
                player.sendMessage(LangManager.pluginPrefix + "The range of Walk Speed in -1 - 1 !");
                return false;
            }
        } catch (NumberFormatException x) {
            player.sendMessage(LangManager.pluginPrefix + "Not a fucking number!");
            return false;
        }

        //player.sendMessage("Debugger : " + num);
        player.setWalkSpeed(num);
        return true;
    }

    static boolean flySpeed(Player player, String strings[]) {
        String permission = "test.utility.fly.speed";

        if (Permission.check(player, permission) == false) return false;

        if (!player.getAllowFlight()) {
            player.sendMessage(LangManager.pluginPrefix + ChatColor.ITALIC + "You are not flying Now");
            return false;
        }
        if (strings.length == 2) {
            player.sendMessage(LangManager.pluginPrefix + LangManager.litArg);
            return false;
        }

        String numText = strings[2];
        float num;
        try {
            num = Float.parseFloat(numText);
            if (num < -1 || num > 1) {
                player.sendMessage(LangManager.pluginPrefix + "The range of Fly Speed in -1 - 1 !");
                return false;
            }
        } catch (NumberFormatException e) {
            player.sendMessage(LangManager.pluginPrefix + "Not a fucking number!");
            return false;
        }

        //player.sendMessage("Debugger : " + num);
        player.setFlySpeed(num);
        return true;
    }

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
            player.sendMessage(LangManager.pluginPrefix + "Not a fucking number!");
            return false;
        }

        player.sendMessage(LangManager.pluginPrefix + ChatColor.GREEN + "Set Time will launch after 5 secs...");
        int task = Bukkit.getScheduler().scheduleSyncDelayedTask(TestPlugin.plugin, () -> {
            player.getWorld().setTime(num);
            player.sendMessage(LangManager.pluginPrefix + ChatColor.GREEN + "You have set the time to " + num);
        }, 100L);
        player.sendMessage("Schduler is " + (Bukkit.getScheduler().isQueued(task) ? "Queueing" : "Not Queueing"));
        return false;
    }

    static boolean fuck(Player player) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (times < 20) {
                    player.sendMessage("Fuck you " + times + " times.");
                    times++;
                } else {
                    times = 0;
                    player.sendMessage("Fuck you is enough. stopping");
                    cancel();
                }
            }
        }.runTaskTimer(TestPlugin.plugin, 0L, 100L);
        return true;
    }
}
