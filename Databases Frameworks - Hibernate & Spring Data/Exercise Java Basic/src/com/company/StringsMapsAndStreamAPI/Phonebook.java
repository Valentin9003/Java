package com.company.StringsMapsAndStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> phonebook = new HashMap<>();

        String input = reader.readLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "A":
                    addEntryToThePhonebook(phonebook, tokens);
                    break;
                case "S":
                    searcheForContact(phonebook, tokens);
                    break;
            }

            input = reader.readLine();
        }
    }

    private static void searcheForContact(HashMap<String, String> phonebook, String[] tokens) {
        String name = tokens[1];

        if (phonebook.containsKey(name)) {
            System.out.println(String.format("%s -> %s", name, phonebook.get(name)));
        } else {
            System.out.println(String.format("Contact %s does not exist.", name));
        }
    }

    private static void addEntryToThePhonebook(HashMap<String, String> phonebook, String[] tokens) {
        String name = tokens[1];
        String phoneNumber = tokens[2];

        if (phonebook.containsKey(name)) {
            phonebook.replace(name, phoneNumber);
        }

        phonebook.putIfAbsent(name, phoneNumber);

    }

}
