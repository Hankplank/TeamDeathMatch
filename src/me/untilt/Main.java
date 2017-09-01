package me.untilt;

import me.untilt.Handlers.CommandHandler;
import me.untilt.Handlers.SQLManager;
import me.untilt.Listeners.PlayerJoin;
import me.untilt.Listeners.PlayerKill;
import me.untilt.Listeners.PlayerLeave;
import me.untilt.Objects.Match;

import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by henry27 on 8/31/2017.
 */
public class Main extends JavaPlugin {

    SQLManager sql;
    public static Match match = null;

    @Override
    public void onEnable() {
        sql = new SQLManager();
        sql.addMap("default",-75,133,246,-31,133,249);
        match = new Match();
        //this.saveDefaultConfig();
        this.getCommand("tdm").setExecutor(new CommandHandler());
        getServer().getPluginManager().registerEvents(new PlayerJoin(),this);
        getServer().getPluginManager().registerEvents(new PlayerKill(),this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(),this);

    }

    @Override
    public void onDisable() {

    }

}
