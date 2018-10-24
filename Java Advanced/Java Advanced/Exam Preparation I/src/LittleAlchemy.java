import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> alchemyList =
                Arrays.stream(reader.readLine().split("\\s+"))
                        .map(Integer::parseInt).collect(Collectors.toList());
        ArrayDeque<Integer> queue = new ArrayDeque<>(alchemyList);

        int goldInTheStorage = 0;
        String line;
        while (!"Revision".equalsIgnoreCase(line = reader.readLine())) {
            String command = line.split("\\s+")[0];

            switch (command) {
                case "Apply":
                    int acidValue = Integer.parseInt(line.split("\\s+")[2]);

                    for (int index = 0; index < acidValue; index++) {
                        if (queue.isEmpty()) {
                            break;
                        }
                        int stone = queue.pop();
                        stone--;
                        if (stone <= 0) {
                            goldInTheStorage++;
                        } else {
                            queue.addLast(stone);
                        }
                    }
                    break;
                case "Air":
                    int label = Integer.parseInt(line.split("\\s+")[2]);
                    if (goldInTheStorage > 0) {
                        goldInTheStorage--;
                        queue.addLast(label);
                    }
                    break;
            }
        }

        System.out.println(queue.toString().replaceAll("[\\[,\\]]", ""));
        System.out.println(goldInTheStorage);
    }
}
