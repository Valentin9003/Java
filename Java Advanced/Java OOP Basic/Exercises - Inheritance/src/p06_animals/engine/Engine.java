package p06_animals.engine;

import p06_animals.IO.ConsoleIO;
import p06_animals.exceptions.InvalidInputArgumentException;
import p06_animals.factory.AnimalFactory;
import p06_animals.models.Animal;
import p06_animals.util.ConfigConstants;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public final class Engine {

    private List<Animal> animalsDB;
    private final ConsoleIO consoleIO;
    private final AnimalFactory animalFactory;

    public Engine() {
        this.animalsDB = new LinkedList<>();
        this.consoleIO = new ConsoleIO();
        this.animalFactory = new AnimalFactory();

    }

    public void run() {
        produceAnimals();
        printResult();
    }

    private void printResult() {
        this.animalsDB.forEach(animal -> {
            this.consoleIO.writeLine(animal.toString());
            this.consoleIO.writeLine(animal.produceSound());
        });
    }

    private void produceAnimals() {
        Predicate<String> predicate = str -> !ConfigConstants.STOP_PROCESS.equalsIgnoreCase(str);

        String animalType;
        while (predicate.test(animalType = this.consoleIO.readLine())) {
            Animal animal = null;
            try {
                animal = this.animalFactory.produceAnimal(animalType, this.consoleIO);
            } catch (InvalidInputArgumentException iiae) {
                System.out.println(iiae.getMessage());
            }

            if (animal != null) {
                this.animalsDB.add(animal);
            }
        }
    }


}
