package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ManipulateArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> myList = new ArrayList<String>(Arrays.asList(reader.readLine().split("\\s+")));
        int commandsNumber = Integer.parseInt(reader.readLine());

        for (int i = 0; i < commandsNumber ; i++) {
            String[] commands = reader.readLine().split(" ");

            switch (commands[0]){
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

                    myList.set(index, newElement);
            }
        }
        System.out.println(String.join(", ", myList));
    }
}
