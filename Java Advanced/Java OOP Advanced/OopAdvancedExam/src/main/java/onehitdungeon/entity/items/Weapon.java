package onehitdungeon.entity.items;

import onehitdungeon.interfaces.WeaponItem;

public class Weapon extends BaseItem implements WeaponItem {

    public Weapon(int battlePower, double priceForUpgrade) {
        super(battlePower, priceForUpgrade);
    }
}
