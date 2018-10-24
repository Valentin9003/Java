package p06_animals.factory;

import p06_animals.IO.ConsoleIO;
import p06_animals.exceptions.InvalidInputArgumentException;
import p06_animals.models.*;
import p06_animals.util.ConfigConstants;

public final class AnimalFactory {

    public AnimalFactory() {
    }

    public final Animal produceAnimal(String animalType, ConsoleIO reader) {
        String[] animalTokens = reader.readLine().split(ConfigConstants.ANIMAL_TOKENS_SPLITTER);

        String name = animalTokens[ConfigConstants.NAME_INDEX];
        int age = Integer.parseInt(animalTokens[ConfigConstants.AGE_INDEX]);
        String gender = animalTokens[ConfigConstants.GENDER_INDEX];

        switch (animalType) {
            case ConfigConstants.ANIMAL_CAT:
                return new Cat(animalType, name, age, gender);
            case ConfigConstants.ANIMAL_DOG:
                return new Dog(animalType, name, age, gender);
            case ConfigConstants.ANIMAL_FROG:
                return new Frog(animalType, name, age, gender);
            case ConfigConstants.ANIMAL_KITTEN:
                return new Kitten(animalType, name, age, gender);
            case ConfigConstants.ANIMAL_TOMCAT:
                return new Tomcat(animalType, name, age, gender);
            default:
                throw new InvalidInputArgumentException();
        }
    }
}
