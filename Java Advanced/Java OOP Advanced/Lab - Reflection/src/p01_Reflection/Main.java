package p01_Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<Reflection> reflectionClass = Reflection.class;

        System.out.println(reflectionClass);
        System.out.println(reflectionClass.getSuperclass());

        Class[] interfaces = reflectionClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Reflection reflection = Reflection.class.getDeclaredConstructor().newInstance();
        System.out.println(reflection);
    }
}
