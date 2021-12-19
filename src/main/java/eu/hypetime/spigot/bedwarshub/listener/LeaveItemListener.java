package eu.hypetime.spigot.bedwarshub.listener;

import eu.hypetime.spigot.bedwarshub.utils.Inventories;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class LeaveItemListener implements Listener {

    public void onInteract(PlayerInteractEvent event) {
        if(event.getItem() == null) return;
        if(event.getItem().getType() == Material.AIR) return;
        if(event.getItem().getType() == Material.PLAYER_HEAD) {
            if(!event.getItem().hasItemMeta()) return;
            if(!event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cVerlassen")) {
                Inventories.mainInventory(event.getPlayer());
            }
        }
    }
}
