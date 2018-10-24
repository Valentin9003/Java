package com.company;

import java.util.Scanner;

public class PracticeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte firstNumber = Byte.parseByte(scanner.nextLine());
        short secondNumber = Short.parseShort(scanner.nextLine());
        short thirdNumber = Short.parseShort(scanner.nextLine());
        int fourtNumber = Integer.parseInt(scanner.nextLine());
        long fiveNumber = Long.parseLong(scanner.nextLine());
        int sixNumber = Integer.parseInt(scanner.nextLine());
        long sevenNumber = Long.parseLong(scanner.nextLine());

        System.out.println(firstNumber);
        System.out.println(secondNumber);
        System.out.println(thirdNumber);
        System.out.println(fourtNumber);
        System.out.println(fiveNumber);
        System.out.println(sixNumber);
        System.out.println(sevenNumber);
    }
}
