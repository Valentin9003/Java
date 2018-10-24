package com.company;

import java.util.Scanner;
import java.util.*;

public class SplitByWordCasing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> myList = new ArrayList<String>(Arrays.asList(scanner.nextLine().split("[\\s\\[\\]\\\\:,.;!()/]+")));
        ArrayList<String> lowerCase = new ArrayList<>();
        ArrayList<String> upperCase = new ArrayList<>();
        ArrayList<String> mixedCase = new ArrayList<>();

        for (int i = 0; i < myList.size(); i++) {
            int countLowerCase = 0;
            int countUpperCase = 0;

            for (int j = 0; j < myList.get(i).length(); j++) {
                if (Character.isUpperCase(myList.get(i).charAt(j))) {
                    countUpperCase++;
                } else {
                    countLowerCase++;
                }
            }

            boolean isNumber = true;
            try {
                Integer.parseInt(myList.get(i));
            } catch(NumberFormatException e) {
                isNumber = false;
            }

            if (isNumber) {
                mixedCase.add(myList.get(i));
            } else if (countLowerCase > 0 && countUpperCase > 0) {
                mixedCase.add(myList.get(i));
            } else if (countLowerCase == 0 && countUpperCase > 0) {
                upperCase.add(myList.get(i));
            } else {
                lowerCase.add(myList.get(i));
            }

        }
        
        System.out.print("Lower-case: " + String.join(", ", lowerCase));
        System.out.println();
        System.out.print("Mixed-case: " + String.join(", ", mixedCase));
        System.out.println();
        System.out.print("Upper-case: " + String.join(", ", upperCase));
    }
}

// Learn programming at SoftUni: Java, PHP, JS, HTML 5, CSS, Web, C#, SQL, databases, AJAX, etc.
