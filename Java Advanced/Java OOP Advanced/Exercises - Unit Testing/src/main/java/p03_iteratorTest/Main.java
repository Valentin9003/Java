package p03_iteratorTest;

import javax.naming.OperationNotSupportedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ListIterator listIterator = null;

        String line;
        while (!"END".equalsIgnoreCase(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");

            switch (tokens[0]) {
                case "Create":
                    List<String> strings =
                            Arrays.stream(tokens)
                                    .skip(1)
                                    .collect(Collectors.toList());
                    try {
                        listIterator = new ListIterator(strings);
                    } catch (OperationNotSupportedException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Move":
                    System.out.println(listIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listIterator.hasNext());
                    break;
                case "Print":
                    try {
                        System.out.println(listIterator.print());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}
