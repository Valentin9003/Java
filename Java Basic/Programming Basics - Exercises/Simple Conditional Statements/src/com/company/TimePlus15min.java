package com.company;

import java.util.Scanner;

public class TimePlus15min {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int h = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());

        int min = h * 60 + m + 15;
        int hResult = min / 60;
        int mResult = min % 60;

        if (hResult > 23) {
            hResult = hResult - 24;

            if (mResult >= 60) {
                hResult += mResult / 60;
                mResult = mResult % 60;

                if (mResult < 10) {
                    System.out.printf(hResult + ":0%d", mResult);
                } else {
                    System.out.println(hResult + ":" + mResult);
                }
            } else {
                if (mResult < 10) {
                    System.out.printf(hResult + ":0%d", mResult);
                } else {
                    System.out.println(hResult + ":" + mResult);
                }
            }

        } else         if (hResult <= 23) {

            if (mResult >= 60) {
                hResult += mResult / 60;
                mResult = mResult % 60;

                if (mResult < 10) {
                    System.out.printf(hResult + ":0%d", mResult);
                } else {
                    System.out.println(hResult + ":" + mResult);
                }
            } else {
                if (mResult < 10) {
                    System.out.printf(hResult + ":0%d", mResult);
                } else {
                    System.out.println(hResult + ":" + mResult);
                }
            }

        }
    }
}
