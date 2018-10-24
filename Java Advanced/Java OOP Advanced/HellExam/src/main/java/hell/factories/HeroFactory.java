package hell.factories;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class HeroFactory {

    private static final String PATH = "hell.entities.heroeses.";

    private HeroFactory() {
    }

    public static Hero execute(String[] heroArgs) {
        String name = heroArgs[0];
        String type = heroArgs[1];

        try {
            Class<?> commandClass = Class.forName(PATH + type);
            Constructor<?> declaredConstructor = commandClass.getDeclaredConstructor(String.class, Inventory.class);
            Inventory inventory = new HeroInventory();
            return (Hero) declaredConstructor.newInstance(name, inventory);

        } catch (ClassNotFoundException
                | NoSuchMethodException
                | InstantiationException
                | IllegalAccessException
                | InvocationTargetException e) {
            return null;
        }
    }
}
