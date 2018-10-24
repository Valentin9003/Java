import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> resultMap = new TreeMap<>();

        String text = reader.readLine();
        String[] tokens = text.split("");

        if (tokens.length == 1 && tokens[0].isEmpty())
            return;

        fillResultMap(resultMap, tokens);
        printResultMap(resultMap);
    }

    private static void printResultMap(TreeMap<String, Integer> resultMap) {
        resultMap.entrySet().forEach(c -> {
            System.out.println(String.format("%s: %d time/s", c.getKey(), c.getValue()));
        });
    }

    private static void fillResultMap(TreeMap<String, Integer> resultMap, String[] tokens) {
        for (String token : tokens) {
            resultMap.putIfAbsent(token, 0);
            if (resultMap.containsKey(token)) {
                int count = resultMap.get(token) + 1;
                resultMap.replace(token, count);
            }
        }
    }
}
