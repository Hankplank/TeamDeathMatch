package me.untilt.Objects;

/**
 * Created by henry27 on 9/1/2017.
 */
public class Map {

    private String mapName;

    private double spawnRedX;
    private double spawnRedY;
    private double spawnRedZ;
    private double spawnBlueX;
    private double spawnBlueY;
    private double spawnBlueZ;


    public Map(Team team1,Team team2, String mapName, double spawnredX, double spawnRedY, double spawnRedZ, double spawnBlueX, double spawnBlueY,double spawnBlueZ) {
        this.mapName = mapName;
        this.spawnBlueX = spawnBlueX;
        this.spawnBlueY = spawnBlueY;
        this.spawnBlueZ = spawnBlueZ;
        this.spawnRedX = spawnredX;
        this.spawnRedY = spawnRedY;
        this.spawnRedZ = spawnRedZ;
    }
}
