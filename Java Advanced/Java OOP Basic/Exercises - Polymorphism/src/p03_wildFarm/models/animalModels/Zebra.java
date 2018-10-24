package p03_wildFarm.models.animalModels;

import p03_wildFarm.models.foodModels.Food;
import p03_wildFarm.models.foodModels.Meat;
import p03_wildFarm.util.ConfigExMessage;

public class Zebra extends Mammal {

    private static final String DEFAULT_SOUND = "Zs";

    public Zebra(String name, double weight, String livingRegion) {
        super(name, weight, livingRegion);
    }


    @Override
    public String makeSound() {
        return DEFAULT_SOUND;
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            throw new IllegalArgumentException(ConfigExMessage.WRONG_TYPE_FOOD_ZEBRA_EX_MESSAGE);
        }
        super.eat(food);
    }
}
