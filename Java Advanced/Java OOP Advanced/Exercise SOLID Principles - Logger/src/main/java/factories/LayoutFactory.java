package factories;

import interfaces.Layout;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class LayoutFactory {

    private static final String CLASS_PATH = "models.layouts.";

    protected LayoutFactory() {
    }

    public static Layout create(String layoutType) {
        try {
            Class<?> layoutClass = Class.forName(CLASS_PATH + layoutType);
            Constructor<?> declaredConstructor = layoutClass.getDeclaredConstructor();
            return  (Layout) declaredConstructor.newInstance();
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
