package me.untilt.Objects;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by henry27 on 8/31/2017.
 */
public class Team {

    public enum TEAM {
        RED,
        BLUE,
        NO_TEAM;
        public String toString() {
            switch (this) {
                case RED:
                    return "RED";
                case BLUE:
                    return "BLUE";
                case NO_TEAM:
                    return "NO_TEAM";
                default:
                    return "null";
            }
        }
    }



    public ArrayList<Player> playerList;
    public int score;
    public TEAM team;

    private Location spawn;

    public Team(TEAM teamToSet) {
        this.team = teamToSet;
        this.score = 0;
        this.playerList = new ArrayList<>();

    }

    public void addPlayer(Player player) {
        playerList.add(player);
        for (Player x : playerList) {
            x.sendMessage(ChatColor.GOLD + "Player: " + player.getDisplayName() + ChatColor.GOLD + " has joined the game on your team!");
        }
        player.teleport(getSpawn());
    }

    public void removePlayer(Player player) {
        playerList.remove(player);
    }


    public ArrayList<Player> getPlayersOnTeam() {
        return this.playerList;
    }

    public Team.TEAM getPlayerTeam(Player player) {
        if (isPlayerOnTeam(player)) {
            return this.team;
        } else {
            return TEAM.NO_TEAM;
        }
    }

    public void addKills(int killsToAdd) {
        this.score += killsToAdd;
    }

    public String showTeam() {
        ArrayList<String> teamPlayers = new ArrayList<>();
        for (Player x : playerList) {
            teamPlayers.add(x.getDisplayName());
        }
        return teamPlayers.toString();
    }

    public boolean isPlayerOnTeam(Player player) {
        if (playerList.contains(player)) {
            return true;
        } else {
            return false;
        }
    }

    public void setSpawn(Location loc) {
        this.spawn = loc;
    }

    public Location getSpawn() {
        return this.spawn;
    }
}
