import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class MinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> minerTask = new LinkedHashMap<>();

        String input = reader.readLine();

        while (!"stop".equals(input))
        {
            int quantityInput = Integer.parseInt(reader.readLine());

            addNewAndCheckingForResourse(minerTask, input, quantityInput);

            input = reader.readLine();
            if (input.equals("stop")) {
                printMinerTask(minerTask);
            }
        }
    }

    private static void printMinerTask(Map<String, Integer> minerTask)
    {
        for (String resourse : minerTask.keySet()) {
            System.out.printf("%s -> %d%n", resourse, minerTask.get(resourse));
        }
    }

    private static void addNewAndCheckingForResourse(Map<String, Integer> minerTask, String input, int quantity)
    {
        if (minerTask.containsKey(input))
        {
            int valueQuantity = minerTask.get(input);
            valueQuantity += quantity;
            minerTask.replace(input, valueQuantity);
        } else
        {
            minerTask.put(input, quantity);
        }
    }
}
