package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class ParkingValidation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, String> infoBookNV = new LinkedHashMap<>();

        int number = Integer.parseInt(reader.readLine());

        for (int i = 0; i < number; i++) {
            String[] input = reader.readLine().split(" ");
            String command = input[0];

            if (command.equals("register"))
            {
                String name = input[1];
                String licenseCode = input[2];
                AddNewUser(infoBookNV, name, licenseCode);
            } else if (command.equals("unregister"))
            {
                String name = input[1];
                EraseUser(infoBookNV, name);
            }

        }

        PrintRegistredPersons(infoBookNV);

    }

    private static void PrintRegistredPersons(LinkedHashMap<String, String> infoBookNV)
    {
        for (String person : infoBookNV.keySet()) {
            System.out.println(String.format("%s => %s", person, infoBookNV.get(person)));
        }
    }

    private static void EraseUser(LinkedHashMap<String, String> infoBookNV, String name)
    {
        if (!infoBookNV.containsKey(name)) {
            System.out.println(String.format("ERROR: user %s not found", name));
        }
        else {
            infoBookNV.remove(name);
            System.out.println(String.format("user %s unregistered successfully", name));
        }
    }

    private static void AddNewUser(LinkedHashMap<String, String> infoBookNV, String name, String licenseCode)
    {
        if (!infoBookNV.containsKey(name))
        {
            boolean isLicenseValide = CheckingLicenseForValidation(licenseCode);
            if (!isLicenseValide) {
                System.out.println(String.format("ERROR: invalid license plate %s", licenseCode));
            }
            else if (isBussyAlreadyThisLicence(infoBookNV, licenseCode)) {
                System.out.println(String.format("ERROR: license plate %s is busy", licenseCode));
            }
            else {
                infoBookNV.put(name, licenseCode);
                System.out.println(String.format("%s registered %s successfully", name, licenseCode));
            }
        }
        else
            {
                System.out.println(String.format("ERROR: already registered with plate number ", infoBookNV.get(name)));
            }
    }

    private static boolean isBussyAlreadyThisLicence(LinkedHashMap<String, String> infoBookNV, String licenseCode)
    {
        boolean isBussy = false;

        for (String person : infoBookNV.keySet()) {
            if (infoBookNV.get(person).equals(licenseCode)) {
                isBussy = true;
            }
        }

        return isBussy;
    }


    private static boolean CheckingLicenseForValidation(String licenseCode)
    {
        String leftPastCode = licenseCode.substring(0, 2);
        boolean isLettersLeft = leftPastCode.chars().allMatch(Character::isLetter);

        String rightPastCode = licenseCode.substring(6, 8);
        boolean isLettersRight = rightPastCode.chars().allMatch(Character::isLetter);

        String centerPastCode = licenseCode.substring(2, 6);
        boolean isNumbers = centerPastCode.chars().allMatch(Character::isDigit);

        boolean isLicenseValide = true;
        if (licenseCode.length() != 8) {
            isLicenseValide = false;
        }
        else if (!isLettersLeft || !leftPastCode.equals(leftPastCode.toUpperCase())) {
            isLicenseValide = false;
        }
        else if (!isNumbers) {
            isLicenseValide = false;
        }
        else if (!isLettersRight || !rightPastCode.equals(rightPastCode.toUpperCase())) {
            isLicenseValide = false;
        }

        return isLicenseValide;
    }
}
