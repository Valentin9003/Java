package com.company.P003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class MinionNames {

    private static final String URL = "jdbc:mysql://localhost:3306/minionsdb?useSSL=false";
    private static final String USER = "root";

    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Password: ");
        String pass = reader.readLine();

        try(Connection conn = DriverManager.getConnection(URL, USER, pass)) {
            System.out.println("Connection successfully!...");
            System.out.println("Please enter villain id: ");
            int villainID = Integer.parseInt(reader.readLine());

            printVillain(conn, villainID);
        }
    }

    private static void printVillain(Connection conn, int villainID) throws SQLException {
        try(Statement statement = conn.createStatement()) {
            String sqlQuery = "SELECT * FROM villains WHERE id = " + villainID;
            ResultSet rs = statement.executeQuery(sqlQuery);

            if (!rs.first()) {
                System.out.println(String.format("No villain with ID %d exists in the database.", villainID));
            } else {
                String villainName = rs.getString("name");
                System.out.println(String.format("Villain: %s", villainName));

                printAllMinionsForThisVillain(conn, villainID);
            }
        }
    }

    private static void printAllMinionsForThisVillain(Connection conn, int villainID) throws SQLException {
        try(Statement statement = conn.createStatement()) {
            String sqlQuery =
                    "SELECT m.name, m.age\n" +
                    "FROM villains AS v\n" +
                    "JOIN minions_villains AS mv ON mv.villain_id = v.id\n" +
                    "JOIN minions AS m ON m.id = mv.minion_id\n" +
                    "WHERE v.id = " + villainID + ";";
            ResultSet rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            int counter = 0;
            while (rs.next()) {
                counter++;
                String minionName = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(String.format("%d. %s %d", counter, minionName, age));
            }
        }
    }
}
