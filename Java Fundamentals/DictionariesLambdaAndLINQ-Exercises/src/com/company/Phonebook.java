package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String comm = reader.readLine();
        Map<String, String> phonebook = new LinkedHashMap<>();

        while (!comm.equals("END"))
        {
            String[] commandArr = comm.split(" ");
            String command = commandArr[0];

            if (command.equals("A"))
            {
                    String keyName = commandArr[1];
                    String phoneNumber = commandArr[2];
                    AddToPhonebook(phonebook, keyName, phoneNumber);
            }
            else if (command.equals("S"))
            {
                    String keyName = commandArr[1];
                    SearchInPhonebookAndPrintResult(phonebook, keyName);
            }

            comm = reader.readLine();
        }
    }

    private static void SearchInPhonebookAndPrintResult(Map<String, String> phonebook, String keyName)
    {
        if (phonebook.containsKey(keyName))
        {
            System.out.printf("%s -> %s%n", keyName, phonebook.get(keyName));
        } else
            {
                System.out.printf("Contact %s does not exist.%n", keyName);
            }
    }

    private static void AddToPhonebook(Map<String, String> phonebook, String keyName, String phoneNumber)
    {
        if (!phonebook.containsKey(keyName)) {
            phonebook.put(keyName, phoneNumber);
        }
        else
        {
            phonebook.replace(keyName, phoneNumber);
        }
    }
}
