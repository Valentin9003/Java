package com.company;

import java.util.Scanner;

public class FoldAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(" ");
        int[] inputArray = StringToIntArr(inputArr);

        int[] firstArr = FirstArray(inputArray);
        int[] middleArr = MiddleArray(inputArray);
        int[] lastArr = SecondArray(inputArray);
        int[] combFirstAndSecArray = RotateAndCombinationInArray(firstArr, lastArr);
        int[] middlePlusComboArr = MiddlePlusComboArray(middleArr, combFirstAndSecArray);


        for (int i = 0; i < middlePlusComboArr.length ; i++) {
            System.out.print(middlePlusComboArr[i] + " ");
        }

    }

    private static int[] MiddlePlusComboArray(int[] middleArr, int[] combFirstAndSecArray) {
        int[] resultArr = new int[middleArr.length];

        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = middleArr[i] + combFirstAndSecArray[i];
        }

        return resultArr;
    }

    private static int[] RotateAndCombinationInArray(int[] firstArr, int[] lastArr) {
        int[] combFirstAndSecArray = new int[firstArr.length + lastArr.length];

//        int[] rotatedArr = new int[firstArr.length];
//        int[] rotatedArr2 = new int[lastArr.length];

        int left = 0;
        int right = firstArr.length - 1;
        while(left < right){
            int temp = firstArr[left];
            firstArr[left] = firstArr[right];
            firstArr[right] = temp;
            left++;
            right--;
        }
        int left2 = 0;
        int right2 = lastArr.length - 1;
        while(left2 < right2){
            int temp = lastArr[left2];
            lastArr[left2] = lastArr[right2];
            lastArr[right2] = temp;
            left2++;
            right2--;
        }

//        for (int j = 0; j < rotatedArr.length; j++) {
//            rotatedArr[(j + 1) % firstArr.length] = firstArr[j];
//        }
//        for (int j = 0; j < rotatedArr2.length ; j++) {
//            rotatedArr2[(j + 1) % lastArr.length] = lastArr[j];
//        }

//        System.arraycopy(rotatedArr, 0, combFirstAndSecArray, 0, rotatedArr.length);
//        System.arraycopy(rotatedArr2, 0, combFirstAndSecArray, rotatedArr.length, rotatedArr2.length);

        int count=0;
        for(int i=0; i<firstArr.length; i++) {
            combFirstAndSecArray[i]=firstArr[i];
            count++;
        }
        for(int j=0;j<lastArr.length;j++) {
            combFirstAndSecArray[count++]=lastArr[j];
        }


        return combFirstAndSecArray;
    }

    private static int[] MiddleArray(int[] inputArray) {
        int[] middleArr = new int[(inputArray.length + 1) /2];

        for (int i = 0; i < middleArr.length ; i++) {
            middleArr[i] = inputArray[i + (inputArray.length + 1)/4];
        }
        return middleArr;
    }

    private static int[] SecondArray(int[] inputArray) {
        int[] secondArr = new int[(inputArray.length + 1) /4];

        for (int i = 0; i < secondArr.length ; i++) {
            secondArr[i] = inputArray[i + secondArr.length * 3];
        }
        return secondArr;
    }

    private static int[] FirstArray(int[] inputArray) {
        int[] firstArr = new int[(inputArray.length + 1) /4];

        for (int i = 0; i < firstArr.length ; i++) {
            firstArr[i] = inputArray[i];
        }
        return firstArr;
    }

    private static int[] StringToIntArr(String[] inputArr) {
        int[] inputArray = new int[inputArr.length];

        for (int i = 0; i < inputArray.length ; i++) {
            inputArray[i] = Integer.parseInt(inputArr[i]);
        }
        return inputArray;
    }
}
