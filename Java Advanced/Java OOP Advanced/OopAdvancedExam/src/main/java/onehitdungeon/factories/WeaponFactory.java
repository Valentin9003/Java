package onehitdungeon.factories;

import onehitdungeon.entity.items.Weapon;
import onehitdungeon.interfaces.WeaponItem;

public class WeaponFactory {

    public static WeaponItem create(int battlePower, double price) {
        return new Weapon(battlePower, price);
    }
}
