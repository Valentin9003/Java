/*
-Input
The input comes from the console on a variable number of lines and ends when the keyword "END" is received.
For each row of the input, the query string contains field=value pairs. Within each pair, the field name and value are
separated by an equals sign, '='. The series of pairs are separated by an ampersand, '&'. The question mark is used as
a separator and is not part of the query string. A URL query string may contain another URL as value. The input data
will always be valid and in the format described. There is no need to check it explicitly.
-Output
For each input line, print on the console a line containing the processed string as follows:
key=[value]nextkey=[another value] ... etc.
Multiple whitespace characters should be reduced to one inside value/key names, but there shouldn’t be any
whitespaces before/after extracted keys and values. If a key already exists, the value is added with comma and
space after other values of the existing key in the current string. See the examples below.
-Constraints
 SPACE is encoded as "+" or "%20". Letters (A-Z and a-z), numbers (0-9), the characters '*','-','.','_' and
other non-special symbols are left as-is.
 Allowed working time: 0.1 seconds. Allowed memory: 16 MB.
 */

package com.company;
// 100/100 in Judge
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class QueryMess {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        while (!"end".equalsIgnoreCase(line)) {
            Map<String, ArrayList<String>> keyMap = new LinkedHashMap<>();

            line = line.replaceAll(".+\\?", "");
            line = line.replaceAll("\\+|%20", " ");
            line = line.replaceAll("\\s{2,}", " ").trim();

            String[] keyValues = line.split("&");

            for (int i = 0; i < keyValues.length; i++) {
                String[] pairs = keyValues[i].split("=");
                String key = pairs[0].trim();
                String value = pairs[1].trim();

                if (!keyMap.containsKey(key)) {
                    keyMap.put(key, new ArrayList<>());
                }
                keyMap.get(key).add(value);
            }

            for (String key : keyMap.keySet()) {
                System.out.print(key + "=");
                System.out.print(keyMap.get(key));
            }
            System.out.println();

            line = reader.readLine();
        }
    }
}

//********<< Input >>***********
//login=student&password=student
//field=value1&field=value2&field=value3
//http://example.com/over/there?name=ferret
//foo=%20foo&value=+val&foo+=5+%20+203
//foo=poo%20&value=valley&dog=wow+
//url=https://softuni.bg/trainings/coursesinstances/details/1070
//https://softuni.bg/trainings.asp?trainer=nakov&course=oop&course=php
//END