package p05_codingTracker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Tracker {

    private Tracker() {
    }

    @Author(name = "Pesho")
    public static void printMethodsByAuthor(Class<?> clazz) {
        Map<String, List<String>> methodsByAuthor = new LinkedHashMap<>();

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            Author authorAnnotation = method.getAnnotation(Author.class);
            if (authorAnnotation != null) {
                methodsByAuthor.putIfAbsent(authorAnnotation.name(), new ArrayList<>());
                methodsByAuthor.get(authorAnnotation.name()).add(method.getName());
            }
        }

        methodsByAuthor.forEach((key, value) ->
                System.out.println(
                        String.format("%s: %s",
                                key,
                                String.join(", ", value))));
    }

    @Author(name = "Pesho")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }
}
