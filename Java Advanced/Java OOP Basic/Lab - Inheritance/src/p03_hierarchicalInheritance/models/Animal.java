package p03_hierarchicalInheritance.models;

import p03_hierarchicalInheritance.models.interfaces.IAnimal;

public class Animal implements IAnimal {

    private static final String DEFAULT_EATING = "eating…";

    @Override
    public void eat() {
        System.out.println(DEFAULT_EATING);
    }
}
