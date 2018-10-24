package com.company.P007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrintAllMinion {

    private static final String URL = "jdbc:mysql://localhost:3306/minionsdb?useSSL=false";
    private static final String USER = "root";

    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Password: ");
        String pass = reader.readLine();
        try(Connection conn = DriverManager.getConnection(URL, USER, pass)) {
            System.out.println("Connection successfully!...");
            printMinions(conn);
        }
    }

    private static void printMinions(Connection conn) throws SQLException {
        List<String> minionsList = new ArrayList<>();

        String sqlQuery = "SELECT * FROM `minions`;";
        try(Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sqlQuery);
//            ResultSetMetaData rsm = rs.getMetaData();
            rs.beforeFirst();
            while (rs.next()) {
                minionsList.add(rs.getString("name"));
            }
        }
        printResult(minionsList);
    }

    private static void printResult(List<String> minionsList) {
        int counter = 0;
        for (int i = 0; i < minionsList.size() / 2; i++) {
            System.out.println(minionsList.get(i));
            System.out.println(minionsList.get((minionsList.size() - 1) - i));
            counter += 2;
        }
        if (minionsList.size() > counter) {
            int index = minionsList.size() / 2;
            System.out.println(minionsList.get(index));
        }
    }
}
