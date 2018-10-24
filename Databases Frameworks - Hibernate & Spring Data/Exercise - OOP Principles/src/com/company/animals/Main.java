package com.company.animals;

import com.company.animals.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animals> animalsList = new LinkedList<>();

        String animal = reader.readLine();
        while (!animal.equals("Beast!")) {
            String[] tokens = reader.readLine().split("\\s+");
            try {
                createAndAddAnimalToTheDatabase(animalsList, tokens, animal);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
            animal = reader.readLine();
        }

        printAnimals(animalsList);
    }

    private static void printAnimals(List<Animals> animalsList) {
        for (Animals animal : animalsList) {
            System.out.println(animal.toString());
            animal.produceSound();
        }
    }

    private static void createAndAddAnimalToTheDatabase(List<Animals> animalsList, String[] tokens, String animal) {
        String animalName = tokens[0];
        int age = Integer.parseInt(tokens[1]);
        String gender = tokens[2];

        Animals animals = null;
        switch (animal) {
            case "Cat":
                animals = new Cat(animalName, age, gender);
                break;
            case "Dog":
                animals = new Dog(animalName, age, gender);
                break;
            case "Frog":
                animals = new Frog(animalName, age, gender);
                break;
            case "Kitten":
                animals = new Kitten(animalName, age, "Female");
                break;
            case "Tomcat":
                animals = new Tomcat(animalName, age, "Male");
                break;
            default:
                throw new IllegalArgumentException("Invalid input!");
        }
        animalsList.add(animals);
    }
}
