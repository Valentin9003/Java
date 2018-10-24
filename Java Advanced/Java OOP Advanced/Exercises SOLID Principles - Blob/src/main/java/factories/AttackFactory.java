package factories;

import interfaces.Attack;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AttackFactory {

    private static final String ATTACK_PATH = "models.attacks.";

    public static Attack create(String attackType) {
        try {
            Class<?> behaviorClass = Class.forName(ATTACK_PATH + attackType);
            Constructor<?> constructor = behaviorClass.getDeclaredConstructor();

            return  (Attack)constructor.newInstance();
        } catch (ClassNotFoundException
                | NoSuchMethodException
                | InstantiationException
                | IllegalAccessException
                | InvocationTargetException e) {
//            e.printStackTrace();
            return null;
        }
    }
}
