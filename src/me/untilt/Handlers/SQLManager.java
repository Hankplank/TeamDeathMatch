package me.untilt.Handlers;

import me.untilt.Objects.Classes;

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
            String createTable = "CREATE TABLE IF NOT EXISTS users (userUUID text unique, playername text, level integer, kills integer, deaths integer);";
            Statement createIfDoesntExist = connect.createStatement();
            createIfDoesntExist.executeUpdate(createTable);

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
}
