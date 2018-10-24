import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Crossfire {
    private static final String END_COMMAND = "Nuke it from orbit";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> matrix = new ArrayList<>();
        int[] dimensions = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        fillTheMatrix(matrix, dimensions);

        String line;
        while (!END_COMMAND.equalsIgnoreCase(line = reader.readLine())) {
            int[] tokens = Arrays.stream(line.split("\\s")).mapToInt(Integer::parseInt).toArray();

            int coordRow = tokens[0];
            int coordCol = tokens[1];
            int radius = tokens[2];

            destroyCellsByColsInTheRadius(matrix, radius, coordRow, coordCol);
            destroyCellsByRowsInTheRadius(matrix, radius, coordRow, coordCol);
            removeAllDestroyedCells(matrix);
            removeAllEmptyRows(matrix);
        }

        printResult(matrix);
    }

    private static void printResult(List<List<Integer>> matrix) {
        StringBuilder resultBuilder = new StringBuilder();
        for (List<Integer> row : matrix) {
            for (Integer num : row) {
                resultBuilder.append(num).append(" ");
            }
            resultBuilder.append(System.lineSeparator());
        }
        System.out.println(resultBuilder.toString().trim());
    }

    private static void removeAllEmptyRows(List<List<Integer>> matrix) {
        for (int row = matrix.size() - 1; row >= 0; row--) {
            if (matrix.get(row).isEmpty()) {
                matrix.remove(row);
            }
        }
    }

    private static void removeAllDestroyedCells(List<List<Integer>> matrix) {
        for (int row = matrix.size() - 1; row >= 0; row--) {
            matrix.get(row).removeIf(cell -> cell == 0);

//            for (int col = matrix.get(row).size() - 1; col >= 0 ; col--) {
//                if (matrix.get(row).get(col) == 0) {
//                    matrix.get(row).remove(col);
//                }
//            }
        }
    }

    private static void destroyCellsByColsInTheRadius(List<List<Integer>> matrix, int radius, int coordRow, int coordCol) {
        int start = coordCol - radius;
        if (start < 0)
            start = 0;

        int end = coordCol + radius;

        for (int colIndex = start; colIndex <= end; colIndex++) {
            try {
                matrix.get(coordRow).set(colIndex, 0);
            } catch (Exception ignored) {}
        }
    }

    private static void destroyCellsByRowsInTheRadius(List<List<Integer>> matrix, int radius, int coordRow, int coordCol) {
        int start = coordRow - radius;
        if (start < 0)
            start = 0;

        int end = coordRow + radius;

        for (int rowIndex = start; rowIndex <= end; rowIndex++) {
            try {
                matrix.get(rowIndex).set(coordCol, 0);
            } catch (Exception ignored) {}
        }
    }

    private static void fillTheMatrix(List<List<Integer>> matrix, int[] dimensions) {
        int rows = dimensions[0];
        int cols = dimensions[1];
        int number = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(number);
                number++;
            }

        }
    }
}
