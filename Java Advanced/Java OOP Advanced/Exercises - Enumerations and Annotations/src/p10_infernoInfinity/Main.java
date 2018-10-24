package p10_infernoInfinity;

import p10_infernoInfinity.annotations.ClassInfoAnnotation;
import p10_infernoInfinity.entity.Weapon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Weapon> weaponsMap = new HashMap<>();

        String line;
        while (!"END".equalsIgnoreCase(line = reader.readLine())) {
            String[] tokens = line.split(";");
            commandDispatcher(tokens, weaponsMap);
        }
    }

    private static void commandDispatcher(String[] tokens, Map<String, Weapon> weaponsMap) {
        switch (tokens[0]) {
            case "Create":
                executeCreate(tokens, weaponsMap);
                break;
            case "Add":
                executeAddGem(tokens, weaponsMap);
                break;
            case "Remove":
                executeRemoveGem(tokens, weaponsMap);
                break;
            case "Print":
                executePrint(tokens[1], weaponsMap);
                break;
            case "Compare":
                executeCompare(tokens, weaponsMap);
                break;
            case "Author":
                printClassAuthor();
                break;
            case "Revision":
                printClassRevision();
                break;
            case "Description":
                printClassDescription();
                break;
            case "Reviewers":
                printClassReviewers();
                break;
        }
    }

    private static void printClassReviewers() {
        if (Weapon.class.isAnnotationPresent(ClassInfoAnnotation.class)) {
            ClassInfoAnnotation annotation = Weapon.class.getAnnotation(ClassInfoAnnotation.class);
            List<String> reviewersList = Arrays.stream(annotation.reviewers()).collect(Collectors.toList());
            System.out.println(String.format("Reviewers: %s", String.join(", ", reviewersList)));
        }
    }

    private static void printClassDescription() {
        if (Weapon.class.isAnnotationPresent(ClassInfoAnnotation.class)) {
            ClassInfoAnnotation annotation = Weapon.class.getAnnotation(ClassInfoAnnotation.class);
            System.out.println(String.format("Class description: %s", annotation.description()));
        }
    }

    private static void printClassRevision() {
        if (Weapon.class.isAnnotationPresent(ClassInfoAnnotation.class)) {
            ClassInfoAnnotation annotation = Weapon.class.getAnnotation(ClassInfoAnnotation.class);
            System.out.println(String.format("Revision: %d", annotation.revision()));
        }
    }

    private static void printClassAuthor() {
        if (Weapon.class.isAnnotationPresent(ClassInfoAnnotation.class)) {
            ClassInfoAnnotation annotation = Weapon.class.getAnnotation(ClassInfoAnnotation.class);
            System.out.println(String.format("Author: %s", annotation.author()));
        }
    }

    private static void executeCompare(String[] tokens, Map<String,Weapon> weaponsMap) {
        String firstWeaponName = tokens[1];
        String secondWeaponName = tokens[2];
        if (weaponsMap.containsKey(firstWeaponName) && weaponsMap.containsKey(secondWeaponName)) {
            Weapon firstWeapon = weaponsMap.get(firstWeaponName);
            Weapon secondWeapon = weaponsMap.get(secondWeaponName);

            Weapon winner = firstWeapon.compareTo(secondWeapon) >= 0 ? firstWeapon : secondWeapon;

            System.out.println(String.format("%s (Item Level: %.1f)",
                    winner.toString(),
                    winner.getItemLevel()));
        }
    }

    private static void executePrint(String weaponName, Map<String, Weapon> weaponsMap) {
        System.out.println(weaponsMap.get(weaponName));
    }

    private static void executeRemoveGem(String[] tokens, Map<String, Weapon> weaponsMap) {
        String weaponName = tokens[1];
        int socketIndex = Integer.parseInt(tokens[2]);
        if (weaponsMap.containsKey(weaponName)) {
            weaponsMap.get(weaponName).removeGems(socketIndex);
        }
    }

    private static void executeAddGem(String[] tokens, Map<String, Weapon> weaponsMap) {
        String weaponName = tokens[1];
        int socketIndex = Integer.parseInt(tokens[2]);
        String gemType = tokens[3];
        try {
            if (weaponsMap.containsKey(weaponName)) {
                weaponsMap.get(weaponName).addGems(socketIndex, gemType);
            }
        } catch (IllegalArgumentException ignored) {
            ;
        }
    }

    private static void executeCreate(String[] tokens, Map<String, Weapon> weaponsMap) {
        String weaponType = tokens[1];
        String weaponName = tokens[2];
        try {
            Weapon weapon = new Weapon(weaponName, weaponType);
            weaponsMap.put(weaponName, weapon);
        } catch (IllegalArgumentException ignored) {
            ;
        }
    }
}
