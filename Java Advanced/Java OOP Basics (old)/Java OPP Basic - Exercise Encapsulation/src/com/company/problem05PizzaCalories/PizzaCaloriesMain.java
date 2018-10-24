package com.company.problem05PizzaCalories;

import com.company.problem05PizzaCalories.models.Dough;
import com.company.problem05PizzaCalories.models.Pizza;
import com.company.problem05PizzaCalories.models.Topping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PizzaCaloriesMain {
    private static BufferedReader reader;

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                String[] input = reader.readLine().split("\\s+");
                if (input[0].equals("END")) {
                    break;
                }

                String result = null;
                switch (input[0]) {
                    case "Dough":
                        Dough dough = tryMakeDough(input);
                        result = String.format("%.2f", dough.getCalories());
                        break;

                    case "Topping":
                        Topping topping = tryMakeTopping(input);
                        result = String.format("%.2f", topping.getCalories());
                        break;

                    case "Pizza":
                        Pizza pizza = tryMakePizza(input);
                        result = pizza.toString();
                        break;
                }
                System.out.println(result);
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static Pizza tryMakePizza(String[] input) throws IOException {
        String name = input[1];
        int toppingsCount = Integer.valueOf(input[2]);
        Pizza pizza = new Pizza(name, toppingsCount);

        String[] line = reader.readLine().split("\\s+");
        Dough dough = tryMakeDough(line);
        pizza.setDough(dough);

        for (int i = 0; i < toppingsCount; i++) {
            String[] toppInput = reader.readLine().split("\\s+");
            Topping topping = tryMakeTopping(toppInput);
            pizza.addTopping(topping);
        }

        return pizza;
    }

    private static Topping tryMakeTopping(String[] input) {
        String type = input[1];
        int weight = Integer.valueOf(input[2]);

        Topping topping = new Topping(type, weight);
        return topping;
    }

    private static Dough tryMakeDough(String[] input) {
        String flour = input[1];
        String technique = input[2];
        int weigh = Integer.valueOf(input[3]);

        Dough dough = new Dough(flour, technique, weigh);
        return dough;
    }
}
