package me.untilt.Objects;

import me.untilt.Main;
import org.bukkit.entity.Player;

import java.util.List;

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

    public List<Player> playerList;
    public int score;


    public Team() {
        this.score = 0;
        this.playerList = null;
    }

    public void addPlayer(Player player, TEAM team) {
        playerList.add(player);
    }


    public List<Player> getPlayerList() {
        return this.playerList;
    }

    public Team.TEAM getPlayerTeam(Player player) {
        if (isPlayerOnTeam(player)) {

        }
    }

    public boolean isPlayerOnTeam(Player player) {
        if (playerList.contains(player)) {
            return true;
        } else {
            return false;
        }
    }
}
