package com.company;

public class test {
    public static void main(String[] args) {
        String keyWord = "wdfsdfsfd3+";

        if (keyWord.endsWith("+")) {
            keyWord = keyWord.substring(0,keyWord.length() - 1);
        }

        System.out.println(keyWord);
    }
}
