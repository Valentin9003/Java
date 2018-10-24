package com.company.problem04ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ShoppingSpreeMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] peopleArr = reader.readLine().split(";");
        String[] productArr = reader.readLine().split(";");

        List<Person> personsList = new ArrayList<>();
        List<Product> productsList = new ArrayList<>();

        addPersonsInList(peopleArr, personsList);
        addProductsInList(productArr, productsList);

        String[] purchases = reader.readLine().split("\\s+");
        while (!purchases[0].equals("END")) {

            executePurchase(purchases, personsList, productsList);

            purchases = reader.readLine().split("\\s+");
        }

        for (Person person : personsList) {
            person.printBag();
        }
    }

    private static void executePurchase(String[] purchases, List<Person> personsList, List<Product> productsList) {
        String buyer = purchases[0];
        String productForBuy = purchases[1];

        for (Person person : personsList) {
            if (person.getName().equals(buyer)) {

                for (Product product : productsList) {
                    if (product.getName().equals(productForBuy)) {

                        person.buyProduct(product);
                    }
                }
            }
        }
    }

    private static void addProductsInList(String[] productArr, List<Product> productsList) {
        for (String product : productArr) {
            if (!product.isEmpty()) {
                String[] singleProduct = product.split("=");
                String productName = singleProduct[0];
                Double productPrice = Double.valueOf(singleProduct[1]);

                try {
                    Product prod = new Product(productName, productPrice);
                    productsList.add(prod);
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
            }
        }
    }

    private static void addPersonsInList(String[] peopleArr, List<Person> personsList) {
        for (String people : peopleArr) {
            if (!people.isEmpty()) {
                String[] singlePerson = people.split("=");
                String name = singlePerson[0];
                Double money = Double.parseDouble(singlePerson[1]);

                try {
                    Person person = new Person(name, money);
                    personsList.add(person);
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
            }
        }
    }
}
