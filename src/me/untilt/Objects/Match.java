package me.untilt.Objects;

import me.untilt.Handlers.SQLManager;
import org.bukkit.Location;
import org.bukkit.craftbukkit.Main;
import org.bukkit.craftbukkit.libs.it.unimi.dsi.fastutil.objects.ObjectCollections;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by henry27 on 8/31/2017.
 */
public class Match {

    public ArrayList<Player> gamePlayers;

    public HashMap<Integer,Integer> score;
    public static Team red;
    public static Team blue;
    public Map map;

    public boolean isMatchPlaying;

    public Match() {
        this.isMatchPlaying = true;
        this.gamePlayers = new ArrayList<>();
        //updateTeams();
        this.red = new Team(Team.TEAM.RED);
        this.blue = new Team(Team.TEAM.BLUE);
        this.score = new HashMap<>();
        SQLManager sql = new SQLManager();
        this.map =  sql.getMap("default",this.red,this.blue);
    }

    public void reset() {
        this.red = new Team(Team.TEAM.RED);
        this.blue = new Team(Team.TEAM.BLUE);
        this.score = null;
        this.gamePlayers= new ArrayList<>();
        this.isMatchPlaying = false;
        this.score = new HashMap<>();

    }

    public void updateScore() {
      score.put(0,red.score);
      score.put(1,blue.score);
      if (score.get(0) >= 25) {
          reset();
      } else if (score.get(1)>= 25) {
          reset();
      }
    }
    public void updateTeams() {
        this.gamePlayers.addAll(this.red.playerList);
        this.gamePlayers.addAll(this.blue.playerList);
    }
}
