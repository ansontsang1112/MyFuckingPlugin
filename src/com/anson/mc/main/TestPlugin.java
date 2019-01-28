package com.anson.mc.main;

import com.anson.mc.commandExecutors.HelloCommandExecutor;
import com.anson.mc.listeners.ChatListener;
import com.anson.mc.listeners.JoinListener;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin {
    public static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        ConsoleCommandSender sender = this.getServer().getConsoleSender();
        sender.sendMessage(ChatColor.GREEN + "Plugin Successfully loaded !");
        this.getLogger().info("Test Plugin Successfully Enable !");
        this.getCommand("hello").setExecutor(new HelloCommandExecutor());
        this.getServer().getPluginManager().registerEvents(new JoinListener(), this);
        this.getServer().getPluginManager().registerEvents(new ChatListener(), this);
    }

    @Override
    public void onDisable() {

    }
}
