package com.company;

import java.util.Scanner;

public class SMSTyping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCharecters = Integer.parseInt(scanner.nextLine());
        String sms = "";

        for (int i = 1; i <= numberOfCharecters; i++)
        {
            String numForChar = scanner.nextLine();

            sms = sms + TransferTypeNumberToChar(numForChar);
        }
        System.out.println(sms);
    }

    private static String TransferTypeNumberToChar(String numForChar)
    {
        String text = "";

        switch (numForChar.charAt(0)) {
            case '2':
                if (numForChar.length() == 1) {
                    text = text + "a";
                } else if (numForChar.length() == 2) {
                    text = text + "b";
                } else if (numForChar.length() == 3) {
                    text = text + "c";
                }
                break;
            case '3':
                if (numForChar.length() == 1) {
                    text = text + "d";
                } else if (numForChar.length() == 2) {
                    text = text + "e";
                } else if (numForChar.length() == 3) {
                    text = text + "f";
                }
                break;
            case '4':
                if (numForChar.length() == 1) {
                    text = text + "g";
                } else if (numForChar.length() == 2) {
                    text = text + "h";
                } else if (numForChar.length() == 3) {
                    text = text + "i";
                }
                break;
            case '5':
                if (numForChar.length() == 1) {
                    text = text + "j";
                } else if (numForChar.length() == 2) {
                    text = text + "k";
                } else if (numForChar.length() == 3) {
                    text = text + "l";
                }
                break;
            case '6':
                if (numForChar.length() == 1) {
                    text = text + "m";
                } else if (numForChar.length() == 2) {
                    text = text + "n";
                } else if (numForChar.length() == 3) {
                    text = text + "o";
                }
                break;
            case '7':
                if (numForChar.length() == 1) {
                    text = text + "p";
                } else if (numForChar.length() == 2) {
                    text = text + "q";
                } else if (numForChar.length() == 3) {
                    text = text + "r";
                } else if (numForChar.length() == 4) {
                    text = text + "s";
                }
                break;
            case '8':
                if (numForChar.length() == 1) {
                    text = text + "t";
                } else if (numForChar.length() == 2) {
                    text = text + "u";
                } else if (numForChar.length() == 3) {
                    text = text + "v";
                }
                break;
            case '9':
                if (numForChar.length() == 1) {
                    text = text + "w";
                } else if (numForChar.length() == 2) {
                    text = text + "x";
                } else if (numForChar.length() == 3) {
                    text = text + "y";
                } else if (numForChar.length() == 4) {
                    text = text + "z";
                }
                break;
            case '0':
                text = text + " ";
                break;
        }

        return text;
    }
}
