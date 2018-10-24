package p03_wildFarm.models.animalModels;

import p03_wildFarm.models.foodModels.Food;
import p03_wildFarm.models.foodModels.Vegetable;
import p03_wildFarm.util.ConfigExMessage;

public class Tiger extends Feline {

    private static final String DEFAULT_SOUND = "ROAAR!!!";

    public Tiger(String name, double weight, String livingRegion) {
        super(name, weight, livingRegion);
    }

    @Override
    public String makeSound() {
        return DEFAULT_SOUND;
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            throw new IllegalArgumentException(ConfigExMessage.WRONG_TYPE_FOOD_TIGER_EX_MESSAGE);
        }
        super.eat(food);
    }
}
