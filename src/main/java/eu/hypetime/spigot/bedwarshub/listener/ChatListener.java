package eu.hypetime.spigot.bedwarshub.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        event.setFormat(event.getPlayer().getDisplayName() + "§8: §7" + event.getMessage());
    }

}
