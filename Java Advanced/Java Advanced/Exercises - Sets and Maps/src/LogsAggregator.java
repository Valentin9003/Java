import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Integer> nameDuration = new TreeMap<>();
        Map<String, TreeSet<String>> nameIps = new HashMap<>();

        int numberLines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberLines; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            fillNameDurationDB(nameDuration, tokens);
            fillNameIpsDB(nameIps, tokens);
        }

        printResult(nameDuration, nameIps);
    }

    private static void printResult(TreeMap<String, Integer> nameDuration, Map<String, TreeSet<String>> nameIps) {
        for (String user : nameDuration.keySet()) {
            System.out.print(String.format("%s: %d ", user, nameDuration.get(user)));
            System.out.print(nameIps.get(user) + System.lineSeparator());
        }
    }

    private static void fillNameIpsDB(Map<String, TreeSet<String>> nameIps, String[] tokens) {
        String user = tokens[1];
        String ip = tokens[0];
        if (nameIps.containsKey(user)) {
            nameIps.get(user).add(ip);
        } else {
            nameIps.putIfAbsent(user, new TreeSet<>());
            nameIps.get(user).add(ip);
        }
    }

    private static void fillNameDurationDB(TreeMap<String, Integer> nameDuration, String[] tokens) {
        String user = tokens[1];
        int duration = Integer.parseInt(tokens[2]);
        if (nameDuration.containsKey(user)) {
            int newDuration = nameDuration.get(user) + duration;
            nameDuration.replace(user, newDuration);
        }
        nameDuration.putIfAbsent(user, duration);
    }
}
