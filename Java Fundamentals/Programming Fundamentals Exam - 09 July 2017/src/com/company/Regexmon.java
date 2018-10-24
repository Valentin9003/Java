package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexmon {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pokemonPat = Pattern.compile("[A-Za-z]+-[A-Za-z]+");
        Pattern didimonPat = Pattern.compile("[^A-Za-z\\-]+");

        String input = reader.readLine();

        boolean isDidiTurn = true;
        while (true)
        {
            Matcher matcherPoke = pokemonPat.matcher(input);
            Matcher matcherDidi = didimonPat.matcher(input);
            int lastIndex = 0;

            if (matcherDidi.find() && isDidiTurn) {
                System.out.println(matcherDidi.group());
                lastIndex = matcherDidi.end();
                input = input.substring(lastIndex, input.length());
                isDidiTurn = false;
            }
           else if (matcherPoke.find() && !isDidiTurn) {
                System.out.println(matcherPoke.group());
                lastIndex = matcherPoke.end();
                input = input.substring(lastIndex, input.length());
                isDidiTurn = true;
            } else {
                return;
            }
        }

    }
}

/*
Bojomon and Didimon are both pokemons which like to capture specific elements from a text. But they always fight so
they decided to take turns in capturing things. Didimon is first, of course, because “ladies first”.
Bojomon matches only pokewords.
A pokeword consists of 2 sequences of alphabet letters, separated by a dash (‘-’). Example: “pika-pika”
Didimon matches everything EXCEPT alphabet letters and dashes.
You will get a single string, containing random ASCII characters, from the input.
Didimon starts first. If she finds a match, she prints it on the console, and switches turns with Bojomon.
Then Bojomon starts matching AFTER Didimon’s match, IGNORING everything before it, from the string. When he finds a match,
he prints it and switches turns with Didimon, and she starts matching AFTER Bojomon’s match.
This process repeats until the one who is at turn does NOT match anything till the end of the string.
Example: “!!!aa-aa?_?”
1.	Didimon matches “!!!”, then she switches with Bojomon.
2.	Bojomon starts after Didimon’s match and so he has “aa-aa?_?”. He matches “aa-aa” and switches with Didimon.
3.	Didimon starts after Bojomon’s match and so she has “?_?”. She matches “?_?” and switches with Bojomon again.
4.	Bojomon starts after Didimon’s match and so he has “” (empty string). He matches nothing and the program ends.
Input
•	The input will consist of a single line, containing the text, that Bojomon and Didimon are going to match.
Output
•	As output you should print Bojomon and Didimon’s matches, each on a new line.
Constrains
•	The input string may contain any ASCII character.
•	Allowed time / memory: 100ms / 16MB.

INPUT              |   OUTPUT
----------------------------------------
^^^^pika-pika^^^^  | ^^^^
                   | pika-pika
                   | ^^^^

 */