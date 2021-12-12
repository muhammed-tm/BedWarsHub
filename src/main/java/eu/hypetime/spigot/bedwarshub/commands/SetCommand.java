package eu.hypetime.spigot.bedwarshub.commands;

import eu.hypetime.spigot.bedwarshub.BedWarsHub;
import eu.hypetime.spigot.bedwarshub.utils.WarpAPI;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class SetCommand implements CommandExecutor {

    String prefix = BedWarsHub.getInstance().getPrefix();

    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(prefix + "Dies kann nur ein Spieler§8.");
            return false;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("system.set")) {
            player.sendMessage(prefix + "§cNicht §7genug Rechte§8.");
            return false;
        }
        if (args.length != 1) {
            player.sendMessage(prefix + "§cFalsche §7Benutzung§8. §7Nutze §6/set §8<§6Location§8>");
            return false;
        }
        if (!args[0].equalsIgnoreCase("Spawn")) {
            player.sendMessage(prefix + "Bitte gebe eine gültige Location an§8. §6Locations§8:");
            player.sendMessage("§6Spawn");
            return false;
        }
        WarpAPI.setLocation(player, args[0]);

        return false;
    }
}
