package me.untilt;

import me.untilt.Handlers.CommandHandler;
import me.untilt.Handlers.SQLManager;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by henry27 on 8/31/2017.
 */
public class Main extends JavaPlugin {

    SQLManager sql;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getCommand("minigame").setExecutor(new CommandHandler());
    }

    @Override
    public void onDisable() {

    }
}
