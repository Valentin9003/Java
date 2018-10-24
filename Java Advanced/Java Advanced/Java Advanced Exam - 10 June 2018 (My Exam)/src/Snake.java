import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Snake {

    private static final String EMPTY_CELL = "*";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int sizeOfTheScreen = Integer.parseInt(reader.readLine());
        String[][] screenMatrix = new String[sizeOfTheScreen][sizeOfTheScreen];

        ArrayDeque<String> commands =
                Arrays.stream(reader.readLine()
                        .split(","))
                        .collect(Collectors.toCollection(ArrayDeque::new));

        int[] tokens = fillScreenMatrix(reader, sizeOfTheScreen, screenMatrix);
        int currentRow = tokens[0];
        int currentCol = tokens[1];
        int totalFoodAmount = tokens[2];
        int snakeLength = 1;

        while (commands.size() != 0) {
            switch (commands.pop().trim()) {
                case "left":
                    currentCol = --currentCol >= 0 ? currentCol : (screenMatrix[0].length - 1);
                    break;
                case "right":
                    currentCol = ++currentCol <= (screenMatrix[0].length - 1) ? currentCol : 0;
                    break;
                case "up":
                    currentRow = --currentRow >= 0 ? currentRow : (screenMatrix.length - 1);
                    break;
                case "down":
                    currentRow = ++currentRow <= (screenMatrix.length - 1) ? currentRow : 0;
                    break;
            }

            String cellType = screenMatrix[currentRow][currentCol];
            if (cellType.equals("f")) {
                screenMatrix[currentRow][currentCol] = EMPTY_CELL;
                snakeLength++;
                totalFoodAmount--;

                if (totalFoodAmount == 0) {
                    System.out.println("You win! Final snake length is " + snakeLength);
                    return;
                }
            }

            if (cellType.equals("e")) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
        }

        /**Game Over*/
        System.out.println(String.format("You lose! There is still %d food to be eaten.", totalFoodAmount));
    }

    private static int[] fillScreenMatrix(BufferedReader reader, int sizeOfTheScreen, String[][] screenMatrix) throws IOException {
        int[] startEndPositionFoodCount = new int[3];
        int foodCounter = 0;

        for (int row = 0; row < sizeOfTheScreen; row++) {
            String[] tokens = reader.readLine().split("\\s+");

            for (int col = 0; col < sizeOfTheScreen; col++) {
                screenMatrix[row][col] = tokens[col];

                if (tokens[col].equals("f")) {
                    foodCounter++;
                    startEndPositionFoodCount[2] = foodCounter;
                }

                if (tokens[col].equals("s")) {
                    startEndPositionFoodCount[0] = row;
                    startEndPositionFoodCount[1] = col;
                }
            }
        }
        return startEndPositionFoodCount;
    }
}
