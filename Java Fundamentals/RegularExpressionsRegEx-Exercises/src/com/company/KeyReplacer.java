/*
You will be given a key string and a text string. The key string will contain a start key and an end key.
The start key starts at the beginning of the string and ends at the first occurrence of one of the symbols – “|”, “&lt;”
or “\”. The end key starts at the last occurrence of one of these symbols and ends when the string ends. Both keys
can contain only Latin alphabet letters.
When you extract both keys search for them in the text string and extract every string, which is between them.
Concatenate all collected strings and print the result. If the result string is empty print “Empty result”.
Input
The input will be read from the console. The first line will hold the keys string and the second line will hold the text
to search.
Output
Print the concatenated message, if such exists or "Empty result", if it does not.
 */
package com.company;
// 100/100
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeyReplacer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> myList = new ArrayList<>(Arrays.asList(reader.readLine().split("(?:[\\\\|<|\\|][A-Za-z0-9]+[\\\\|<|\\|])")));
        String text = reader.readLine();

        if (myList.size() == 2) {
            String reGex = "(?<=" + myList.get(0) + ")(.*?)(?=" + myList.get(1) + ")";
            Pattern pattern = Pattern.compile(reGex);
            Matcher matcher = pattern.matcher(text);

            String result = "";
            while (matcher.find()) {
                result = result + matcher.group();
            }

            if (result.length() == 0) {
                System.out.println("Empty result");
            } else {
                System.out.println(result);
            }
        } else {
            System.out.println("Empty result");
        }
    }
}
// << INPUT >>
//start<213asfaas|end
//saaastarthelloendsdarstartFromTheOtherenddvsefdsfstartSideend
// << OUTPUT >>
//helloFromTheOtherSide

// <<INPUT>>
//A|safafasfsadf|B
//NoMEssageABhereYeyAB
// << OUTPUT >>
//Empty result