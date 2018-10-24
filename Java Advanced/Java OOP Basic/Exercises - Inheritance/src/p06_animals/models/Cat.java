package p06_animals.models;

import p06_animals.util.ConfigDefaultSound;

public class Cat extends Animal {

    public Cat(String animalType, String name, int age, String gender) {
        super(animalType, name, age, gender);
    }

    @Override
    public String produceSound() {
        return ConfigDefaultSound.CAT_DEFAULT_SOUND;
    }
}
