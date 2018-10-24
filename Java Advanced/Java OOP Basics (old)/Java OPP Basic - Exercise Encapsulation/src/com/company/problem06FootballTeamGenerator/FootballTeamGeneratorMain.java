package com.company.problem06FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class FootballTeamGeneratorMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Team> teamsMap = new HashMap<>();


        String[] commandInput = reader.readLine().split(";");
        while (!commandInput[0].equals("END")) {

            try {
                executeCommand(commandInput, teamsMap);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }

            commandInput = reader.readLine().split(";");
        }
    }

    private static void executeCommand(String[] commandInput, HashMap<String, Team> teamsMap) {
        String command = commandInput[0];
        switch (command) {
            case "Team":
                addNewTeam(commandInput, teamsMap);
                break;

            case "Add":
                String teamName = commandInput[1];
                if (!teamsMap.containsKey(teamName)) {
                    throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
                }
                addNewPlayerToTheGivenTeam(commandInput, teamsMap);
                break;

            case "Remove":
                removePlayerFromGivenTeam(commandInput, teamsMap);
                break;

            case "Rating":
                printTeamRating(commandInput, teamsMap);
                break;
        }
    }

    private static void printTeamRating(String[] commandInput, HashMap<String, Team> teamsMap) {
        String teamName = commandInput[1];
        System.out.println(teamsMap.get(teamName).toString());
    }

    private static void removePlayerFromGivenTeam(String[] commandInput, HashMap<String, Team> teamsMap) {
        String teamName = commandInput[1];
        String playerName = commandInput[2];

        teamsMap.get(teamName).removePlayer(playerName);
    }

    private static void addNewPlayerToTheGivenTeam(String[] commandInput, HashMap<String, Team> teamsMap) {
        String teamName = commandInput[1];
        String playerName = commandInput[2];
        int endurance = Integer.valueOf(commandInput[3]);
        int sprint = Integer.valueOf(commandInput[4]);
        int dribble = Integer.valueOf(commandInput[5]);
        int passing = Integer.valueOf(commandInput[6]);
        int shooting = Integer.valueOf(commandInput[7]);

        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
        teamsMap.get(teamName).addNewPlayer(player);
    }

    private static void addNewTeam(String[] commandInput, HashMap<String, Team> teamsMap) {
        String teamName = commandInput[1];
        Team team = new Team(teamName);
        teamsMap.putIfAbsent(teamName, team);
    }
}
