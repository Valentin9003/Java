package p03_wildFarm.engine;

import p03_wildFarm.IO.ConsoleIO;
import p03_wildFarm.factory.AnimalFactory;
import p03_wildFarm.factory.FoodFactory;
import p03_wildFarm.models.animalModels.Animal;
import p03_wildFarm.models.foodModels.Food;
import p03_wildFarm.util.ConfigConstants;

import java.util.LinkedList;
import java.util.List;

public final class WildFarmEngine {

    private ConsoleIO consoleIO;
    private List<Animal> animalsDB;

    public WildFarmEngine() {
        this.consoleIO = new ConsoleIO();
        this.animalsDB = new LinkedList<>();
    }

    public void run() {
        createObjectsFeedAnimalsAndFillDatabase();
        printInfoForAllReceivedAnimals();
    }

    private void printInfoForAllReceivedAnimals() {
        animalsDB.forEach(animal ->
                consoleIO.writeLine(animal.toString()));
    }

    private void createObjectsFeedAnimalsAndFillDatabase() {
        String line;
        while (!ConfigConstants.STOP.equalsIgnoreCase(line = consoleIO.readLine())) {
            Animal animal = createAnimalFromTheGivenData(line);
            Food food = createFoodFromTheGivenData();

            if (animal == null || food == null)
                continue;

            consoleIO.writeLine(animal.makeSound());

            feedTheAnimal(animal, food);
            animalsDB.add(animal);
        }
    }

    private Food createFoodFromTheGivenData() {
        Food food = null;
        try {
            food = FoodFactory.produceFood(consoleIO);
        } catch (IllegalArgumentException iae) {
            consoleIO.writeLine(iae.getMessage());
        }
        return food;
    }

    private Animal createAnimalFromTheGivenData(String line) {
        Animal animal = null;
        try {
            animal = AnimalFactory.produceAnimal(line);
        } catch (IllegalArgumentException iae) {
            consoleIO.writeLine(iae.getMessage());
        }
        return animal;
    }

    private void feedTheAnimal(Animal animal, Food food) {
        try {
            animal.eat(food);
        } catch (IllegalArgumentException iae) {
            consoleIO.writeLine(iae.getMessage());
        }
    }
}
