package eu.hypetime.spigot.bedwarshub.listener;

import eu.hypetime.spigot.bedwarshub.utils.ScoreAPI;
import eu.hypetime.spigot.bedwarshub.utils.WarpAPI;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setFoodLevel(20);
        event.setJoinMessage(null);
        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 2F, 1F); //activate when halloween is over
        WarpAPI.tpWarp(player, "Spawn");

        for (Player all : Bukkit.getOnlinePlayers())
            ScoreAPI.setScoreboard(all);
    }
}
