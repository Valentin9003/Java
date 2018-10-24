package p03_wildFarm.factory;

import p03_wildFarm.IO.ConsoleIO;
import p03_wildFarm.models.foodModels.Food;
import p03_wildFarm.models.foodModels.Meat;
import p03_wildFarm.models.foodModels.Vegetable;
import p03_wildFarm.util.ConfigConstants;
import p03_wildFarm.util.ConfigExMessage;

public abstract class FoodFactory {

    private FoodFactory() {
    }

    public static Food produceFood(ConsoleIO consoleIO) {
        String[] foodTokens = consoleIO.readLine().split("\\s+");
        String type = foodTokens[ConfigConstants.TYPE_INDEX];
        int quantity = Integer.parseInt(foodTokens[ConfigConstants.QUANTITY_INDEX]);

        switch (type) {
            case ConfigConstants.FOOD_TYPE_VEGETABLE:
                return new Vegetable(quantity);
            case ConfigConstants.FOOD_TYPE_MEAT:
                return new Meat(quantity);
            default:
                throw new IllegalArgumentException(ConfigExMessage.INVALID_FOOD_TYPE_EX_MESSAGE);
        }
    }
}
