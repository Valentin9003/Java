package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class VariableInHexFormat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String hex = scanner.nextLine();
        int outPrint = Integer.parseInt(hex.substring(2), 16);

            System.out.println(outPrint);
    }
}
