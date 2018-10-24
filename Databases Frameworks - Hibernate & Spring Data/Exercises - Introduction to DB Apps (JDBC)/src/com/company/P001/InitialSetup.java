package com.company.P001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitialSetup {

    private static final String URL = "jdbc:mysql://localhost:3306/minionsdb?createDatabaseIfNotExist=true&useSSL=false";
    private static final String USER = "root";

    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Password: ");
        String pass = reader.readLine();

        try(Connection conn = DriverManager.getConnection(URL, USER, pass)) {
            System.out.println("Connection successfully!");

            createTableTowns(conn);
            createTableMinions(conn);
            createTableVillains(conn);
            createTableMinionsVillains(conn);
            insertDataIntoTowns(conn);
            insertDataIntoMinions(conn);
            insertDataIntoVillains(conn);
            insertDataIntoMinionsVillains(conn);
        }
    }

    private static void insertDataIntoMinionsVillains(Connection conn) throws SQLException {
        try(Statement statement = conn.createStatement()) {
            String sqlQuery =
                           "INSERT INTO `minions_villains`(minion_id, villain_id)\n" +
                            "VALUES\n" +
                            "\t(3, 1),\n" +
                            "\t(2, 3),\n" +
                            "\t(1, 4),\n" +
                            "\t(5, 1),\n" +
                            "\t(2, 1),\n" +
                            "\t(5, 4),\n" +
                            "\t(4, 2),\n" +
                            "\t(2, 4),\n" +
                            "\t(4, 5);";

            int affectedRows = statement.executeUpdate(sqlQuery);
            conn.commit();
            System.out.println("Insert data in to `minions_villains` successfully. Affected rows are " + affectedRows);
        } catch (SQLException ex) {
            conn.rollback();
        }
    }

    private static void insertDataIntoVillains(Connection conn) throws SQLException {
        try(Statement statement = conn.createStatement()) {
            String sqlQuery =
                            "INSERT INTO `villains`(name, evilness_factor)\n" +
                            "VALUES  \n" +
                            "\t('Helpercho', 'good'),\n" +
                            "\t('Badman', 'bad'),\n" +
                            "\t('Evilman', 'evil'),\n" +
                            "\t('Sleeper', 'super evil'),\n" +
                            "\t('Hopercho', 'good'),\n" +
                            "\t('Evill', 'super evil');";

            int affectedRows = statement.executeUpdate(sqlQuery);
            conn.commit();
            System.out.println("Insert data in to `villains` successfully. Affected rows are " + affectedRows);
        } catch (SQLException ex) {
            conn.rollback();
        }
    }

    private static void insertDataIntoMinions(Connection conn) throws SQLException {
        try(Statement statement = conn.createStatement()) {
            String sqlQuery =
                            "INSERT INTO `minions`(name, age, town_id)\n" +
                            "VALUES\n" +
                            "\t('Ragner', 40, 3),\n" +
                            "\t('Tombot', 40, 2),\n" +
                            "\t('Killer', 40, 4),\n" +
                            "\t('Fairman', 40, 1),\n" +
                            "\t('Zombi', 40, 5),\n" +
                            "\t('Maina', 25, 1);";

            int affectedRows = statement.executeUpdate(sqlQuery);
            conn.commit();
            System.out.println("Insert data in to `minions` successfully. Affected rows are " + affectedRows);
        } catch (SQLException ex) {
            conn.rollback();
        }
    }

    private static void insertDataIntoTowns(Connection conn) throws SQLException {
        try(Statement statement = conn.createStatement()) {
            String sqlQuery =
                            "INSERT INTO `towns`(town_name, country_location)\n" +
                            "VALUES \n" +
                            "\t('Plovdiv', 'Bulgaria'),\n" +
                            "('Beograd', 'Serbia'),\n" +
                            "('Paris', 'France'),\n" +
                            "('Moskva', 'Rusia'),\n" +
                            "('Sofia', 'Bulgaria');";

            int affectedRows = statement.executeUpdate(sqlQuery);
            conn.commit();
            System.out.println("Insert data in to `tows` successfully. Affected rows are " + affectedRows);
        } catch (SQLException ex) {
            conn.rollback();
        }
    }

    private static void createTableMinionsVillains(Connection conn) throws SQLException {
        try(Statement statement = conn.createStatement()) {
            String sqlQuery =
                            "CREATE TABLE `minions_villains` (\n" +
                            "minion_id INT,\n" +
                            "villain_id INT,\n" +
                            "CONSTRAINT pk_mv PRIMARY KEY (minion_id , villain_id),\n" +
                            "CONSTRAINT fk_mv_minions FOREIGN KEY (minion_id)\n" +
                            "REFERENCES `minions` (id),\n" +
                            "CONSTRAINT fk_mv_villains FOREIGN KEY (villain_id)\n" +
                            "REFERENCES `villains` (id)\n" +
                            ");";

            statement.executeUpdate(sqlQuery);
            System.out.println("Table `minions_villains` was created successfully!");
        }
    }

    private static void createTableVillains(Connection conn) throws SQLException {
        try(Statement statement = conn.createStatement()) {
            String sqlQuery =
                            "CREATE TABLE `villains` (\n" +
                            "\tid INT PRIMARY KEY AUTO_INCREMENT,\n" +
                            "name VARCHAR(50),\n" +
                            "evilness_factor VARCHAR(20) CHECK (evilness_factor IN ('good' , 'bad', 'evil', 'super evil'))\n" +
                            ");";

            statement.executeUpdate(sqlQuery);
            System.out.println("Table `villains` was created successfully!");
        }
    }

    private static void createTableMinions(Connection conn) throws SQLException {
        try(Statement statement = conn.createStatement()) {
            String sqlQuery =
                            "CREATE TABLE `minions` (\n" +
                            "id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                            "name VARCHAR(50),\n" +
                            "age INT,\n" +
                            "town_id INT,\n" +
                            "CONSTRAINT fk_minions_towns FOREIGN KEY (town_id)\n" +
                            "REFERENCES `towns` (id)\n" +
                            ");";

            statement.executeUpdate(sqlQuery);
            System.out.println("Table `minions` was created successfully!");
        }
    }

    private static void createTableTowns(Connection conn) throws SQLException {
        try(Statement statement = conn.createStatement()) {
            String sqlQuery =
                            "CREATE TABLE `towns` (\n" +
                            "\tid INT PRIMARY KEY AUTO_INCREMENT,\n" +
                            "town_name VARCHAR(50),\n" +
                            "country_location VARCHAR(50)\n" +
                            ");";

            statement.executeUpdate(sqlQuery);
            System.out.println("Table `tows` was created successfully!");
        }
    }
}
