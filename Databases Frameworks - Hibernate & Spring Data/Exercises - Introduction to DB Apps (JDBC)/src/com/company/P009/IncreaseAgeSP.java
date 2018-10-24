package com.company.P009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class IncreaseAgeSP {

    private static final String URL = "jdbc:mysql://localhost:3306/minionsdb?useSSL=false";
    private static final String USER = "root";

    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Password: ");
        String pass = reader.readLine();
        try(Connection conn = DriverManager.getConnection(URL, USER, pass)) {
            System.out.println("Connection successfully!...");
            System.out.println("Enter minionID: ");
            int minionID = Integer.parseInt(reader.readLine());
            useStoredProcedure(conn, minionID);
        }
    }

    private static void useStoredProcedure(Connection conn, int minionID) throws SQLException {
        String sqlQuery = "CALL usp_get_older(?)";
        try(PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setInt(1, minionID);
            stmt.execute();
        }
        printResult(conn, minionID);
    }

    private static void printResult(Connection conn, int minionID) throws SQLException {
        String sqlQuery = "SELECT * FROM `minions` WHERE `id` = ?;";
        try(PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setInt(1, minionID);
            ResultSet rs = stmt.executeQuery();
            rs.first();
            String minionName = rs.getString("name");
            int minionAge = rs.getInt("age");
            System.out.println(String.format("%s %d", minionName, minionAge));
        }
    }
}
