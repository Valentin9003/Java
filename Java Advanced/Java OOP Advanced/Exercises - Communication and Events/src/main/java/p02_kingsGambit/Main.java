package p02_kingsGambit;

import p02_kingsGambit.impl.*;
import p02_kingsGambit.interfaces.Subject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, BaseUnit> unitsMap = new LinkedHashMap<>();

        Subject subject = new SubjectImpl();

        String kingName = reader.readLine();
        King king = new King(kingName, subject);
        subject.addObserver(king);

        createGuardiansAndFootmens(reader, unitsMap, subject);

        String line;
        while (!"End".equalsIgnoreCase(line = reader.readLine())) {
            String[] command = line.split("\\s+");
            switch (command[0]){
                case "Attack":
                    king.respondToAttack();
                    break;
                case "Kill":
                    BaseUnit unit = unitsMap.get(command[1]);
                    unitsMap.remove(command[1]);
                    subject.removeObserver(unit);
                    break;
            }
        }

    }

    private static void createGuardiansAndFootmens(BufferedReader reader, Map<String, BaseUnit> unitsMap, Subject subject) throws IOException {
        String[] royalGuards = reader.readLine().split("\\s+");
        for (String royalName : royalGuards) {
            BaseUnit unit = new RoyalGuard(royalName);
            unitsMap.putIfAbsent(royalName, unit);
            subject.addObserver(unit);
        }

        String[] footmans = reader.readLine().split("\\s+");
        for (String footmanName : footmans) {
            BaseUnit unit = new Footman(footmanName);
            unitsMap.putIfAbsent(footmanName, unit);
            subject.addObserver(unit);
        }
    }
}
