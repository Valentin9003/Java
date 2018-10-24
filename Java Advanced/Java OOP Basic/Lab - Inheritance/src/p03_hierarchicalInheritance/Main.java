package p03_hierarchicalInheritance;

import p03_hierarchicalInheritance.models.Cat;
import p03_hierarchicalInheritance.models.Dog;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Dog dog = new Dog();
        dog.eat();
        dog.bark();

        Cat cat = new Cat();
        cat.eat();
        cat.meow();

    }
}
