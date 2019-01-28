package com.anson.mc.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    @EventHandler
    public void noFuck(AsyncPlayerChatEvent e) {
        if(e.getMessage().contains("fuck")) {
            e.setCancelled(true);
            e.getPlayer().sendMessage("No Fuck, Bitch!");
        }

        e.setMessage(e.getMessage().replace("shit", "love"));
    }
}
