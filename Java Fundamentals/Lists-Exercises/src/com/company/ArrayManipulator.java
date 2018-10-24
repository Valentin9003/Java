package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ArrayManipulator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());

        //will read List<Integers> with for loop bc is a lot more fast than stream
        List<Integer> numbers = new ArrayList<>();
        String[] nums = reader.readLine().split("\\s+");
        for (String num : nums) {
            numbers.add(Integer.parseInt(num));
        }

        //Reading command
        String command = reader.readLine();

        // while is true -> do .......
        while (!"print".equals(command)) {
            String[] tokens = command.split(" ");

            //Switch by command (token[0]) *// first element in token array //*
            switch (tokens[0]) {
                case "add":
                    int index = Integer.parseInt(tokens[1]);
                    int element = Integer.valueOf(tokens[2]);
                    //Add element on Index
                    numbers.add(index, element);
                    break;
                case "addMany":
                    index = Integer.parseInt(tokens[1]);
                    List<Integer> arrList = Arrays.stream(tokens).skip(2).map(Integer::valueOf).collect(Collectors.toList());
                    //add all elements from arrList into numbers
                    numbers.addAll(index, arrList);
                    break;
                case "contains":
                    element = Integer.parseInt(tokens[1]);
                    //Get the Index of element in collection and print it
                    System.out.println(numbers.indexOf(element));
                    break;
                case "remove":
                    index = Integer.parseInt(tokens[1]);
                    // Remove number by Index
                    numbers.remove(index);
                    break;
                case "shift":
                    int position = Integer.parseInt(tokens[1]);
                    // this .rotate by def rotate the collection from Left to Right,
                    //bc that we make the position to be with negative value (position * -1), and then will rotate from Right to Left
                    Collections.rotate(numbers, position * - 1);
                    break;
                case "sumPairs":
                    List<Integer> temp = new ArrayList<>();
                    for (int i = 1; i < numbers.size(); i+=2) {
                        int first = numbers.get(i);
                        int second = numbers.get(i - 1);
                        temp.add(first + second);
                    }

                    //This will sum all positive numbers, because of that if numbers.size() is != 0, we will lose last number
                    //so, make if() and if is true add last number from numbers in to tempList

                    if (numbers.size() % 2 != 0) {
                        temp.add(numbers.get(numbers.size() - 1));
                    }

                    numbers.clear();
                    numbers.addAll(temp);
            }
            // until While is true -> read again command;
            command = reader.readLine();
        }

        System.out.println(numbers);
    }
}
