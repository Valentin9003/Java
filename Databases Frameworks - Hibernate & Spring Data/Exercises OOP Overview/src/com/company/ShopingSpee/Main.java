package com.company.ShopingSpee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Person> pplMap = new LinkedHashMap<>();
        HashMap<String, Product> productsMap = new LinkedHashMap<>();

        String[] people = reader.readLine().trim().split(";");
        String[] products = reader.readLine().trim().split(";");

        try {
            addPeopleInMap(pplMap, people);
            addProductsInMap(productsMap, products);

            String[] command = reader.readLine().split(" ");
            while (!command[0].equals("END")) {
                executeCommand(command, pplMap, productsMap);
                command = reader.readLine().split(" ");
            }
            printPersonsAndTheirBagWithProducts(pplMap);

        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void printPersonsAndTheirBagWithProducts(HashMap<String, Person> pplMap) {
        for (String personName : pplMap.keySet()) {
            System.out.println(pplMap.get(personName).toString());
        }
    }

    private static void executeCommand(String[] command, HashMap<String, Person> pplMap, HashMap<String, Product> productsMap) {
        String personName = command[0];
        String productName = command[1];

//        checkForThisProductAndPersonInDatabase(personName, productName, pplMap, productsMap);
        buyTheProduct(personName, productName, pplMap, productsMap);
    }

    private static void buyTheProduct(String personName, String productName, HashMap<String, Person> pplMap, HashMap<String, Product> productsMap) {
        double productCost = productsMap.get(productName).getCost();
        double personBudget = pplMap.get(personName).getMoney();

        if (pplMap.containsKey(personName) && productsMap.containsKey(productName)) {
            if (productCost > personBudget) {
                System.out.println(String.format("%s can't afford %s", personName, productName));
            } else {
                pplMap.get(personName).buyProduct(productsMap.get(productName));
                System.out.println(String.format("%s bought %s", personName, productName));
            }
        }
    }

    private static void checkForThisProductAndPersonInDatabase(String personName, String productName, HashMap<String, Person> pplMap, HashMap<String, Product> productsMap) {
        if (!pplMap.containsKey(personName)) {
            System.out.println("This name does not exist in database");
        }
        if (!productsMap.containsKey(productName)) {
            System.out.println("This product does not exist in the shop database");
        }
    }

    private static void addProductsInMap(HashMap<String, Product> productsMap, String[] products) {
        for (String product : products) {
            if (product.trim().length() != 0) {
                String[] tokens = product.split("=");
                String name = tokens[0];
                double cost = Double.parseDouble(tokens[1]);

                if (productsMap.containsKey(name)) {
                    productsMap.get(name).addNewCost(cost);
                } else {
                    Product prod = new Product(name, cost);
                    productsMap.putIfAbsent(name, prod);
                }
            }
        }
    }

    private static void addPeopleInMap(HashMap<String, Person> pplMap, String[] people) {
        for (String ppl : people) {
            if (ppl.trim().length() != 0) {
                String[] tokens = ppl.split("=");
                String name = tokens[0];
                double money = Double.parseDouble(tokens[1]);

                if (pplMap.containsKey(name)) {
                    pplMap.get(name).addMoneyToBudget(money);
                } else {
                    Person person = new Person(name, money);
                    pplMap.putIfAbsent(name, person);
                }
            }
        }
    }
}
