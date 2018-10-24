package com.company.Problem5AnimalClinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnimalClinicMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        AnimalClinic animalClinic = new AnimalClinic();

        String[] tokens = reader.readLine().split("\\s+");
        while (!tokens[0].equals("End")) {
            String name = tokens[0];
            String breed = tokens[1];
            String command = tokens[2];

            Animal animal = new Animal(name, breed, command);
            animalClinic.addNewPatient(animal);

            tokens = reader.readLine().split("\\s+");
        }

        String wantedInfo = reader.readLine();

        AnimalClinic.getTotalInfo();
        getWantedInfo(wantedInfo, animalClinic);
    }

    private static void getWantedInfo(String wantedInfo, AnimalClinic animalClinic) {
        switch (wantedInfo) {
            case "heal":
                animalClinic.getInfoForHealedPatients();
                break;
            case "rehabilitate":
                animalClinic.getInfoForRehabilitatePatients();
                break;
        }
    }

}
