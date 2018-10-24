package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SafeManipulation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> myList = new ArrayList<String>(Arrays.asList(reader.readLine().split("\\s")));

        String[] commands = reader.readLine().split(" ");

        while (!commands[0].equals("END")) {

            if (commands[0].equals("Reverse") || commands[0].equals("Distinct") || commands[0].equals("Replace")) {

                switch (commands[0]) {
                    case "Reverse":
                        Collections.reverse(myList);
                        break;
                    case "Distinct":
                        List<String> newList = (myList.stream().distinct().collect(Collectors.toList()));
                        myList.clear();
                        myList.addAll(newList);
                        break;
                    case "Replace":
                        int index = Integer.parseInt(commands[1]);
                        String newElement = commands[2];

                        if (index >= 0 && index < myList.size()) {
                            myList.set(index, newElement);
                        } else {
                            System.out.println("Invalid input!");
                        }
                }
            } else {
                System.out.println("Invalid input!");
            }
        commands = reader.readLine().split(" ");
        }

        System.out.println(String.join(", ", myList));
    }
}
