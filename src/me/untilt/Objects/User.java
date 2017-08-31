package me.untilt.Objects;

import org.bukkit.WeatherType;
import org.bukkit.entity.Player;

/**
 * Created by henry27 on 8/31/2017.
 */
public class User  {

    public enum Stats {
        KILLS,
        DEATHS;
    }

    private Team team;

    public User(Player player) {
        this.team = null;
    }
}
