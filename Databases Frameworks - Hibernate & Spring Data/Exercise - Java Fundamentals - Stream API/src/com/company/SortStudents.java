package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> students = new ArrayList<>();

        String inputLine = reader.readLine();
        while (!inputLine.equals("END")) {
            students.add(inputLine);
            inputLine = reader.readLine();
        }

        students.stream()
                .sorted(Comparator.comparing(x -> x.toString().split(" ")[1]) //by last name in ascending
                   .thenComparing((x, y) -> y.toString().split(" ")[0].compareTo(x.toString().split(" ")[0]))) //then by first name in descending order.
                .forEach(System.out::println);
    }
}

/* Input for try :
Sara Gibson
Andrew Gibson
Craig Ellis
Steven Cole
Andrew Ellis
END

-- -- OUTPUT -- --
    Steven Cole
    Craig Ellis
    Andrew Ellis
    Sara Gibson
    Andrew Gibson
 */