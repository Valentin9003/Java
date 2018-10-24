package com.company;

import java.util.Scanner;

public class LastKNumbersSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());

        long[] arraySeq = new long[n];

        arraySeq[0] = 1;

        for (int i = 1; i < arraySeq.length ; i++) {

            int start = Math.max(0, i - k);
            int end = i - 1;
            long sum = 0;

            for (int prev = start; prev <= end; prev++)
            {
                sum += arraySeq[prev];
            }
            arraySeq[i] = sum;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arraySeq[i] + " ");
        }
    }
}
