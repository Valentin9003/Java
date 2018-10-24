package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ImmuneSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> vNameTime = new HashMap<>();

        int healthIS = Integer.parseInt(reader.readLine());
        int startingHealt = healthIS;

        String virus = reader.readLine();
        while (!virus.equals("end"))
        {
            boolean isAlreadyDefeated = false;
            if (!vNameTime.containsKey(virus)) {
                vNameTime.put(virus, 0);
            } else {
                isAlreadyDefeated = true;
            }

            boolean isDefeated = HealthyCard(vNameTime, virus, healthIS, isAlreadyDefeated);
            if (isDefeated) {
                return;
            }

            healthIS = HealthRemaining(healthIS, vNameTime, virus, startingHealt);

            virus = reader.readLine();
        }

        System.out.println("Final Health: " + healthIS);
    }

    private static int HealthRemaining(int healthIS, HashMap<String, Integer> vNameTime, String virus, Integer startingHealth)
    {
        healthIS -= vNameTime.get(virus);
        System.out.println(String.format("Remaining health: %d", healthIS));

        healthIS += (0.2 * healthIS);
        if (healthIS > startingHealth)
        {
            healthIS = startingHealth;
        }

        return healthIS;
    }

    private static boolean HealthyCard(HashMap<String, Integer> vNameTime, String virus, Integer healthIS, boolean isAlreadyDefeated)
    {
        boolean isDefeated = false;
        double virusStrenght = 0;
        int vStr = 0;
        int tDef =0;
        for (int i = 0; i < virus.length() ; i++) {
            virusStrenght += virus.charAt(i);
        }

        if (isAlreadyDefeated) {
            virusStrenght = Math.floor(virusStrenght / 3);
             vStr = (int)virusStrenght;
             int timeToDefeatSec = (int)Math.floor((virusStrenght * virus.length())/ 3);
             tDef = timeToDefeatSec;
             vNameTime.replace(virus, timeToDefeatSec);
        } else {
            virusStrenght = Math.floor(virusStrenght / 3);
            vStr = (int)virusStrenght;
            int timeToDefeatSec = (int)virusStrenght * virus.length();
            tDef = timeToDefeatSec;
            vNameTime.replace(virus, timeToDefeatSec);
        }

        System.out.println(String.format("Virus %s: %d => %d seconds", virus, vStr, tDef));
        int sec = tDef % 60;
        int min = tDef / 60;
        if (tDef < healthIS) {
            System.out.println(String.format("%s defeated in %dm %ds.", virus, min, sec));
        } else {
            System.out.println("Immune System Defeated.");
            isDefeated = true;
        }
        return isDefeated;
    }
}
