package factories;

import interfaces.Appender;
import interfaces.Layout;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class AppenderFactory {

    private static final String CLASS_PATH = "models.appenders.";

    protected AppenderFactory() {
    }

    public static Appender create(String appenderType, Layout layout) {
        try {
            Class<?> appenderClass = Class.forName(CLASS_PATH + appenderType);
            Constructor<?> declaredConstructor = appenderClass.getDeclaredConstructor(Layout.class);

            return  (Appender) declaredConstructor.newInstance(layout);
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
