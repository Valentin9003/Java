
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class OfficeStuff {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, LinkedHashMap<String, Integer>> companyOfficeStuffs = new TreeMap<>();

        readFromConsoleAndFillDB(reader, companyOfficeStuffs);

        companyOfficeStuffs.entrySet().stream()
                .forEach(company -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append(company.getKey()).append(": ");

                    String products = company.getValue().entrySet().stream()
                            .map(p -> String.format("%s-%s", p.getKey(), p.getValue()))
                            .collect(Collectors.joining(", "));
                    sb.append(products);

                    System.out.println(sb.toString());
                });
    }

    private static void readFromConsoleAndFillDB(BufferedReader reader, Map<String, LinkedHashMap<String, Integer>> companyOfficeStuffs) throws IOException {
        int numberLines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberLines; i++) {
            // |SoftUni - 600 - paper|
            String[] tokens = reader.readLine().replace("|", "").split(" - ");
            String companyName = tokens[0];
            Integer productAmount = Integer.parseInt(tokens[1]);
            String productName = tokens[2];

            fillDatabase(companyOfficeStuffs, companyName, productAmount, productName);
        }
    }

    private static void fillDatabase(Map<String, LinkedHashMap<String, Integer>> companyOfficeStuffs, String companyName, Integer productAmount, String productName) {
        if (companyOfficeStuffs.containsKey(companyName)) {
            if (companyOfficeStuffs.get(companyName).containsKey(productName)) {
                int newAmount = companyOfficeStuffs.get(companyName).get(productName) + productAmount;
                companyOfficeStuffs.get(companyName).replace(productName, newAmount);
            } else {
                companyOfficeStuffs.get(companyName).put(productName, productAmount);
            }

        } else {
            companyOfficeStuffs.putIfAbsent(companyName, new LinkedHashMap<>());
            companyOfficeStuffs.get(companyName).put(productName, productAmount);
        }
    }
}
