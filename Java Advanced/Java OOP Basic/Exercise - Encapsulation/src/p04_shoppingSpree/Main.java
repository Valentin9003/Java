package p04_shoppingSpree;

import p04_shoppingSpree.models.Person;
import p04_shoppingSpree.models.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    private static final String STOP = "END";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> personsDB = new LinkedHashMap<>();
        Map<String, Product> productsDB = new HashMap<>();

        try {
            fillPersonDatabase(personsDB, reader);
            fillProductDatabase(productsDB, reader);

            String line;
            while (!STOP.equalsIgnoreCase(line = reader.readLine())) {
                buyTheProduct(personsDB, productsDB, line);
            }

            personsDB.values().forEach(System.out::println);

        } catch (IllegalArgumentException iae) {
            //Stop all the program if there is a invalid input data and print the ex.getMessage()
            System.out.println(iae.getMessage());
        }

    }

    private static void buyTheProduct(Map<String, Person> personsDB, Map<String, Product> productsDB, String line) {
        String[] lineTokens = line.split("\\s+");
        String personName = lineTokens[0];
        String productName = lineTokens[1];

        try {
            personsDB.get(personName).buyProduct(productsDB.get(productName));
            System.out.println(String.format("%s bought %s", personName, productName));
        } catch (IllegalArgumentException iaeForBuying) {
            System.out.println(iaeForBuying.getMessage());
        }
    }

    private static void fillProductDatabase(Map<String, Product> productsDB, BufferedReader reader) throws IOException {
        String[] personsArr = reader.readLine().trim().split(";");

        for (String input : personsArr) {
            String[] tokens = input.split("=");
            String name = tokens[0];
            double cost = Double.parseDouble(tokens[1]);

            Product product = new Product(name, cost);

            if (productsDB.containsKey(name)) {
                productsDB.get(name).addNewCost(cost);
            }
            productsDB.putIfAbsent(name, product);
        }
    }

    private static void fillPersonDatabase(Map<String, Person> database, BufferedReader reader) throws IOException {
        String[] arr = reader.readLine().trim().split(";");

        for (String input : arr) {
            String[] tokens = input.split("=");
            String name = tokens[0];
            double money = Double.parseDouble(tokens[1]);

            Person person = new Person(name, money);

            if (database.containsKey(name)) {
                database.get(name).addMoneyToBudget(money);
            }
            database.putIfAbsent(name, person);

        }
    }
}
