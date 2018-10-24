package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> mailsInfo = new LinkedHashMap<>();
        String name = reader.readLine();

        while (!name.equals("stop"))
        {
            String mail = reader.readLine();
            if (CheckingMailsForInvalide(mail))
            {
                AddNewInfoOrReplaceOlder(mailsInfo, name, mail);
            }

            name = reader.readLine();
            if (name.equals("stop")) {
                PrintMailsInfo(mailsInfo);
            }
        }
    }

    private static void PrintMailsInfo(Map<String, String> mailsInfo)
    {
        for (String nameKey : mailsInfo.keySet()) {
            System.out.printf("%s -> %s%n", nameKey, mailsInfo.get(nameKey));
        }
    }

    private static void AddNewInfoOrReplaceOlder(Map<String, String> mailsInfo, String name, String mail)
    {
        if (mailsInfo.containsKey(name))
        {
            mailsInfo.replace(name, mail);
        } else
            {
                mailsInfo.put(name, mail);
            }
    }

    private static boolean CheckingMailsForInvalide(String mail)
    {
        boolean isValide = true;
        String substr = mail.substring(mail.length() - 2);
        if (substr.equals("us") || substr.equals("uk")) {
            isValide = false;
        }
        return isValide;
    }
}
