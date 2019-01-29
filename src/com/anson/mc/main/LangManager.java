package com.anson.mc.main;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.HashMap;

public class LangManager {
    public static String joinMsg, noPlayer, noPerm, litArg, manyArg, wrongArg, fuckMsg, pluginPrefix, noFly, fly;
    private static LangManager langManager;
    private File langFile;
    private File replaceFile;
    private FileConfiguration gameLang;
    private FileConfiguration replace;
    private HashMap<String, String> replaces = new HashMap<>();

    private LangManager(Plugin plugin) {
        langFile = new File(plugin.getDataFolder(), "lang.yml");
        if (!langFile.exists()) plugin.saveResource("lang.yml", true);
        gameLang = YamlConfiguration.loadConfiguration(langFile);

        replaceFile = new File(plugin.getDataFolder(), "replace.yml");
        if (!replaceFile.exists()) plugin.saveResource("replace.yml", true);
        replace = YamlConfiguration.loadConfiguration(replaceFile);
    }

    public static LangManager getInstance(Plugin plugin) {
        if (langManager == null) langManager = new LangManager(plugin);
        return langManager;
    }

    private String translateString(String path) {
        return ChatColor.translateAlternateColorCodes('&', gameLang.getString(path));
    }

    void loadLang() {
        //lang.yml
        fly = translateString("utility.fly-msg");
        noFly = translateString("utility.nofly-msg");
        pluginPrefix = translateString("prefix");
        joinMsg = translateString("join-msg");
        noPlayer = translateString("no-player");
        noPerm = translateString("no-perm");
        litArg = translateString("little-arg");
        manyArg = translateString("many-arg");
        wrongArg = translateString("wrong-arg");
        fuckMsg = translateString("fuck-msg");

        //replace.yml
        for (String key : replace.getKeys(false)) {
            replaces.put(key, replace.getString(key));
        }

    }

    public void reloadLang() {
        gameLang = YamlConfiguration.loadConfiguration(langFile);
        loadLang();
    }

    public HashMap<String, String> getReplaces() {
        return replaces;
    }
}
