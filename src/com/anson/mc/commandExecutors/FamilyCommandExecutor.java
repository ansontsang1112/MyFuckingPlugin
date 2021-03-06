package com.anson.mc.commandExecutors;

import com.anson.mc.main.LangManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FamilyCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        String str;

        if (!(sender instanceof Player)) {
            sender.sendMessage(LangManager.noPlayer);
            return false;
        }

        if (!sender.hasPermission("family.test")) {
            sender.sendMessage(LangManager.noPerm);
            return false;
        }

        if (strings.length == 0) {
            sender.sendMessage(LangManager.pluginPrefix + LangManager.litArg);
            return false;
        }

        if (strings.length > 1) {
            sender.sendMessage(LangManager.pluginPrefix + LangManager.manyArg);
            return false;
        }

        switch (strings[0]) {
            case "mother":
                str = "Mother";
                break;
            case "father":
                str = "Father";
                break;
            default:
                sender.sendMessage(LangManager.pluginPrefix + LangManager.wrongArg);
                return false;
        }

        sender.sendMessage(str + " said, \"" + LangManager.fuckMsg + (sender).getName() + "\"");

        return true;
    }
}