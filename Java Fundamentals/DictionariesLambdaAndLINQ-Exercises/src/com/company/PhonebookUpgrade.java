package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class PhonebookUpgrade {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> phonebook = new TreeMap<>();

        String input = reader.readLine();
        while (!input.equals("END"))
        {
            String[] data = input.split(" ");
            String command = data[0];

            switch (command)
            {
                case "A":
                    String name = data[1];
                    String number = data[2];
                    AddNumberInPhonebookOrReplace(phonebook, name, number);
                    break;
                case "S":
                    name = data[1];
                    SearchingInPhoneBookAndPrint(phonebook, name);
                    break;
                case "ListAll":
                    PrintAllPhonebook(phonebook);
                    break;
            }

            input = reader.readLine();
        }
    }

    private static void PrintAllPhonebook(Map<String, String> phonebook)
    {
        for (String nameKey : phonebook.keySet()) {
            System.out.println(nameKey + " -> " + phonebook.get(nameKey));
        }
    }

    private static void SearchingInPhoneBookAndPrint(Map<String, String> phonebook, String name)
    {
        if (phonebook.containsKey(name))
        {
            System.out.printf("%s -> %s%n", name, phonebook.get(name));
        }
        else
            {
                System.out.printf("Contact %s does not exist.", name);
            }
    }

    private static void AddNumberInPhonebookOrReplace(Map<String, String> phonebook, String name, String number)
    {
        if (!phonebook.containsKey(name))
        {
            phonebook.put(name, number);
        } else
            {
                phonebook.replace(name, number);
            }
    }
}
