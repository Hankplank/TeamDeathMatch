package me.untilt.Listeners;

import me.untilt.Objects.Match;
import me.untilt.Objects.Team;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Created by henry27 on 9/1/2017.
 */
public class PlayerKill implements Listener {

    public PlayerKill() {

    }

    private void checkPlayersOnDifferentTeams(Player killed, Player killer) {
        Team.TEAM killedTeam;
        if ()

    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (event.getEntity() instanceof Player) {
            Player killed = event.getEntity().getPlayer();
            Player killer = event.getEntity().getKiller();
            if (!(killer.getPlayer().getUniqueId()==killed.getPlayer().getUniqueId()) && ( Match.blue.isPlayerOnTeam(killed) || Match.red.isPlayerOnTeam(killed))) {
                checkPlayersOnDifferentTeams(killed,killer);
            } else {

            }
        }



    }



}
