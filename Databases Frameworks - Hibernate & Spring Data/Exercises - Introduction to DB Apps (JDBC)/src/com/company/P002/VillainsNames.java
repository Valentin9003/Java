package com.company.P002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class VillainsNames {

    private static final String URL = "jdbc:mysql://localhost:3306/minionsdb?useSSL=false";
    private static final String USER = "root";

    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Password: ");
        String pass = reader.readLine();

        try(Connection conn = DriverManager.getConnection(URL, USER, pass)) {
            System.out.println("Connection success!");

            String sqlQuery =
                            "SELECT v.name, count(mv.minion_id) AS 'count_minions'\n" +
                            "FROM villains AS v\n" +
                            "JOIN minions_villains AS mv\n" +
                            "\tON mv.villain_id = v.id\n" +
                            "GROUP BY v.name\n" +
                            "HAVING count_minions > 3;";

            try(Statement statement = conn.createStatement()) {
                ResultSet rs = statement.executeQuery(sqlQuery);
                rs.beforeFirst();
                while (rs.next()) {
                    String villainName = rs.getString("name");
                    int countMinions = rs.getInt("count_minions");

                    System.out.println(String.format("%s %d", villainName, countMinions));
                }
            }
        }
    }
}
