package com.anson.mc.commandExecutors;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelloCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You are not Player !! Fuck Off !!");
            return false;
        }

        if(!sender.hasPermission("hello.test")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to do that !");
            return false;
        }

        Player player = (Player)sender;
        sender.sendMessage("Hello " + player.getName());

        return true;
    }
}
