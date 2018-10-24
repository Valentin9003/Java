package p02_gettersAndSetters;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Set<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));

        Class<?> refClass = Reflection.class;

        Method[] refMethods = refClass.getDeclaredMethods();
        for (Method method : refMethods) {
            if (method.getName().startsWith("set") &&
                    method.getReturnType().equals(void.class) &&
                        method.getParameterCount() == 1) {
                setters.add(method);
            } else if (method.getName().startsWith("get") &&
                    !method.getReturnType().equals(void.class) &&
                        method.getParameterCount() == 0) {
                getters.add(method);
            }
        }

        getters.forEach(getMethod -> {
            System.out.println(String.format("%s will return %s",
                    getMethod.getName(),
                    getMethod.getReturnType().getSimpleName()));
        });

        setters.forEach(setMethod -> {
            System.out.println(String.format("%s and will set field of %s",
                    setMethod.getName(),
                    setMethod.getReturnType().getSimpleName()));
        });
    }
}
