package p10_tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Truple> truples = new ArrayList<>();

        String[] tokens = reader.readLine().split("\\s+");
        String fullName = String.format("%s %s", tokens[0], tokens[1]);
        String address = tokens[2];
//        Truple<Truple<String, String>, String> fullNameAddress =
//                new Truple<>(new Truple<>(tokens[0], tokens[1]), tokens[2]);
        truples.add(createTruple(fullName, address));

        tokens = reader.readLine().split("\\s+");
        String name = tokens[0];
        int litersOfBeer = Integer.parseInt(tokens[1]);
        truples.add(createTruple(name, litersOfBeer));

        tokens = reader.readLine().split("\\s+");
        int intNum = Integer.parseInt(tokens[0]);
        double doubleNum = Double.parseDouble(tokens[1]);
        truples.add(createTruple(intNum, doubleNum));

        truples.forEach(System.out::println);
    }

    private static <T, E> Truple<T, E> createTruple(T item1, E item2) {
        return new Truple<>(item1, item2);
    }
}
