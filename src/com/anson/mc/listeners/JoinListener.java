package com.anson.mc.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.setJoinMessage(ChatColor.AQUA + e.getPlayer().getName() + " joined the fucking game.");
        e.getPlayer().setPlayerListHeaderFooter("Fuck You " + e.getPlayer().getName(), "Mother Bitch");
        e.getPlayer().setPlayerListName("Bool shit Sam fucker // " + e.getPlayer().getName());
    }
}


