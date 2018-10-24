package p01_singleInheritance.models;

import p01_singleInheritance.models.interfaces.AnimalInterface;

public class Animal implements AnimalInterface {

    private static final String DEFAULT_EATING = "eating...";

    public Animal() {
    }

    @Override
    public void eat() {
        System.out.println(DEFAULT_EATING);
    }
}
