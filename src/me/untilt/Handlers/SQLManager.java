package me.untilt.Handlers;

import me.untilt.Objects.Classes;
import me.untilt.Objects.Map;
import me.untilt.Objects.Team;
import org.bukkit.Location;

import java.sql.*;
import java.util.UUID;

/**
 * Created by henry27 on 8/31/2017.
 */
public class SQLManager {

    private Connection connect = null;

    public SQLManager() {
        this.connect();

    }

    private void connect() {
        try {
            String url = "jdbc:SQLite:minigame.db";
            connect = DriverManager.getConnection(url);
            String createUsers = "CREATE TABLE IF NOT EXISTS users (userUUID text unique, playername text, level integer, kills integer, deaths integer);";
            String createMaps = "CREATE TABLE IF NOT EXISTS maps (mapname text unique, spawnredx real, spawnredy real, spawnredz real, spawnbluex real, spawnbluey real, spawnbluez real);";
            Statement createMapTable = connect.createStatement();
            Statement createIfDoesntExist = connect.createStatement();
            createIfDoesntExist.executeUpdate(createUsers);
            createMapTable.executeUpdate(createMaps);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMap(String mapName,  double spawnRedX, double spawnRedY, double spawnRedZ, double spawnBluex, double spawnBlueY, double spawnBlueZ ) {
        try {
            String addMap = "INSERT INTO MAPS VALUES ( \"" + mapName + "\" , " + spawnRedX + " , " + spawnRedY + " , " + spawnRedZ + " , " + spawnBluex + " , " + spawnBlueY + " , " + spawnBlueZ + " );";
            System.out.println(addMap);
            Statement add = connect.createStatement();
            add.executeUpdate(addMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map getMap(String mapname, Team team1, Team team2) {
        try {
            String getKills = "SELECT * FROM MAPS WHERE mapname=\"" + mapname + "\";";
            System.out.println(getKills);
            Statement getKillsStatement = connect.createStatement();
            ResultSet rs  = getKillsStatement.executeQuery(getKills);
            double redspawnx = rs.getDouble("redspawnx");
            double redspawny = rs.getDouble("redspawny");
            double redspawnz = rs.getDouble("redspawnz");
            double bluespawnx = rs.getDouble("bluespawnx");
            double bluespawny = rs.getDouble("bluespawny");
            double bluespawnz = rs.getDouble("bluespawnz");
            Map map = new Map(team1,team2,mapname,redspawnx,redspawny,redspawnz,bluespawnx,bluespawny,bluespawnz);
            return map;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setRedSpawn(Location location) {
        double redSpawnX = location.getX();
        double redSpawnY = location.getY();
        double redSpawnZ = location.getZ();
        try {
            String setSpawnX = "UPDATE MAPS SET redspawnx=" + redSpawnX + " WHERE mapname=\"default\";";
            String setSpawnY = "UPDATE MAPS SET redspawny=" + redSpawnY + " WHERE mapname=\"default\";";
            String setSpawnZ = "UPDATE MAPS SET redspawnz=" + redSpawnZ + " WHERE mapname=\"default\";";
            Statement setSpawnXStatement = connect.createStatement();
            Statement setSpawnYStatement = connect.createStatement();
            Statement setSpawnZStatement = connect.createStatement();
            setSpawnXStatement.executeUpdate(setSpawnX);
            setSpawnYStatement.executeUpdate(setSpawnY);
            setSpawnZStatement.executeUpdate(setSpawnZ);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void setBlueSpawn(Location location) {
        double blueSpawnX = location.getX();
        double blueSpawnY = location.getY();
        double blueSpawnZ = location.getZ();
        try {
            String setSpawnX = "UPDATE MAPS SET bluespawnx=" + blueSpawnX + " WHERE mapname=\"default\";";
            String setSpawnY = "UPDATE MAPS SET bluespawny=" + blueSpawnY + " WHERE mapname=\"default\";";
            String setSpawnZ = "UPDATE MAPS SET bluespawnz=" + blueSpawnZ + " WHERE mapname=\"default\";";
            Statement setSpawnXStatement = connect.createStatement();
            Statement setSpawnYStatement = connect.createStatement();
            Statement setSpawnZStatement = connect.createStatement();
            setSpawnXStatement.executeUpdate(setSpawnX);
            setSpawnYStatement.executeUpdate(setSpawnY);
            setSpawnZStatement.executeUpdate(setSpawnZ);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double[] getRedSpawn(String mapName) {
        try {
            String getSpawnX = "SELECT * FROM MAPS WHERE mapname=\""+ mapName + "\";";
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery(getSpawnX);
            double[] spawn = {};
            spawn[0] = rs.getDouble("redspawnx");
            spawn[1] = rs.getDouble("redspawny");
            spawn[2] = rs.getDouble("redspawnz");
            return spawn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public double[] getBlueSpawn(String mapName) {
        try {
            String getSpawnX = "SELECT * FROM MAPS WHERE mapname=\""+ mapName + "\";";
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery(getSpawnX);
            double[] spawn = {};
            spawn[0] = rs.getDouble("bluespawnx");
            spawn[1] = rs.getDouble("bluespawny");
            spawn[2] = rs.getDouble("bluespawnz");
            return spawn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void addUser(UUID user, String playername) {
        try {
            String addUser = "INSERT INTO USERS VALUES ( \"" + user + "\" , \"" + playername + "\" , 1 , 0 , 0);";
            System.out.println(addUser);
            Statement add = connect.createStatement();
            add.executeUpdate(addUser);
        } catch (SQLException e) {

        }
    }

    public void changeClass(UUID user, String classToChangeTo) {
        try {
            String changeClass = "UPDATE USERS SET chosenClass=\"" + classToChangeTo +"\" WHERE userUUID=\"" + user + "\";";
            System.out.println(changeClass);
            Statement changeClassStatement = connect.createStatement();
            changeClassStatement.executeUpdate(changeClass);
        } catch (SQLException e) {

        }

    }


    public int getKills(UUID user) {
        try {
            String getKills = "SELECT * FROM USERS WHERE userUUID=\"" + user + "\";";
            System.out.println(getKills);
            Statement getKillsStatement = connect.createStatement();
            ResultSet rs  = getKillsStatement.executeQuery(getKills);
            return rs.getInt("kills");
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getDeaths(UUID user) {
        try {
            String getDeaths = "SELECT * FROM USERS WHERE userUUID=\"" + user + "\";";
            System.out.println(getDeaths);
            Statement getKillsStatement = connect.createStatement();
            ResultSet rs  = getKillsStatement.executeQuery(getDeaths);
            return rs.getInt("deaths");
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void addKills(UUID user, int killsToAdd) {
        try {
            int getKills;
            if (getKills(user) == -1) {
                System.out.println("COULDN'T ADD KILLS");
                return;
            } else {
                getKills = getKills(user);
            }
            int newKills = getKills + killsToAdd;
            String addKills = "UPDATE USERS SET kills=" + newKills + ";";
            Statement addKillsStatement = connect.createStatement();
            addKillsStatement.executeUpdate(addKills);
        } catch (SQLException e) {

        }
    }
    public void addDeaths(UUID user, int deathsToAdd) {
        try {
            int getDeaths;
            if (getDeaths(user) == -1) {
                System.out.println("COULDN'T ADD DEATHS");
                return;
            } else {
                getDeaths = getKills(user);
            }
            int newDeaths = getDeaths + deathsToAdd;
            String addDeaths = "UPDATE USERS SET deaths=" + newDeaths + " WHERE userUUID=\"" + user + "\";";
            Statement addDeathsStatement = connect.createStatement();
            addDeathsStatement.executeUpdate(addDeaths);
        } catch (SQLException e) {

        }
    }
}
