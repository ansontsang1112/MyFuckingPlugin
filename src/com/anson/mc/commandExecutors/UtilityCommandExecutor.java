package com.anson.mc.commandExecutors;

import com.anson.mc.main.LangManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UtilityCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(LangManager.noPlayer);
            return false;
        }

        if (strings.length == 0) {
            commandSender.sendMessage(LangManager.pluginPrefix + LangManager.litArg);
            return false;
        }

        Player player = (Player) commandSender;

        switch (strings[0]) {
            case "speed":
                if (strings.length == 0) {
                    player.sendMessage(LangManager.pluginPrefix + LangManager.litArg);
                    return false;
                }
                if (strings[1].equalsIgnoreCase("fly")) {
                    return Utilities.flySpeed(player, strings);
                }
                if (strings[1].equalsIgnoreCase("walk")) {
                    return Utilities.walkSpeed(player, strings);
                }
                player.sendMessage(LangManager.pluginPrefix + LangManager.wrongArg);
                break;
            case "fly":
                if (strings.length == 1) {
                    return Utilities.fly(player);
                }
                player.sendMessage(LangManager.pluginPrefix + LangManager.wrongArg);
                return false;
            case "time":
                return Utilities.time(player, strings);
            case "fuck":
                return Utilities.fuck(player);
        }

        return false;
    }
}
