package onehitdungeon.factories;

import onehitdungeon.entity.items.Armor;
import onehitdungeon.interfaces.ArmorItem;

public class ArmorFactory {

    public static ArmorItem create(int battlePower, double price) {
        return new Armor(battlePower, price);
    }
}
