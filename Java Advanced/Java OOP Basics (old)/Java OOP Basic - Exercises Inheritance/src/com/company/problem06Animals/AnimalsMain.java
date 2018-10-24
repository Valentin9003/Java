package com.company.problem06Animals;

import com.company.problem06Animals.models.Cat;
import com.company.problem06Animals.models.Dog;
import com.company.problem06Animals.models.Frog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnimalsMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String type = reader.readLine();
            if (type.equals("Beast!")) {
                break;
            }

            String[] details = reader.readLine().split("\\s+");

            try {
                addAnimal(type, details);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void addAnimal(String type, String[] details) {
        String name = details[0];
        int age = Integer.parseInt(details[1]);
        String gender = details[2];

        switch (type) {
            case "Cat":
                Cat cat = new Cat(type, name, age, gender);
                System.out.println(cat);
                break;
            case "Dog":
                Dog dog = new Dog(type, name, age, gender);
                System.out.println(dog);
                break;
            case "Frog":
                Frog frog = new Frog(type, name, age, gender);
                System.out.println(frog);
                break;
        }
    }
}
