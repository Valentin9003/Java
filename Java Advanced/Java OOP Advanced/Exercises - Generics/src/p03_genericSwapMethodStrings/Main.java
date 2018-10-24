package p03_genericSwapMethodStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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

        int[] indexesArr =
                Arrays.stream(reader.readLine()
                        .split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        swap(boxes, indexesArr);

        boxes.forEach(System.out::println);
    }

    private static <T> void swap(List<Box<T>> boxes, int[] indexesArr) {
        int firstIndex = indexesArr[0];
        int secondIndex = indexesArr[1];

        Box<T> tempBox = boxes.get(firstIndex);
        boxes.set(firstIndex, boxes.get(secondIndex));
        boxes.set(secondIndex, tempBox);
    }
}
