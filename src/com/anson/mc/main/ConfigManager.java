package com.anson.mc.main;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class ConfigManager {
    public static String flySpeed;
    private static ConfigManager configManager;
    private File configFile;
    private FileConfiguration config;

    private ConfigManager(Plugin plugin) {
        configFile = new File(plugin.getDataFolder(), "config.yml");
        if (!configFile.exists()) plugin.saveResource("config.yml", true);
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public static ConfigManager getInstance(Plugin plugin) {
        if (configManager == null) configManager = new ConfigManager(plugin);
        return configManager;
    }

    void loadConfig() {
        flySpeed = config.getString("utilities.speed.fly");
    }

    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(configFile);
        loadConfig();
    }
}
