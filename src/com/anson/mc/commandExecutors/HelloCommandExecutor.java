package com.anson.mc.commandExecutors;

import com.anson.mc.main.LangManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelloCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(LangManager.noPlayer);
            return false;
        }

        if(!sender.hasPermission("hello.test")) {
            sender.sendMessage(LangManager.noPerm);
            return false;
        }

        Player player = (Player)sender;
        sender.sendMessage("Hello " + player.getName());

        return true;
    }
}
