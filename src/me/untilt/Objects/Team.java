package me.untilt.Objects;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.HashMap;

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

    HashMap<Player, ItemStack[]> playerInventories;
    HashMap<Player,Location> playerPreviousLocation;

    private Kit kit;

    private Location spawn;

    public Team(TEAM teamToSet) {
        this.team = teamToSet;
        this.score = 0;
        this.playerList = new ArrayList<>();
        this.playerInventories = new HashMap<>();
        this.playerPreviousLocation = new HashMap<>();
    }

    public void addPlayer(Player player) {
        playerList.add(player);
        playerInventories.put(player,player.getInventory().getContents());
        for (Player x : playerList) {
            x.sendMessage(ChatColor.GOLD + "Player: " + player.getDisplayName() + ChatColor.GOLD + " has joined the game on your team!");
        }
        player.setGameMode(GameMode.SURVIVAL);
        this.kit = new Kit();
        kit.giveKit(player);
    }

    public void removePlayer(Player player) {
        try {
            playerList.remove(player);
        } catch (NullPointerException e) {

        }
        player.getInventory().clear();
        try {
            player.teleport(this.playerPreviousLocation.get(player));
            this.playerPreviousLocation.remove(player);
        } catch (NullPointerException e) {

        }


        //TODO give the player his inventory back after leaving a team
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

    public void teleportPlayer(Player player,Location previousLocation) {
        double[] coords = Match.map.getSpawn(team);
        this.playerPreviousLocation.put(player,previousLocation);
        Location spawn = new Location(player.getWorld(),coords[0],coords[1],coords[2]);
        player.teleport(spawn);
    }
}
