package com.company;

import java.util.Scanner;
import java.util.*;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> myList = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));
        ArrayList<Integer> myIntList = new ArrayList<>();
         for(String s : myList) {
             myIntList.add(Integer.valueOf(s));
         }

        ArrayList<String> command = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));

         while (!command.get(0).contains("Odd") && !command.get(0).contains("Even")) {

             if (command.get(0).contains("Delete"))
             {
                 int element = Integer.parseInt(command.get(1));

                 myIntList.removeAll(Arrays.asList(element));
             }
             else if (command.get(0).contains("Insert"))
             {
                 int element = Integer.parseInt(command.get(1));
                 int position = Integer.parseInt(command.get(2));

                 myIntList.add(position, element);
             }

             command = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));
         }

         if (command.get(0).contains("Odd")) {
             for (int i = 0; i < myIntList.size() ; i++) {
                 if (myIntList.get(i) % 2 != 0) {
                     System.out.print(myIntList.get(i) + " ");
                 }
             }
         } else {
             for (int i = 0; i < myIntList.size() ; i++) {
                 if (myIntList.get(i) % 2 == 0) {
                     System.out.print(myIntList.get(i) + " ");
                 }
             }
         }
    }
}
