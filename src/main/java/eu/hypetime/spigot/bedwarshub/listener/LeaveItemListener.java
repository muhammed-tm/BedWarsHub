package eu.hypetime.spigot.bedwarshub.listener;

import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.ext.bridge.player.IPlayerManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class LeaveItemListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getItem() == null) return;
        if (event.getItem().getType() == Material.AIR) return;
        if (event.getItem().getType() == Material.PLAYER_HEAD) {
            if (!event.getItem().hasItemMeta()) return;
            if (event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cVerlassen")) {
                sendPlayer(event.getPlayer(), "Lobby-1");
            }
        }
    }

    public void sendPlayer(Player player, String server) {
        CloudNetDriver.getInstance().getServicesRegistry().getFirstService(IPlayerManager.class)
                .getPlayerExecutor(player.getUniqueId())
                .connect(server);
    }

}
