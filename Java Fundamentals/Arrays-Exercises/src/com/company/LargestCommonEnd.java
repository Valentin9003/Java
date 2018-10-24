package com.company;

import java.util.Scanner;

public class LargestCommonEnd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArray = scanner.nextLine().split(" ");
        String[] secondArray = scanner.nextLine().split(" ");

        int count = (LargestCommon(firstArray, secondArray));
        System.out.println(count);
    }

    private static int LargestCommon(String[] first, String[] second)
        {
            int rightCount = 0;
            int leftCount = 0;
            while (rightCount < first.length && rightCount < second.length)
            {
                if (first[first.length - rightCount - 1].equals(second[second.length - rightCount - 1]))
                {
                    rightCount++;
                }
                else break;
            }

            while (leftCount < first.length && leftCount < second.length)
            {
                if (first[leftCount].equals(second[leftCount]))
                {
                    leftCount++;
                }
                else break;
            }

            if (rightCount > leftCount)
            {
                return rightCount;
            }
            else
            {
                return leftCount;
            }
        }
    }
