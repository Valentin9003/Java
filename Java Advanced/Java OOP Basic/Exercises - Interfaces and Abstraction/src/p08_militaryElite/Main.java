package p08_militaryElite;

import p08_militaryElite.contracts.Mission;
import p08_militaryElite.contracts.Private;
import p08_militaryElite.contracts.Repair;
import p08_militaryElite.contracts.Soldier;
import p08_militaryElite.impl.*;
import p08_militaryElite.util.ConfigSoldierType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final String STOP = "End";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Soldier> soldiersDB = new LinkedList<>();
        Map<Integer, Private> privatesDB = new HashMap<>();

        String line;
        while (!STOP.equals(line = reader.readLine())) {
            String[] soldierTokens = line.split("\\s+");

            int id = Integer.parseInt(soldierTokens[1]);
            String firstName = soldierTokens[2];
            String lastName = soldierTokens[3];
            String corps;

            Soldier soldier = null;
            switch (soldierTokens[0]) {
                case ConfigSoldierType.PRIVATE_SOLDIER:
                    soldier = producePrivateSoldier(privatesDB, soldierTokens, id, firstName, lastName);
                    break;
                case ConfigSoldierType.LEUTENANT_GENERAL_SOLDIER:
                    soldier = produceLeutenantGeneral(privatesDB, soldierTokens, id, firstName, lastName);
                    break;
                case ConfigSoldierType.ENGINEER_SOLDIER:
                    soldier = produceEngineer(soldierTokens, id, firstName, lastName);
                    break;
                case ConfigSoldierType.COMMANDO_SOLDIER:
                    soldier = produceCommando(soldierTokens, id, firstName, lastName);
                    break;
                case ConfigSoldierType.SPY_SOLDIER:
                    soldier = produceSpy(soldierTokens[4], id, firstName, lastName);
                    break;
            }

            if (soldier != null) {
                soldiersDB.add(soldier);
            }
        }

        soldiersDB.forEach(System.out::println);
    }

    private static Soldier produceSpy(String codeName, int id, String firstName, String lastName) {
        //•	Spy: “Spy <id> <firstName> <lastName> <codeNumber>”
        Soldier soldier;
        soldier = new SpyImpl(id, firstName, lastName, codeName);
        return soldier;
    }

    private static Soldier produceCommando(String[] soldierTokens, int id, String firstName, String lastName) {
        //“Commando <id> <firstName> <lastName> <salary> <corps> <mission1CodeName>
        // <mission1state> … <missionNCodeName> <missionNstate>” a missions code name,
        // description and state will always come together.
        Soldier soldier;
        double salary = Double.parseDouble(soldierTokens[4]);
        String corps = soldierTokens[5];
        Set<Mission> missionsSet = getMissionSet(soldierTokens);
        soldier = new CommandoImpl(id, firstName, lastName, salary, corps, missionsSet);
        return soldier;
    }

    private static Set<Mission> getMissionSet(String[] soldierTokens) {
        Set<Mission> missionsSet = new LinkedHashSet<>();
        for (int i = 6; i < soldierTokens.length - 1; i += 2) {
            String codeName = soldierTokens[i];
            String state = soldierTokens[i + 1];
            try {
                Mission mission = new MissionImpl(codeName, state);
                missionsSet.add(mission);
            } catch (IllegalArgumentException ignored) {
                ;
            }
        }
        return missionsSet;
    }

    private static Soldier produceEngineer(String[] soldierTokens, int id, String firstName, String lastName) {
        //“Engineer <id> <firstName> <lastName> <salary> <corps> <repair1Part>
        // <repair1Hours> … <repairNPart> <repairNHours>” where repairXPart is the
        // name of a repaired part and repairXHours the
        Soldier soldier = null;
        double salary = Double.parseDouble(soldierTokens[4]);
        String corps = soldierTokens[5];
        List<Repair> repairList = getRepairsList(soldierTokens);
        try {
            //In case of invalid corps the entire line should be skipped
            soldier = new EngineerImpl(id, firstName, lastName, salary, corps, repairList);
        } catch (IllegalArgumentException ignored) {
            ;
        }
        return soldier;
    }

    private static List<Repair> getRepairsList(String[] soldierTokens) {
        List<Repair> repairList = new LinkedList<>();
        for (int i = 6; i < soldierTokens.length - 1; i += 2) {
            String repairPart = soldierTokens[i];
            int hours = Integer.parseInt(soldierTokens[i + 1]);
            Repair repair = new RepairImpl(repairPart, hours);
            repairList.add(repair);
        }
        return repairList;
    }

    private static Soldier produceLeutenantGeneral(Map<Integer, Private> privatesDB, String[] soldierTokens, int id, String firstName, String lastName) {
        //“LeutenantGeneral <id> <firstName> <lastName> <salary> <private1Id> <privateNId> …"
        //where privateXId will always be an Id of a private already received through the input.
        Soldier soldier;
        double salary = Double.parseDouble(soldierTokens[4]);
        List<Private> privateList = getPrivatesList(privatesDB, soldierTokens);
        soldier = new LeutenantGeneralImpl(id, firstName, lastName, salary, privateList);
        return soldier;
    }

    private static List<Private> getPrivatesList(Map<Integer, Private> privatesDB, String[] soldierTokens) {
        List<Private> privateList = new LinkedList<>();
        for (int i = 5; i < soldierTokens.length; i++) {
            int privateId = Integer.parseInt(soldierTokens[i]);
            privateList.add(privatesDB.get(privateId));
        }
        return privateList;
    }

    private static Soldier producePrivateSoldier(Map<Integer, Private> privatesDB, String[] soldierTokens, int id, String firstName, String lastName) {
        //•	Private: “Private <id> <firstName> <lastName> <salary>”
        Soldier soldier;
        double salary = Double.parseDouble(soldierTokens[4]);
        Private privateSoldier = new PrivateImpl(id, firstName, lastName, salary);
        privatesDB.putIfAbsent(id, privateSoldier);
        soldier = privateSoldier;
        return soldier;
    }
}
