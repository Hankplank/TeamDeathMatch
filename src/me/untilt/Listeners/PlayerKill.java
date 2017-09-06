package me.untilt.Listeners;

import me.untilt.Handlers.SQLManager;
import me.untilt.Main;
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
        Team.TEAM killerTeam;

        if (Match.red.isPlayerOnTeam(killed)) {
            killedTeam = Team.TEAM.RED;
        } else if (Match.blue.isPlayerOnTeam(killed)) {
            killedTeam = Team.TEAM.BLUE;
        } else {
            killedTeam = Team.TEAM.NO_TEAM;
            return;
        }
        if (Match.red.isPlayerOnTeam(killer)) {
            killerTeam = Team.TEAM.RED;
        } else if (Match.blue.isPlayerOnTeam(killer)) {
            killerTeam = Team.TEAM.BLUE;
        } else {
            killerTeam = Team.TEAM.NO_TEAM;
            return;
        }
        SQLManager sql = new SQLManager();
        if (killedTeam.equals(Team.TEAM.BLUE) && killerTeam.equals(Team.TEAM.RED)) {
            Match.red.addKills(1);
            Main.match.updateScore();
            sql.addKills(killer.getUniqueId(),1);
            sql.addDeaths(killed.getUniqueId(),1);
        } else if (killedTeam.equals(Team.TEAM.RED) && killerTeam.equals(Team.TEAM.BLUE)) {
            Match.blue.addKills(1);
            Main.match.updateScore();
            sql.addKills(killer.getUniqueId(),1);
            sql.addDeaths(killed.getUniqueId(),1);
        } else {
            return;
        }

    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (event.getEntity() instanceof Player && !(event.getEntity().getKiller()==null)) {
            Player killed = event.getEntity().getPlayer();
            Player killer = event.getEntity().getKiller();
            if (!(killer.getPlayer().getUniqueId()==killed.getPlayer().getUniqueId()) && ( Match.blue.isPlayerOnTeam(killed) || Match.red.isPlayerOnTeam(killed))) {
                checkPlayersOnDifferentTeams(killed,killer);
                killed.sendMessage("You died to: " + killer.getDisplayName());
                killer.sendMessage("Nice kill on " + killed.getDisplayName() + "!");
            } else {

            }
        }

    }
}
