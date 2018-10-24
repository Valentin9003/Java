package p06_animals.models;

import p06_animals.util.ConfigDefaultSound;

public final class Dog extends Animal {

    public Dog(String animalType, String name, int age, String gender) {
        super(animalType, name, age, gender);
    }

    @Override
    public final String produceSound() {
        return ConfigDefaultSound.DOG_DEFAULT_SOUND;
    }
}
