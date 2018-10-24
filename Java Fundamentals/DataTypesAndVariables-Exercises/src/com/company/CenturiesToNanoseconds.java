package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class CenturiesToNanoseconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger thousand = new BigInteger("1000");
        BigInteger sixty = new BigInteger("60");

        byte centuries = scanner.nextByte();
        int years = centuries * 100;
        int days = (int)(years * 365.2422);
        int hours = days * 24;
        long minutes = hours * 60;

        BigInteger seconds = BigInteger.valueOf(minutes).multiply(sixty);
        BigInteger miliseconds = seconds.multiply(thousand);
        BigInteger microseconds = miliseconds.multiply(thousand);
        BigInteger nanoseconds = microseconds.multiply(thousand);


        System.out.println(String.format("%s centuries = %s years = %s days = %s hours = %s minutes = %s seconds = %s milliseconds = %s microseconds = %s nanoseconds",
                centuries, years, days, hours, minutes, seconds, miliseconds, microseconds, nanoseconds ));
    }
}
