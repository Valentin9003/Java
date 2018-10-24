package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {

    private static final String END_PROGRAM = "HARVEST";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!END_PROGRAM.equalsIgnoreCase(line = reader.readLine())) {
            Field[] fields = harvestFieldsByGivenModifier(line);
            printFields(fields);
        }
    }

    private static void printFields(Field[] fields) {
        Arrays.stream(fields)
                .forEach(field -> {
                    System.out.println(String.format("%s %s %s",
                            Modifier.toString(field.getModifiers()),
                            field.getType().getSimpleName(),
                            field.getName()));
                });
    }

    private static Field[] harvestFieldsByGivenModifier(String modifier) {
        Class<?> clazz = RichSoilLand.class;
        Field[] fields = null;
        switch (modifier) {
            case "private":
                fields = Arrays.stream(clazz.getDeclaredFields())
                        .filter(field -> Modifier.isPrivate(field.getModifiers()))
                        .toArray(Field[]::new);
                break;
            case "protected":
                fields = Arrays.stream(clazz.getDeclaredFields())
                        .filter(field -> Modifier.isProtected(field.getModifiers()))
                        .toArray(Field[]::new);
                break;
            case "public":
                fields = Arrays.stream(clazz.getDeclaredFields())
                        .filter(field -> Modifier.isPublic(field.getModifiers()))
                        .toArray(Field[]::new);
                break;
            default:
                //Default will be all - print ALL declared fields
                fields = clazz.getDeclaredFields();
                break;
        }

        return fields;
    }
}
