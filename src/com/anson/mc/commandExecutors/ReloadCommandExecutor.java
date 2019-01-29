package com.anson.mc.commandExecutors;

import com.anson.mc.main.ConfigManager;
import com.anson.mc.main.LangManager;
import com.anson.mc.main.TestPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (strings.length == 0) {
            sender.sendMessage(LangManager.pluginPrefix + LangManager.litArg);
            return false;
        }

        if (strings.length > 1) {
            sender.sendMessage(LangManager.pluginPrefix + LangManager.wrongArg);
            return false;
        }

        switch (strings[0]) {
            case "lang":
                LangManager.getInstance(TestPlugin.plugin).reloadLang();
                sender.sendMessage(LangManager.pluginPrefix + ChatColor.GREEN + "lang.yml Reload Successfully");
                break;
            case "config":
                ConfigManager.getInstance(TestPlugin.plugin).reloadConfig();
                sender.sendMessage(LangManager.pluginPrefix + ChatColor.GREEN + "config.yml Reload Successfully");
                break;
            default:
                sender.sendMessage(LangManager.pluginPrefix + LangManager.wrongArg);
                break;
        }
        return true;
    }
}
