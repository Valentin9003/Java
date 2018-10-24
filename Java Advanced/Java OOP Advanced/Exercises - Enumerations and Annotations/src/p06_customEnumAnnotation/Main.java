package p06_customEnumAnnotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String category = reader.readLine();

        switch (category) {
            case "Rank":
                getClassAnnotationInfo(CardRank.class);
                break;
            case "Suit":
                getClassAnnotationInfo(CardSuits.class);
                break;
        }
    }

    private static void getClassAnnotationInfo(Class<?> enumClass) {
        if (enumClass.isAnnotationPresent(CustomEnumAnnotation.class)) {
            CustomEnumAnnotation annotation = enumClass.getAnnotation(CustomEnumAnnotation.class);

            System.out.println(String.format("Type = %s, Description = %s",
                    annotation.type(),
                    annotation.description()));
        }
    }
}
