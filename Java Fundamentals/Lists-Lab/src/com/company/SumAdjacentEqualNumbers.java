package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> myList = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));
        ArrayList<Integer> myIntList = new ArrayList<>();
        for (String s : myList) {
            myIntList.add(Integer.valueOf(s));
        }

        for (int i = 0; i < myIntList.size() - 1; i++) {

            int firstNumber = myIntList.get(i);
            int secondNumber = myIntList.get(i + 1);

                if (firstNumber == secondNumber)
                {
                    myIntList.set(i, firstNumber + secondNumber);
                    myIntList.remove(i + 1);
                    i -= 2;

                    if (i < -1) // връщаме брояча с една позиция, защото като премахнем елемент, трябва да проверяваме и следващия
                    {
                        i = -1;
                    }
                }
        }

        for (int i = 0; i < myIntList.size() ; i++)
                {
                    System.out.print(myIntList.get(i) + " ");
                }

    }
}
