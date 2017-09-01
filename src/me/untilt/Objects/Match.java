package me.untilt.Objects;

import org.bukkit.craftbukkit.libs.it.unimi.dsi.fastutil.objects.ObjectCollections;
import org.bukkit.entity.Player;
import sun.invoke.empty.Empty;

import java.util.HashMap;
import java.util.List;

/**
 * Created by henry27 on 8/31/2017.
 */
public class Match {

    public List<Player> gamePlayers = null;

    public HashMap<Integer,Integer> score;
    public static Team red;
    public static Team blue;

    public Match() {
        this.gamePlayers = null;
        this.red = null;
        this.blue = null;
    }

    public void reset() {
        this.red = null;
        this.blue = null;
        this.score = null;
        this.gamePlayers = null;
    }

    public void updateTeams() {
        this.gamePlayers.addAll(this.red.playerList);
        this.gamePlayers.addAll(this.blue.playerList);
    }
}
