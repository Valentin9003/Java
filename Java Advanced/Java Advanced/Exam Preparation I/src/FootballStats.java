import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> teamsDB = new HashMap<>();

        fillTeamsDatabase(reader, teamsDB);

        printResult(reader, teamsDB);
    }

    private static void printResult(BufferedReader reader, Map<String,List<String>> teamsDB) throws IOException {
        String[] teamsForPrint = reader.readLine().split(", ");

        for (String tfp : teamsForPrint) {
            if (teamsDB.containsKey(tfp)) {
                teamsDB.get(tfp)
                        .sort((t1,t2) -> t1.split("\\s+")[0].compareTo(t2.split("\\s+")[0]));

                teamsDB.get(tfp).forEach(opponentTeam -> {
                    System.out.println(String.format("%s - %s", tfp, opponentTeam));
                });
            }
        }
    }

    private static void fillTeamsDatabase(BufferedReader reader, Map<String, List<String>> teamsDB) throws IOException {
        String line;
        while (!"Season End".equalsIgnoreCase(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            String mainTeam = tokens[0];
            String opponentTeam = tokens[2];
            String result = tokens[4];

            addNewStatsForMainTeamInToDB(teamsDB, mainTeam, opponentTeam, result);
            addNewStatsForOpponentTeamInToDB(teamsDB, mainTeam, opponentTeam, result);
        }
    }

    private static void addNewStatsForOpponentTeamInToDB(Map<String, List<String>> teamsDB, String mainTeam, String opponentTeam, String result) {
        if (teamsDB.containsKey(opponentTeam)) {
            StringBuilder resultBuilder = new StringBuilder(result);
            resultBuilder.reverse();
            String newStats = String.format("%s -> %s", mainTeam, resultBuilder.toString());
            teamsDB.get(opponentTeam).add(newStats);
        } else {
            StringBuilder resultBuilder = new StringBuilder(result);
            resultBuilder.reverse();
            List<String> teamStat = new ArrayList<>();
            teamStat.add(String.format("%s -> %s", mainTeam, resultBuilder.toString()));
            teamsDB.putIfAbsent(opponentTeam, teamStat);
        }
    }

    private static void addNewStatsForMainTeamInToDB(Map<String, List<String>> teamsDB, String mainTeam, String opponentTeam, String result) {
        if (teamsDB.containsKey(mainTeam)) {
            String newStats = String.format("%s -> %s", opponentTeam, result);
            teamsDB.get(mainTeam).add(newStats);
        } else {
            List<String> mainTeamStat = new ArrayList<>();
            mainTeamStat.add(String.format("%s -> %s", opponentTeam, result));
            teamsDB.putIfAbsent(mainTeam, mainTeamStat);
        }
    }
}
