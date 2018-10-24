package p03_coffeeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        String line;
        while (!"END".equalsIgnoreCase(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");

            if (tokens.length == 1) {
                coffeeMachine.insertCoin(tokens[0]);
            } else {
                coffeeMachine.buyCoffee(tokens[0], tokens[1]);
            }
        }

        Iterable<Coffee> coffeesSold = coffeeMachine.coffeesSold();
        for (Coffee coffee : coffeesSold) {
            System.out.println(coffee);
        }
    }
}
