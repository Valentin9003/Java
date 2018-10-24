package p03_wildFarm.models.animalModels.interfaces;

import p03_wildFarm.models.foodModels.Food;

public interface IAnimal {

    String makeSound();

    void eat(Food food);
}
