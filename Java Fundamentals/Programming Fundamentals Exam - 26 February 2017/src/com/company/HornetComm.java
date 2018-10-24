package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HornetComm {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> message = new ArrayList<>();
        ArrayList<String> broadcast = new ArrayList<>();

        Pattern pattMessage = Pattern.compile("([\\d]+ <-> [A-Za-z0-9]+)");
        Pattern pattBroadcast = Pattern.compile("^([\\D]+ <-> [A-Za-z0-9]+)");

        String input = reader.readLine();
        while (!input.equals("Hornet is Green")) {
            Matcher matcherMessage = pattMessage.matcher(input);
            Matcher matcherBroadcast = pattBroadcast.matcher(input);

            if (matcherMessage.find()) {
                if (matcherMessage.group().length() == input.length()) {
                    AddMessage(message, input);
                }
            }
            if (matcherBroadcast.find()) {
                if (matcherBroadcast.group().length() == input.length()) {
                    AddBroadcast(broadcast, input);
                }
            }

            input = reader.readLine();
        }

        CheckerForEmptyList(message, broadcast);
        PrintResult(message,broadcast);
    }

    private static void PrintResult(ArrayList<String> message, ArrayList<String> broadcast)
    {
        System.out.println("Broadcasts:");
        for (String str : broadcast) {
            System.out.println(str);
        }
        System.out.println("Messages:");
        for (String str : message) {
            System.out.println(str);
        }
    }

    private static void CheckerForEmptyList(ArrayList<String> message, ArrayList<String> broadcast)
    {
        if (message.size() == 0) {
            message.add("None");
        }
        if (broadcast.size() == 0) {
            broadcast.add("None");
        }
    }

    private static void AddBroadcast(ArrayList<String> broadcast, String input)
    {
        String[] inoutArr = input.split(" <-> ");
        String firstStr = inoutArr[1];
        String seconStr = inoutArr[0];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < firstStr.length(); i++) {
            if (firstStr.charAt(i) == firstStr.toUpperCase().charAt(i)) {
                sb.append(firstStr.toLowerCase().charAt(i));
            }
            else if (firstStr.charAt(i) == firstStr.toLowerCase().charAt(i)) {
                sb.append(firstStr.toUpperCase().charAt(i));
            }
            else if (firstStr.charAt(i) >= 48 || firstStr.charAt(i) <= 57) {
                sb.append(firstStr.charAt(i));
            }
        }

        String result = "" + sb.toString() + " -> " + seconStr;
        broadcast.add(result);
    }

    private static void AddMessage(ArrayList<String> message, String input)
    {
        String[] inoutArr = input.split(" <-> ");
        String number = new StringBuilder(inoutArr[0].trim()).reverse().toString();
        String result = "" + number + " -> " + inoutArr[1];
        message.add(result);
    }

}

/*
The Hornet Ex-King – Horny, has established an innovative technology providing communication for his fellow hornets, called Hornet Comm. Inc.
Hornet Comm. provides functionality from private messages to wide broadcasts.
You will be given data of several tracked comm. channels, which you must decrypt. The input data will come in the following format:
{firstQuery} <-> {secondQuery}
If the first query consists only of digits and the second one consists of digits and / or letters, it is a private message.
If the first query consists of anything but digits, and the second one consists of letters and / or digits, it is a broadcast.
Any input that does NOT follow the format, specified above, should be IGNORED.
If the given data is a private message, the first query is the recipient’s code, and the second query is the message.
You must reverse the recipient’s code and store it along with the message.
If the given data is a broadcast, the first query is the message, and the second query is the frequency.
You must take the frequency and make all capital letters – small and all small letters – capital. Then you must store it, along with the message.
You must keep all input broadcasts and messages after you decrypt them.
When you receive the command “Hornet is Green”, the input sequences ends, and you must print the stored broadcasts and messages.
Input
•	The input comes in the form of several input lines in the format specified above.
•	The input ends when you receive the command “Hornet is Green”.
Output
•	As output you must print all broadcasts and messages, printing first the broadcasts, in the following format:
o	Broadcasts:
o	{frequency} -> {message}
o	. . .
o	Messages:
o	{recipient} -> {message}
o	. . .
•	If there are no messages, or no broadcasts, print “None” in their place.
Constrains
•	The input lines may consist of any ASCII character.
•	There will be NO more than 1000 lines of input.
•	All data must be printed in order of input.

 */