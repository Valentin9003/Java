package com.company.P006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class RemoveVillain {

    private static final String URL = "jdbc:mysql://localhost:3306/minionsdb?useSSL=false";
    private static final String USER = "root";

    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Password: ");
        String pass = reader.readLine();
        try(Connection conn = DriverManager.getConnection(URL, USER, pass)) {
            System.out.println("Connection successfully!...");
            System.out.println("Enter VillainID: ");
            int villainID = Integer.parseInt(reader.readLine());
            findVillainAndDeleteIt(conn, villainID);
        }
    }

    private static void findVillainAndDeleteIt(Connection conn, int villainID) throws SQLException {
        String sqlQuery = "SELECT * FROM `villains` WHERE `id` = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setInt(1, villainID);
            ResultSet rs = stmt.executeQuery();
            if (rs.first()) {
                String villainName = rs.getString("name");
                releasedMinions(conn, villainID, villainName);
            } else {
                System.out.println("No such villain was found");
            }
        }
    }

    private static void releasedMinions(Connection conn, int villainID, String villainName) throws SQLException {
        String sqlDeleteQuery = "DELETE FROM `minions_villains` WHERE `villain_id` = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sqlDeleteQuery)) {
            stmt.setInt(1, villainID);
            int affectedRows = stmt.executeUpdate();
            deleteVillain(conn, villainID, villainName, affectedRows);
        }
    }

    private static void deleteVillain(Connection conn, int villainID, String villainName, int affectedRows) throws SQLException {
        String sqlDeleteQuery = "DELETE FROM `villains` WHERE `id` = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sqlDeleteQuery)) {
            stmt.setInt(1, villainID);
            stmt.executeUpdate();
            System.out.println(String.format("%s was deleted", villainName));
            System.out.println(String.format("%d minions released", affectedRows));
        }
    }
}
