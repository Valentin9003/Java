package p02_multipleInheritance.models;

import p02_multipleInheritance.models.interfaces.DogInterface;

public class Dog extends Animal implements DogInterface {

    private static final String DEFAULT_BARK = "barking...";

    public Dog() {
    }

    @Override
    public void bark() {
        System.out.println(DEFAULT_BARK);
    }
}
