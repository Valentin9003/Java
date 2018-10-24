package com.company;

import java.util.Scanner;
import java.util.*;

public class SquareNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> myList = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));
                ArrayList<Integer> myIntList = new ArrayList<>();

                for(String s : myList) {
                    myIntList.add(Integer.valueOf(s));
                }

        ArrayList<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < myIntList.size(); i++) {
            int num = myIntList.get(i);
            double sum = Math.sqrt(num);

            if (sum == (int)sum) {
                resultList.add(myIntList.get(i));
            }
        }

        Collections.sort(resultList);
        Collections.reverse(resultList);

        for (int i = 0; i < resultList.size() ; i++)
                {
                    System.out.print(resultList.get(i) + " ");
                }
    }
}
