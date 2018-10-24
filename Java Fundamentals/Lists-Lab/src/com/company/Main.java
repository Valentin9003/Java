package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> myList = new ArrayList<String>(Arrays.asList(scanner.nextLine().split(" ")));

        Collections.sort(myList);     // or myIntList.sort((x1, x2) -> x1.compareTo(x2));
        System.out.println(myList);

        Collections.reverse(myList);
        System.out.println(myList);
    }
}
