package p02_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ListyIterator<String> listyIterator = null;

        String line;
        while (!"END".equalsIgnoreCase(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");

            switch (tokens[0]) {
                case "Create":
                    String[] elements = Arrays.stream(tokens).skip(1).toArray(String[]::new);
                    listyIterator = new ListyIterator<>(elements);
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
            }
        }
    }
}
