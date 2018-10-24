package com.company.StringsMapsAndStreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class PhonebookUpgrade {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, String> phonebook = new TreeMap<>();

        String input = reader.readLine();
        while (!input.equals("END")) {
            executeCommand(phonebook, input);
            input = reader.readLine();
        }
    }

    private static void executeCommand(TreeMap<String, String> phonebook, String input) {
        String[] tokens = input.split("\\s+");
        String command = tokens[0];

        switch (command) {
            case "A":
                addEntryToThePhonebook(phonebook, tokens);
                break;
            case "S":
                searchesForContact(phonebook, tokens);
                break;
            case "ListAll":
                printAllContactsOrderedLexicographically(phonebook);
                break;
        }
    }

    private static void printAllContactsOrderedLexicographically(TreeMap<String, String> phonebook) {
        for (String name : phonebook.keySet()) {
            System.out.println(String.format("%s -> %s", name, phonebook.get(name)));
        }
    }

    private static void searchesForContact(TreeMap<String, String> phonebook, String[] tokens) {
        String name = tokens[1];

        if (phonebook.containsKey(name)) {
            System.out.println(String.format("%s -> %s", name, phonebook.get(name)));
        } else {
            System.out.println(String.format("Contact %s does not exist.", name));
        }
    }

    private static void addEntryToThePhonebook(TreeMap<String, String> phonebook, String[] tokens) {
        String name = tokens[1];
        String phoneNumber = tokens[2];

        if (phonebook.containsKey(name)) {
            phonebook.replace(name, phoneNumber);
        }

        phonebook.putIfAbsent(name, phoneNumber);

    }

}
