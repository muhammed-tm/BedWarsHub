package eu.hypetime.spigot.bedwarshub;

import eu.hypetime.spigot.bedwarshub.commands.SetCommand;
import eu.hypetime.spigot.bedwarshub.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BedWarsHub extends JavaPlugin {
    private String Prefix = "§6BWHub §8| §7";
    private static BedWarsHub instance;

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage(Prefix + "wurde aktiviert");
        registerListener();
        registerCommands();
    }
    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Prefix + "wurde deaktiviert");
    }
    private void registerListener() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new BuildListener(), this);
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new ChatListener(), this);
        pluginManager.registerEvents(new QuitListener(), this);
        pluginManager.registerEvents(new LeaveItemListener(), this);

    }

    private void registerCommands() {
        getCommand("set").setExecutor(new SetCommand());
    }
    public static BedWarsHub getInstance() {
        return instance;
    }

    public String getPrefix() {
        return Prefix;
    }
}
