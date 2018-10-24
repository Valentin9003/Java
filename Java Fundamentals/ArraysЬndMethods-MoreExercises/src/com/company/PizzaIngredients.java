package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PizzaIngredients {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> myList = new ArrayList<>(Arrays.asList(reader.readLine().split("\\s")));
        int searchedLength = Integer.parseInt(reader.readLine());

        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < myList.size(); i++) {
            String word = myList.get(i);
            if (word.length() == searchedLength) {
                System.out.printf("Adding %s.%n", word);
                resultList.add(word);
            }
            if (resultList.size() == 10) {
                break;
            }
        }

        System.out.printf("Made pizza with total of %d ingredients.%n", resultList.size());
        System.out.print("The ingredients are: ");
        System.out.print(String.join(", ", resultList));
        System.out.print(".");
    }
}
