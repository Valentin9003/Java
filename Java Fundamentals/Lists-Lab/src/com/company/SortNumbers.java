package com.company;

import java.util.Scanner;
import java.util.*;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> myList = new ArrayList<String>(Arrays.asList(scanner.nextLine().split("\\s+")));

        myList.sort((x1, x2) -> x1.compareTo(x2));

        System.out.println(String.join(" <= ", myList));
    }
}
