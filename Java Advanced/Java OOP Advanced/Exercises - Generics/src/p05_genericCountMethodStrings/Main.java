package p05_genericCountMethodStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Box<String>> boxes = new ArrayList<>();

        int numberOfStrings = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfStrings; i++) {
            String line = reader.readLine();
            boxes.add(new Box<>(line));
        }

        String element = reader.readLine();

        System.out.println(countOfGreaterElements(boxes, element));
    }

    private static <T extends Comparable<T>> long countOfGreaterElements(List<Box<T>> list, T element) {
        return list.stream()
                .filter(e -> e.compareTo(new Box<>(element)) > 0)
                .count();
    }
}
