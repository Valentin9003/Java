package onehitdungeon.factories;

import onehitdungeon.interfaces.ArmorItem;
import onehitdungeon.interfaces.Hero;
import onehitdungeon.interfaces.OffhandItem;
import onehitdungeon.interfaces.WeaponItem;

import java.lang.reflect.InvocationTargetException;

import static onehitdungeon.constants.Config.*;

public class HeroFactory {

    private static final String HEROES_PATH = "onehitdungeon.entity.heroes.";
    private static final String CLASS_SUFFIX = "Hero";

    public static Hero create(String type, String name) {
        WeaponItem weapon = null;
        ArmorItem armor = null;
        OffhandItem offhand = null;

        switch (type) {
            case "Paladin":
                weapon = WeaponFactory.create(PALADIN_WEAPON_BP, PALADIN_WEAPON_PRICE);
                armor = ArmorFactory.create(PALADIN_ARMOR_BP, PALADIN_ARMOR_PRICE);
                offhand = OffhandFactory.create(PALADIN_OFFHAND_BP, PALADIN_OFFHAND_PRICE);
                break;
            case "Mage":
                weapon = WeaponFactory.create(MAGE_WEAPON_BP, MAGE_WEAPON_PRICE);
                armor = ArmorFactory.create(MAGE_ARMOR_BP, MAGE_ARMOR_PRICE);
                offhand = OffhandFactory.create(MAGE_OFFHAND_BP, MAGE_OFFHAND_PRICE);
                break;
        }

        try {
            return  (Hero) Class.forName(HEROES_PATH + type + CLASS_SUFFIX)
                    .getDeclaredConstructor(String.class, WeaponItem.class, OffhandItem.class, ArmorItem.class)
                    .newInstance(name, weapon, offhand, armor);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException e) {
            return null;
        }
    }
}
