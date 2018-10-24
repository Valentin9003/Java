package hell.factories;

import hell.entities.items.RecipeItem;
import hell.interfaces.Recipe;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class RecipeFactory {

    private RecipeFactory() {
    }

    public static Recipe execute(String[] itemArgs) {
        String name = itemArgs[0];
        int strengthBonus = Integer.parseInt(itemArgs[2]);
        int agilityBonus = Integer.parseInt(itemArgs[3]);
        int intelligenceBonus = Integer.parseInt(itemArgs[4]);
        int hitpointsBonus = Integer.parseInt(itemArgs[5]);
        int damageBonus = Integer.parseInt(itemArgs[6]);

        List<String> requiredItems = Arrays.stream(itemArgs).skip(7).collect(Collectors.toList());

        return new RecipeItem(
                name,
                strengthBonus,
                agilityBonus,
                intelligenceBonus,
                hitpointsBonus,
                damageBonus,
                requiredItems);
    }
}
