package com.company.P005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChangeTownName {

    private static final String URL = "jdbc:mysql://localhost:3306/minionsdb?useSSL=false";
    private static final String USER = "root";

    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Password: ");
        String pass = reader.readLine();

        try(Connection conn = DriverManager.getConnection(URL, USER, pass)) {
            System.out.println("Connection successfully!...");
            String country = reader.readLine();
            changeTownsNamesToUppercase(conn, country);
            printResult(conn, country);
        }
    }

    private static void printResult(Connection conn, String country) throws SQLException {
        List<String> townsList = getAffectedTownNames(conn, country);
        if (townsList.size() == 0) {
            System.out.println("No town names were affected.");
        } else {
            System.out.println(String.format("%d town names were affected.", townsList.size()));
            System.out.println(townsList);
        }
    }

    private static List<String> getAffectedTownNames(Connection conn, String country) throws SQLException {
        List<String> townsList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM `towns` WHERE country_location = '" + country + "';";
        try(Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            while (rs.next()) {
                String townName = rs.getString("town_name");
                townsList.add(townName);
            }
        }
        return townsList;
    }

    private static void changeTownsNamesToUppercase(Connection conn, String country) throws SQLException {
        String sqlQuery = "SELECT * FROM `towns` WHERE country_location = '" + country + "';";
        try(Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            if (rs.first()) {
                rs.beforeFirst();
                while (rs.next()) {
                    String townName = rs.getString("town_name");
                    updateTownName(conn, townName);
                }
            }
        }
    }

    private static void updateTownName(Connection conn, String townName) throws SQLException {
        String sqlQuery =
                "UPDATE `towns` \n" +
                "SET town_name = upper(town_name)\n" +
                "WHERE town_name LIKE (?);";
        try(PreparedStatement statement = conn.prepareStatement(sqlQuery)) {
            statement.setString(1, townName);
            statement.executeUpdate();
        }
    }
}
