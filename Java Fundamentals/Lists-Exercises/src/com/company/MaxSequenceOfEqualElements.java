package com.company;

import java.util.Scanner;
import java.util.*;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> myList = new ArrayList<String>(Arrays.asList(scanner.nextLine().split("\\s+")));
        ArrayList<Integer> myIntList = new ArrayList<Integer>();

        for(String s : myList) {
            myIntList.add(Integer.valueOf(s));
        }

        int number = 0;
        int counter = 0;
        for (int i = 0; i < myIntList.size() ; i++) {
            int curentNum =myIntList.get(i);
            int curentCounter = 0;

            for (int j = 0; j < myIntList.size(); j++) {
                if (myIntList.get(i) == myIntList.get(j)) {
                    curentCounter++;
                }
            }

            if (curentCounter > counter) {
                number = curentNum;
                counter = curentCounter;
            }
        }

        for (int i = 0; i < counter; i++) {
            System.out.print(number + " ");
        }
    }
}
