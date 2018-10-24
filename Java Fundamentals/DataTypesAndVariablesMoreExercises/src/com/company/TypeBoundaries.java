package com.company;

import java.util.Scanner;
import com.sun.jmx.snmp.SnmpUnsignedInt;

public class TypeBoundaries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numberType = scanner.nextLine().toLowerCase();

        switch (numberType) {
            case "int":
                System.out.println(Integer.MAX_VALUE);
                System.out.println(Integer.MIN_VALUE);
                break;
            case "uint":
                System.out.println(SnmpUnsignedInt.MAX_VALUE);
                System.out.println(0);
                break;
            case "long":
                System.out.println(Long.MAX_VALUE);
                System.out.println(Long.MIN_VALUE);
                break;
            case "byte":
                System.out.println(Byte.MAX_VALUE * 2 + 1);
                System.out.println(0);
                break;
            case "sbyte":
                System.out.println(Byte.MAX_VALUE);
                System.out.println(Byte.MIN_VALUE);
                break;
        }
    }
}
