package p03_hierarchicalInheritance.models;

import p03_hierarchicalInheritance.models.interfaces.ICat;

public class Cat extends Animal implements ICat {

    private static final String DEFAULT_MEOWING = "meowing…";

    @Override
    public void meow() {
        System.out.println(DEFAULT_MEOWING);
    }
}
