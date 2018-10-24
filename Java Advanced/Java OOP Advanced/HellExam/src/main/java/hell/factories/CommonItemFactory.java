package hell.factories;

import hell.entities.items.CommonItem;
import hell.interfaces.Item;

public final class CommonItemFactory {

    private CommonItemFactory() {
    }

    public static Item execute(String[] itemArgs) {
        String name = itemArgs[0];
        int strengthBonus = Integer.parseInt(itemArgs[2]);
        int agilityBonus = Integer.parseInt(itemArgs[3]);
        int intelligenceBonus = Integer.parseInt(itemArgs[4]);
        int hitpointsBonus = Integer.parseInt(itemArgs[5]);
        int damageBonus = Integer.parseInt(itemArgs[6]);

        return new CommonItem(
                name,
                strengthBonus,
                agilityBonus,
                intelligenceBonus,
                hitpointsBonus,
                damageBonus);
    }
}
