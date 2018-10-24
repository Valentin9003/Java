package com.company;

import java.util.Scanner;

public class NumbersFrom0To100Text {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        String[] shortName = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"};
        String[] combName = new String[]{"twen", "thir", "four", "fif", "six", "seven", "eigh", "nine"};

        if (number < 0 || number > 100) {
            System.out.println("invalid number");
        }
        else if (number < 13) {
            System.out.println(shortName[number]);
        }
        else if (number >= 13 && number < 20) {
            number = number % 10 - 2;
            System.out.println(combName[number] + "teen");
        }
        else if (number < 100) {
            if (number / 10 == 4 && number % 10 == 0) {
                System.out.println("forty");
            }
            else if ( number / 10 == 4 && number % 10 != 0 ) {
                number = number % 10;
                System.out.println("forty" + " " + shortName[number]);
            }
            else if (number - ((number / 10)*10) == 0) {
                number = number / 10 - 2;
                System.out.println(combName[number] + "ty");
            }
            else {
                int desetici = number / 10 -2;
                int edinici = number % 10;
                System.out.println(combName[desetici] + "ty" + " " + shortName[edinici]);
            }

        } else if (number == 100) {
            System.out.println("one hundred");
        }
    }
}
