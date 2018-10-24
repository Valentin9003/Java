package com.company;

import java.util.Scanner;
import java.util.*;

public class CountNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");
        int[] intArray = Arrays.stream(arr).mapToInt(i -> Integer.parseInt(i)).toArray();
                
        Arrays.sort(intArray);

        int index = 0;
        int curnum;
        int count;
        
        while (index < intArray.length ){
            curnum = intArray[index];
            count = 0;

            for (; index < intArray.length && curnum == intArray[index]; index++, count++);

            System.out.println(curnum + " -> " + count);
        }
    }
}
