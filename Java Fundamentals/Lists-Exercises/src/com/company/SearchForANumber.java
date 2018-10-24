package com.company;

import java.util.Scanner;
import java.util.*;

public class SearchForANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Reading new String List split by "\\s+" and convert it to new Integer List
        ArrayList<String> myList = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));
        ArrayList<Integer> myIntList = new ArrayList<>();
        for(String s : myList) {
            myIntList.add(Integer.valueOf(s));
        }

        //Reading String Array and convert it to int Array;
        String[] secondRow = scanner.nextLine().split(" ");
        int[] intArray = Arrays.stream(secondRow).mapToInt(i -> Integer.parseInt(i)).toArray();

        //create new Integer List and fill it with all elements from ArrayList, (from element, to element)
        ArrayList<Integer> resultList = new ArrayList<Integer>(myIntList.subList(0, intArray[0]));

        //clears everything from index (inclusive) to  intArray[1]
        resultList.subList(0, intArray[1]).clear();

        //searching for am element int the List with .contains -> returns boolean. If e true -> print "YES!", else -> print "NO!"
        if (resultList.contains(intArray[2])) {
            System.out.println("YES!");
        } else {
            System.out.println("NO!");
        }

    }
}
