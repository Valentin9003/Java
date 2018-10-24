package p02_multipleInheritance.models;

import p02_multipleInheritance.models.interfaces.AnimalInterface;

public class Animal implements AnimalInterface {

    private static final String DEFAULT_EATING = "eating...";

    public Animal() {
    }

    @Override
    public void eat() {
        System.out.println(DEFAULT_EATING);
    }
}
