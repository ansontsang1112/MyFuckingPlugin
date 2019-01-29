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
        }

        Player player = (Player) commandSender;

        switch (strings[0]) {
            case "fly":
                return Utilities.fly(player);
            case "time":
                return Utilities.time(player, strings);
        }

        return false;
    }
}
