package onehitdungeon.entity.items;

import onehitdungeon.interfaces.ArmorItem;

public class Armor extends BaseItem implements ArmorItem {

    public Armor(int battlePower, double priceForUpgrade) {
        super(battlePower, priceForUpgrade);
    }
}
