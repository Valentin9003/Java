package com.company;
// 66/100.....
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceTag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        StringBuilder str = new StringBuilder();

        while (!input.equals("end")) {

            str.append(input);

            input = reader.readLine();
        }

        String text = str.toString();

        Pattern htmlPattern = Pattern.compile("<a\\shref=(.+?)>(.+?)</a>");
        Matcher htmlMatcher = htmlPattern.matcher(text);

        while (htmlMatcher.find()){
            String firstText = htmlMatcher.group(1);
            String secondText = htmlMatcher.group(2);

            text = htmlMatcher.replaceAll("[URL href=" + firstText + "]" + secondText + "[/URL]");
        }

        System.out.println(text);

    }
}
