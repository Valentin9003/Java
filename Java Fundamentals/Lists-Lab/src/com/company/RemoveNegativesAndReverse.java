package com.company;

import java.util.*;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> myList = new ArrayList<String>(Arrays.asList(scanner.nextLine().split("\\s+")));
        ArrayList<Integer> myIntList = new ArrayList<Integer>();
        ArrayList<Integer> myPositiveIntList = new ArrayList<Integer>();
        for(String s : myList) {
            myIntList.add(Integer.valueOf(s));
        }


        for (int i = 0; i < myIntList.size(); i++) {
            if (myIntList.get(i) > 0 )
                myPositiveIntList.add(myIntList.get(i));
        }

        Collections.reverse(myPositiveIntList);

        if (myPositiveIntList.size() > 0) {
            System.out.println(myPositiveIntList);
        } else {
            System.out.println("empty");
        }

    }

}
