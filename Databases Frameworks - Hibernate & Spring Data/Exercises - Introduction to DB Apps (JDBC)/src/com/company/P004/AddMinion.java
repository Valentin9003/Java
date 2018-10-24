package com.company.P004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class AddMinion {

    private static final String URL = "jdbc:mysql://localhost:3306/minionsdb?useSSL=false";
    private static final String USER = "root";
    private static final String DEFAULT_EVILNESS_FACTOR = "evil";

    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Password: ");
        String pass = reader.readLine();
        try(Connection conn = DriverManager.getConnection(URL, USER, pass)) {
            System.out.println("Connection successfully!...");
            readAndAddInfoToTheDatabase(conn, reader);
        }
    }

    private static void readAndAddInfoToTheDatabase(Connection conn, BufferedReader reader) throws IOException, SQLException {
        String[] minionInfo = reader.readLine().split("\\s+");
        String[] villainInfo = reader.readLine().split("\\s+");
        String minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String town = minionInfo[3];
        String villainName = villainInfo[1];

        int townID = checkTownIdInDb(conn, town);
        addMinionToDbIfNotExist(conn, minionName, minionAge, townID);
        addToBeMinionToVillain(conn, villainName, minionName);
    }

    private static void addMinionToDbIfNotExist(Connection conn, String minionName, int minionAge, int townID) throws SQLException {
        String sqlQuery = "SELECT * FROM `minions` WHERE `name` = '" + minionName + "';";
        try(Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            if (!rs.first()) {
                addMinionToDb(conn, minionName, minionAge, townID);
            }
        }
    }

    private static void addToBeMinionToVillain(Connection conn, String villainName, String minionName) throws SQLException {
        try(Statement statement = conn.createStatement()) {
            String sqlQuery = "SELECT * FROM `villains` WHERE `name` = '" + villainName + "';";
            ResultSet rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            if (rs.first()) {
                int villainID = rs.getInt("id");
                int minionID = getMinionID(conn, minionName);
                addMinionToVillain(conn, villainID, minionID, villainName, minionName);
            } else {
                addVillainToDatabase(conn, villainName);
                addToBeMinionToVillain(conn, villainName, minionName);
            }
        }
    }

    private static void addMinionToVillain(Connection conn, int villainID, int minionID, String villainName, String minionName) throws SQLException {
        String sqlQuery =
                "INSERT INTO `minions_villains`(minion_id, villain_id)\n" +
                "VALUES (?, ?);";
        try(PreparedStatement statement = conn.prepareStatement(sqlQuery)) {
            statement.setInt(1, minionID);
            statement.setInt(2, villainID);
            statement.executeUpdate();
            System.out.println(String.format("Successfully added %s to be minion of %s", minionName, villainName));
        }
    }

    private static int getMinionID(Connection conn, String minionName) throws SQLException {
        String sqlQuery = "SELECT id FROM `minions` WHERE `name` = '" + minionName + "';";
        try(Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlQuery);
            rs.first();
            return rs.getInt("id");
        }
    }

    private static void addVillainToDatabase(Connection conn, String villainName) throws SQLException {
        String sqlQuery =
                "INSERT INTO `villains`(`name`, `evilness_factor`)\n" +
                "VALUES (?, ?);";
        try(PreparedStatement statement = conn.prepareStatement(sqlQuery)) {
            statement.setString(1, villainName);
            statement.setString(2, DEFAULT_EVILNESS_FACTOR);
            statement.executeUpdate();
            System.out.println(String.format("Villain %s was added to the database.", villainName));
        }
    }

    private static void addMinionToDb(Connection conn, String minionName, int minionAge, int townID) throws SQLException {
        String sqlQuery =
                "INSERT INTO `minions`(`name`, `age`, `town_id`)\n" +
                "VALUES (?, ?, ?);";
        try(PreparedStatement statement = conn.prepareStatement(sqlQuery)) {
            statement.setString(1, minionName);
            statement.setInt(2, minionAge);
            statement.setInt(3, townID);
            statement.executeUpdate();
        }
    }

    private static int checkTownIdInDb(Connection conn, String town) throws SQLException {
        try(Statement statement = conn.createStatement()) {
            String sqlQuery = "SELECT id FROM towns WHERE town_name = '" + town + "'";
            ResultSet rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            if (rs.first()) {
                return rs.getInt("id");
            } else {
                addTownToDb(conn, town);
                return checkTownIdInDb(conn, town);
            }
        }
    }

    private static void addTownToDb(Connection conn, String town) throws SQLException {
        try(Statement statement = conn.createStatement()) {
            String sqlQuery =
                    "INSERT INTO `towns`(town_name)\n" +
                    "VALUES ('" + town + "');";
            statement.executeUpdate(sqlQuery);
            System.out.println(String.format("Town %s was added to the database.", town));
        }
    }
}
