package onehitdungeon.factories;

import onehitdungeon.entity.items.Offhand;
import onehitdungeon.interfaces.OffhandItem;

public class OffhandFactory {

    public static OffhandItem create(int battlePower, double price) {
        return new Offhand(battlePower, price);
    }
}
