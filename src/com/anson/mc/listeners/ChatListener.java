package com.anson.mc.listeners;

import com.anson.mc.main.LangManager;
import com.anson.mc.main.TestPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;
import java.util.HashSet;

public class ChatListener implements Listener {
    @EventHandler
    public void noFuck(AsyncPlayerChatEvent e) {
        HashMap<String, String> replace = LangManager.getInstance(TestPlugin.plugin).getReplaces();

        HashSet<String> keyword = new HashSet<>();

        e.getPlayer().getWorld().setTime(1000);

        //e.getPlayer().sendMessage("DEBUG: replace size"+replace.size());

        for (String chat : replace.keySet()) {
            if (e.getMessage().contains(chat)) keyword.add(chat);
        }

        if (keyword.size() == 0) return;

        //e.getPlayer().sendMessage("DEBUG: keyword size "+keyword.size());


        String msg = e.getMessage();

        for (String key : keyword) {
            msg = msg.replace(key, replace.get(key));
        }

        e.setMessage(msg);


    }
}
