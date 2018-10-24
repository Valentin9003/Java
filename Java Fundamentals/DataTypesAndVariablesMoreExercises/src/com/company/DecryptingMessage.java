package com.company;

import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Byte.parseByte(scanner.nextLine());
        int n = Byte.parseByte(scanner.nextLine());

        char[] messageArr = new char[n];

        for (int i = 0; i < messageArr.length ; i++) {
            messageArr[i] = scanner.nextLine().charAt(0);
        }

        for (int i = 0; i < messageArr.length ; i++) {
            int decript = messageArr[i] + key;

            System.out.print((char) decript);
        }
    }
}
