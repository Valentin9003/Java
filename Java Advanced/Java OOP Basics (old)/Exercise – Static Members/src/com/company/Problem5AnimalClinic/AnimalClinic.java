package com.company.Problem5AnimalClinic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnimalClinic {
    private static Integer patientId;
    private static Integer healedAnimalsCount;
    private static Integer rehabilitedAnimalsCount;

    private HashMap<String, List<Animal>> clinicBook;

    static {
        patientId = 0;
        healedAnimalsCount = 0;
        rehabilitedAnimalsCount = 0;
    }

    public AnimalClinic() {
        this.clinicBook = new HashMap<>();
    }

    public void addNewPatient(Animal animal) {
        patientId++;
        if (animal.getCommand().equals("heal")) {
            healedAnimalsCount++;
        } else if (animal.getCommand().equals("rehabilitate")) {
            rehabilitedAnimalsCount++;
        }

        addInClinicBook(animal);

        System.out.printf("Patient %d: [%s(%s)] has been %s %n",
                patientId,
                animal.getName(),
                animal.getBreed(),
                animal.getCommand());
    }

    private void addInClinicBook(Animal animal) {
        clinicBook.putIfAbsent(animal.getCommand(), new ArrayList<>());
        clinicBook.get(animal.getCommand()).add(animal);
    }

    public static void getTotalInfo() {
        System.out.println(String.format("Total healed animals: %d", healedAnimalsCount));
        System.out.println(String.format("Total rehabilitated  animals: %d", rehabilitedAnimalsCount));
    }

    public void getInfoForHealedPatients() {
        clinicBook.get("heal").forEach(animal -> {
            System.out.println(animal.getName() + " " + animal.getBreed());
        });
    }

    public void getInfoForRehabilitatePatients() {
        clinicBook.get("rehabilitate").forEach(animal -> {
            System.out.println(animal.getName() + " " + animal.getBreed());
        });
    }

}
