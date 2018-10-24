package factories;

import interfaces.Behavior;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BehaviorFactory {

    private static final String BEHAVIOR_PATH = "models.behavors.";

    public static Behavior create(String behaviorType) {

        try {
            Class<?> behaviorClass = Class.forName(BEHAVIOR_PATH + behaviorType);
            Constructor<?> constructor = behaviorClass.getDeclaredConstructor();

            return  (Behavior) constructor.newInstance();
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
