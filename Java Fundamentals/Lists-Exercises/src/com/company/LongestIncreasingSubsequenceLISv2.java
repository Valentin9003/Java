package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LongestIncreasingSubsequenceLISv2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringArr = scanner.nextLine().split(" ");
        int arr[] = new int[stringArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(stringArr[i]);
        }

        int T[] = new int[arr.length];
        int actualSolution[] = new int[arr.length];
        for(int i=0; i < arr.length; i++){
            T[i] = 1;
            actualSolution[i] = i;
        }

        for(int i=1; i < arr.length; i++){
            for(int j=0; j < i; j++){
                if(arr[i] > arr[j]){
                    if(T[j] + 1 > T[i]){
                        T[i] = T[j] + 1;
                        //set the actualSolution to point to guy before me
                        actualSolution[i] = j;
                    }
                }
            }
        }

        //find the index of max number in T
        int maxIndex = 0;
        for(int i=0; i < T.length; i++){
            if(T[i] > T[maxIndex]){
                maxIndex = i;
            }
        }

        ArrayList<Integer> answerList = new ArrayList<>();
        //lets add the actual solution elements to a List
        int t = maxIndex;
        int newT = maxIndex;
        do{
            t = newT;
            answerList.add(arr[t]);
            newT = actualSolution[t];
        }while(t != newT);

        //reverse the list
        Collections.reverse(answerList);

        //lets print the actual solution
        for (int i = 0; i <answerList.size(); i++) {
            System.out.print(answerList.get(i) + " ");
        }
    }
}
