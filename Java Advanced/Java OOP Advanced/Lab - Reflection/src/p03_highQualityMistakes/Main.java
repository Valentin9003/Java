package p03_highQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Set<Method> mistakesGetters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> mistakesSetters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Field> mistakesFields = new TreeSet<>(Comparator.comparing(Field::getName));

        Class<?> refClass = Reflection.class;

        Field[] refFields = refClass.getDeclaredFields();
        for (Field field : refFields) {
            if (!Modifier.isPrivate(field.getModifiers())) {
                mistakesFields.add(field);
            }
        }

        Method[] refMethods = refClass.getDeclaredMethods();
        for (Method method : refMethods) {
            if (isGetter(method)) {
               if (!Modifier.isPublic(method.getModifiers())) {
                   mistakesGetters.add(method);
                }
            } else if (isSetter(method)) {
                if (!Modifier.isPrivate(method.getModifiers())) {
                    mistakesSetters.add(method);
                }
            }
        }

        printAllMistakesResult(mistakesGetters, mistakesSetters, mistakesFields);
    }

    private static void printAllMistakesResult(Set<Method> mistakesGetters, Set<Method> mistakesSetters, Set<Field> mistakesFields) {
        mistakesFields.forEach(field -> {
            System.out.println(String.format("%s must be private!", field.getName()));
        });

        mistakesGetters.forEach(method -> {
            System.out.println(String.format("%s have to be public!", method.getName()));
        });

        mistakesSetters.forEach(method -> {
            System.out.println(String.format("%s have to be private!", method.getName()));
        });
    }

    private static boolean isSetter(Method method) {
        return method.getName().startsWith("set") &&
                    method.getReturnType().equals(void.class) &&
                        method.getParameterCount() == 1;
    }

    private static boolean isGetter(Method method) {
        return method.getName().startsWith("get") &&
                !method.getReturnType().equals(void.class) &&
                    method.getParameterCount() == 0;
    }
}
