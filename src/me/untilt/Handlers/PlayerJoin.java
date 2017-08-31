package me.untilt.Handlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by henry27 on 8/31/2017.
 */
public class PlayerJoin implements Listener {

    public PlayerJoin() {

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        SQLManager sql = new SQLManager();
        sql.addUser(event.getPlayer().getUniqueId(),event.getPlayer().getDisplayName());

    }

}
