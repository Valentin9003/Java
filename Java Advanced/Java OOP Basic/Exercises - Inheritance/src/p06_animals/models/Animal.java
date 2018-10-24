package p06_animals.models;

import p06_animals.exceptions.InvalidInputArgumentException;
import p06_animals.models.interfaces.SoundProducible;
import p06_animals.util.ConfigDefaultSound;

public class Animal implements SoundProducible {

    private String animalType;
    private String name;
    private int age;
    private String gender;

    public Animal() {
    }

    public Animal(String animalType, String name, int age, String gender) {
        this.setAnimalType(animalType);
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setAnimalType(String animalType) {
        if (animalType == null || animalType.trim().isEmpty()) {
            throw new InvalidInputArgumentException();
        }
        this.animalType = animalType;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidInputArgumentException();
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age <= 0) {
            throw new InvalidInputArgumentException();
        }
        this.age = age;
    }

    private void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty()) {
            throw new InvalidInputArgumentException();
        }
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    @Override
    public String produceSound() {
        return ConfigDefaultSound.ANIMAL_DEFAULT_SOUND;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.animalType)
                .append(System.lineSeparator())
                .append(String.format("%s %d %s",
                        this.getName(),
                        this.getAge(),
                        this.getGender()));

        return sb.toString();
    }
}
