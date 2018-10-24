package p06_animals.models;

import p06_animals.util.ConfigDefaultSound;

public final class Tomcat extends Cat {

    public Tomcat(String animalType, String name, int age, String gender) {
        super(animalType, name, age, gender);
    }

    @Override
    public final String produceSound() {
        return ConfigDefaultSound.TOMCAT_DEFAULT_SOUND;
    }
}
