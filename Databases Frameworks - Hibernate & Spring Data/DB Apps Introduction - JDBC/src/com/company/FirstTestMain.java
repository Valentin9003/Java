package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class FirstTestMain {
    private static final String URL = "jdbc:mysql://localhost:3306/hospital?createDatabaseIfNotExist=true&useSSL=false";
    private static final String USER = "root";
    private static String PASSWORD = "";

    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Password: ");
        PASSWORD = reader.readLine();

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println(".....::: Connection Established Successfully :::.....");
            System.out.println();
            //* "Clear" Statement is dangerous, can be affected from SQL injection.
            //* To be save from SQL injections - use aways PrepareStatement (when u expect data for your query from the user)
            try (Statement statement = connection.createStatement()) {
                String sqlQuery = "SELECT * FROM employees WHERE salary >= 1800";
                ResultSet resultSet = statement.executeQuery(sqlQuery);

                resultSet.beforeFirst();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String jobTitle = resultSet.getString("job_title");
                    int departmentID = resultSet.getInt("department_id");
                    double salary = resultSet.getDouble("salary");

                    System.out.println(String.format("ID: %d%n" +
                            "First Name: %s%n" +
                            "Last Name: %s%n" +
                            "Job Title: %s%n" +
                            "Department ID: %d%n" +
                            "Salary: %.2f%n", id, firstName, lastName, jobTitle, departmentID, salary));
//                    connection.commit();
                }
            } catch (SQLException sql) {
                connection.rollback();
            }
        }
    }
}
