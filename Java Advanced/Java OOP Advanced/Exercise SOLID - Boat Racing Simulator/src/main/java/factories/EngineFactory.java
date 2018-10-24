package factories;

import contracts.Engine;
import enumeration.EngineType;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class EngineFactory {

    private static final String ENGINES_PATH = "models.engines.";
    private static final String ENGINE_NAME_SUFFIX = "Engine";

    private EngineFactory() {
    }

    public static Engine create(String model, int horsepower, int displacement, EngineType engineType) {
        String engineClassName = engineType.toString() + ENGINE_NAME_SUFFIX;

        try {
            Class<?> engineClass = Class.forName(ENGINES_PATH + engineClassName);
            Constructor<?> engineConstructor =
                    engineClass.getDeclaredConstructor(String.class, int.class, int.class);

            return  (Engine) engineConstructor.newInstance(model, horsepower, displacement);

        } catch (ClassNotFoundException
                | NoSuchMethodException
                | IllegalAccessException
                | InvocationTargetException
                | InstantiationException e) {
//            e.printStackTrace();
            return null;
        }
    }
}
