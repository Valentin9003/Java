package p05_pizzaCalories;

import p05_pizzaCalories.models.Dough;
import p05_pizzaCalories.models.Pizza;
import p05_pizzaCalories.models.Topping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String WHITE_SPACES_REGEX = "\\s+";
    private static final String STOP_PROGRAM = "END";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            Pizza pizza = createNewPizza(reader);

            Dough dough = getDough(reader);
            pizza.setDough(dough);

            addToppings(reader, pizza);

            System.out.println(pizza);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static Pizza createNewPizza(BufferedReader reader) throws IOException {
        String[] pizzaTokens = reader.readLine().split(WHITE_SPACES_REGEX);
        String pizzaName = pizzaTokens[1];
        int numberOfToppings = Integer.parseInt(pizzaTokens[2]);

        return new Pizza(pizzaName, numberOfToppings);
    }

    private static void addToppings(BufferedReader reader, Pizza pizza) throws IOException {
        String line;
        while (!STOP_PROGRAM.equalsIgnoreCase(line = reader.readLine())) {
            String[] toppingTokens = line.split(WHITE_SPACES_REGEX);
            String toppingType = toppingTokens[1];
            int toppingWeightInGrams = Integer.parseInt(toppingTokens[2]);

            Topping topping = new Topping(toppingType, toppingWeightInGrams);
            pizza.addTopping(topping);
        }
    }

    private static Dough getDough(BufferedReader reader) throws IOException {
        String[] doughTokens = reader.readLine().split(WHITE_SPACES_REGEX);
        String flourType = doughTokens[1];
        String bakingTechnique = doughTokens[2];
        int doughWeightInGrams = Integer.parseInt(doughTokens[3]);

        return new Dough(flourType, bakingTechnique, doughWeightInGrams);
    }
}
