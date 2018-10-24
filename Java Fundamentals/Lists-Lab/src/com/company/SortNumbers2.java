package com.company;

import java.util.Scanner;
import java.util.*;

public class SortNumbers2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> myList = new ArrayList<String>(Arrays.asList(scanner.nextLine().split("\\s+")));
                ArrayList<Integer> myIntList = new ArrayList<Integer>();

                for(String s : myList) {
                    myIntList.add(Integer.valueOf(s));
                }

                Collections.sort(myIntList);

                ArrayList<String> printList = new ArrayList<>();

        for (Integer s : myIntList) {
            printList.add(String.valueOf(s));
        }

        System.out.println(String.join(" <= ", printList));
    }
}
