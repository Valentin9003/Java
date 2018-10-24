package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PhoenixGrid {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputMessage = reader.readLine();
        while (!inputMessage.equals("ReadMe"))
        {
            if (IsValideMessage(inputMessage))
            {
                if (IsPalindrom(inputMessage)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }

            inputMessage = reader.readLine();
        }
    }

    private static boolean IsPalindrom(String str)
    {
        boolean isPal = false;
        StringBuilder sb = new StringBuilder(String.valueOf(str));

        if (str.equals(sb.reverse().toString())) {
            isPal = true;
        }
        return isPal;
    }

    private static boolean IsValideMessage(String inputMessage)
    {
        String[] messageArr = inputMessage.split("\\.");
        boolean isValide = true;

        for (String str : messageArr)
        {
            if (str.length() < 3 || str.length() > 3 || str.contains("_") || str.contains(" ") || str.equals("")) {
                isValide = false;
                break;
            }
        }

        return isValide;
    }
}

/*
The Phoenix Grid is an ancient artifact created by the Linguistics miracle – Mozilla, The “Fire Bird”.
It is used to translate Phoenix language. You are the newest scientist, researching the Grid and as the research team was almost out of hope,
 you came up with the genius idea to use Regular Expressions! You saved the day! You are a Hero!
You will begin receiving encoded messages. You must CHECK each one of them and if it’s a VALID.
A valid encoded message consists of one phrase or more phrases, separated by DOTS (‘.’).
•	A phrase consists of exactly 3 characters.
•	A phrase CANNOT contain whitespace characters or the ‘_’ (underscore) character.
Valid messages: “asd.dsa”, “123.312”, “3@a.231”, “111”, “@sd”, “132.31$.ddd” . . .
Invalid messages: “123asdasd.dsa”, “_@a. sd”, “a.s.d” . . .
When you have found a valid message, you must check if it a PALINDROME – if it reads the same backward as forward.
Palindrome messages: “asd.dsa”, “123.321”, “cat.php.tac” . . .
If the message is VALID and is a PALINDROME print “YES”. In any other case, print “NO”.
The input ends when you receive the command “ReadMe”.
Input
•	As input you will receive several input lines containing encoded messages.
Output
•	As output you must print for each message “YES” or “NO” if its valid or not.
Constrains
•	The input lines may contain any ASCII character.
•	There will be no more than 1000 input lines.
•	Allowed working time / memory: 100ms / 16MB.

 */