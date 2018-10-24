package p06_animals.models;

import p06_animals.util.ConfigDefaultSound;

public final class Frog extends Animal {

    public Frog(String animalType, String name, int age, String gender) {
        super(animalType, name, age, gender);
    }

    @Override
    public final String produceSound() {
        return ConfigDefaultSound.FROG_DEFAULT_SOUND;
    }
}
