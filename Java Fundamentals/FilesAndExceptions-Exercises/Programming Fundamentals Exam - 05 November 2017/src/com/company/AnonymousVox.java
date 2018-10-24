package com.company;
// 90/100
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnonymousVox {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String encodedText = reader.readLine();
        String values = reader.readLine();

        Pattern pattern = Pattern.compile("([A-Za-z]+)(.*)\\1");
        Matcher matcher = pattern.matcher(encodedText);

        values = values.replaceAll("\\{", "");
        String[] valuesArr = values.split("}");

        ArrayList<String> myList = new ArrayList<>();
        for (String s : valuesArr)
        {
                myList.add(s);
        }

        while (matcher.find())
        {
            String word = matcher.group(2);
            encodedText = encodedText.replaceFirst(word, myList.get(0));
            myList.remove(0);
        }

        System.out.println(encodedText);
    }
}

/*
The Anonymous’s main communication channel is based on encoded messages. The CIA has targetted that channel,
assuming that it holds sensitive information. You have been hired to decode and break their internal com. system.
You will receive an input line containing a single string – the encoded text. Then, on the next line you will
receive several values in the following format: “{value1}{value2}{value3}...”.
You must find the encoded placeholders in the text and REPLACE each one of them with the value that corresponds to its index.
Example: placeholder1 – value1, placeholder2 – value2 etc. There may be more values than placeholders or more placeholders than values.
The placeholders consist of 3 blocks {start}{placeholder}{end}. The start should consist only of English alphabet letters.
 The placeholder may contain ANY ASCII character. The end should be EXACTLY EQUAL to the start. The idea is that you have to find the placeholders,
  and REPLACE their placeholder block with the value at that index.
Example Placeholders: “a.....a”, “b!d!b”, “asdxxxxxasd”, “peshogoshopesho”...
You must ALWAYS match the placeholder with the LONGEST start and the RIGHTMOST end. For example if you have “asddvdasd” you should NOT match “dvd” as a placeholder, you should match “asddvdasd”.
At the end you must print the result text, after you’ve replaced the values.
Input
•	On the first input line you will receive the encoded text.
•	On the second input line you will receive the placeholders.
Output
•	As output you must print a single line containing the resulting text, after the replacing of values.
Constrains
•	The given text may contain ANY ASCII character.
•	The given values may contain ANY ASCII character except ‘{’ and ‘}’.
•	The given values will AWLAYS follow the format specified above.
•	Allowed working time/memory: 100ms / 16MB.

 */