package com.company;

import java.util.Scanner;

public class WordInPlural {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder strBind = new StringBuilder();

        String word = scanner.nextLine();
        String newWord = "";

        if (word.endsWith("y")) {
            newWord = word.replaceAll("y", "ies");
            System.out.println(newWord);
        } else if (word.endsWith("o") || word.endsWith("ch")
                || word.endsWith("s") || word.endsWith("sh")
                || word.endsWith("x") || word.endsWith("z")) {
            System.out.println(word + "es");
        } else {
            System.out.println(word + "s");
        }
    }
}
