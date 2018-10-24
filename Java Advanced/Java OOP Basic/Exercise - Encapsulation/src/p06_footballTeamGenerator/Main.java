package p06_footballTeamGenerator;

import p06_footballTeamGenerator.models.Player;
import p06_footballTeamGenerator.models.Stat;
import p06_footballTeamGenerator.models.Team;
import p06_footballTeamGenerator.util.Config;
import p06_footballTeamGenerator.util.ConfigExMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Team> teamsDB = new HashMap<>();

        String line;
        while (!Config.STOP_PROGRAM_COMMAND.equalsIgnoreCase(line = reader.readLine())) {
            String[] tokens = line.split(Config.TOKENS_SPLIT_REGEX);

            try {
                executeCommand(tokens, teamsDB);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

    private static void executeCommand(String[] tokens, Map<String, Team> teamsDB) {
        String command = tokens[Config.COMMAND_INDEX];
        String teamName = tokens[Config.TEAM_NAME_INDEX];

        switch (command) {
            case Config.ADD_TEAM_COMMAND:
                teamsDB.putIfAbsent(teamName, new Team(teamName));
                break;
            case Config.ADD_PLAYER_COMMAND:
                addNewPlayerToTheGivenTeam(tokens, teamsDB, teamName);
                break;
            case Config.REMOVE_PLAYER_COMMAND:
                removePlayerFromTheGivenTeam(tokens, teamsDB, teamName);
                break;
            case Config.GET_TEAM_RATING_COMMAND:
                showRatingForTheGivenTeam(teamsDB, teamName);
                break;
        }
    }

    private static void showRatingForTheGivenTeam(Map<String, Team> teamsDB, String teamName) {
        if (!teamsDB.containsKey(teamName)) {
            throw new IllegalArgumentException(
                    String.format(ConfigExMessage.SHOW_STATS_FOR_MISSING_TEAM_EX_MESSAGE, teamName));
        }

        System.out.println(teamsDB.get(teamName));
    }

    private static void removePlayerFromTheGivenTeam(String[] tokens, Map<String, Team> teamsDB, String teamName) {
        String playerName = tokens[Config.PLAYER_NAME_INDEX];
        teamsDB.get(teamName).removePlayer(playerName);
    }

    private static void addNewPlayerToTheGivenTeam(String[] tokens, Map<String, Team> teamsDB, String teamName) {
        if (!teamsDB.containsKey(teamName)) {
            throw new IllegalArgumentException(
                    String.format(ConfigExMessage.ADD_PLAYER_TO_MISSING_TEAM_EX_MESSAGE, teamName));
        }

        String playerName = tokens[Config.PLAYER_NAME_INDEX];
        Player player = new Player(playerName);

        Stat stats = extractPlayerStatFromInput(tokens);
        player.setStats(stats);

        teamsDB.get(teamName).addPlayer(player);
    }

    private static Stat extractPlayerStatFromInput(String[] tokens) {
        int endurance = Integer.parseInt(tokens[Config.ENDURANCE_INDEX]);
        int sprint = Integer.parseInt(tokens[Config.SPRINT_INDEX]);
        int dribble = Integer.parseInt(tokens[Config.DRIBBLE_INDEX]);
        int passing = Integer.parseInt(tokens[Config.PASSING_INDEX]);
        int shooting = Integer.parseInt(tokens[Config.SHOOTING_INDEX]);

        return new Stat(endurance, sprint, dribble, passing, shooting);
    }
}
