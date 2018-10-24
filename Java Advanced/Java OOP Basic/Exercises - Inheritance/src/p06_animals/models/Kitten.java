package p06_animals.models;

import p06_animals.util.ConfigDefaultSound;

public final class Kitten extends Cat {

    public Kitten(String animalType, String name, int age, String gender) {
        super(animalType, name, age, gender);
    }

    @Override
    public final String produceSound() {
        return ConfigDefaultSound.KITTEN_DEFAULT_SOUND;
    }
}
