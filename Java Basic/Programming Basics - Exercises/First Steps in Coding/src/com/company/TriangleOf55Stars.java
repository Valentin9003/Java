package com.company;

public class TriangleOf55Stars {
    public static void main(String[] args) {

        for (int line=0; line<10; line++) {
            for (int symbol=0; symbol<=line; symbol++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
