package me.untilt.Listeners;

import me.untilt.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by henry27 on 9/1/2017.
 */
public class PlayerLeave implements Listener {

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        if (Main.match.red.isPlayerOnTeam(event.getPlayer())) {
            Main.match.red.removePlayer(event.getPlayer());
        } else if (Main.match.blue.isPlayerOnTeam(event.getPlayer())) {
            Main.match.blue.removePlayer(event.getPlayer());
        }
    }

}
