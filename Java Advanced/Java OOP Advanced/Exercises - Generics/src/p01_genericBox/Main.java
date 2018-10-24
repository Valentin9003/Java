package p01_genericBox;

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
            String value = reader.readLine();
            boxes.add(new Box<>(value));
        }

        boxes.forEach(System.out::println);
    }
}
