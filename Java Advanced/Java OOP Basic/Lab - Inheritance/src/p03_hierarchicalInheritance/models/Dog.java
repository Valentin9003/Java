package p03_hierarchicalInheritance.models;

import p03_hierarchicalInheritance.models.interfaces.IDog;

public class Dog extends Animal implements IDog {

    private static final String DEFAULT_BARKING = "barking…";

    @Override
    public void bark() {
        System.out.println(DEFAULT_BARKING);
    }
}
