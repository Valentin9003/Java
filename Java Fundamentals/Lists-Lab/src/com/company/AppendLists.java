package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AppendLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] myArr = scanner.nextLine().split("\\|");
        ArrayList<String> myList = new ArrayList<>();

        for (int i = 0; i < myArr.length ; i++) {
            myList.add(myArr[i]);
        }

        Collections.reverse(myList);

        System.out.println(myList);
    }
}
