import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shockwave {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long[][] matrix = createTheMatrix(reader);

        String line;
        while (!"Here We Go".endsWith(line = reader.readLine())) {
            increaseValueOfEachPlateInAreaWithGivenCoords(matrix, line);
        }

        printTheMatrix(matrix);

    }

    private static void increaseValueOfEachPlateInAreaWithGivenCoords(long[][] matrix, String line) {
        String[] tokens = line.split("\\s+");
        int x1 = Integer.parseInt(tokens[0]);
        int x2 = Integer.parseInt(tokens[1]);
        int y1 = Integer.parseInt(tokens[2]);
        int y2 = Integer.parseInt(tokens[3]);

        for (int row = x1; row <= y1 ; row++) {
            for (int col = x2; col <= y2 ; col++) {
                matrix[row][col] += 1;
            }
        }
    }

    private static void printTheMatrix(long[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static long[][] createTheMatrix(BufferedReader reader) throws IOException {
            String[] dimensions = reader.readLine().split(" ");
            int rows = Integer.parseInt(dimensions[0]);
            int cols = Integer.parseInt(dimensions[1]);

            long[][] matrix = new long[rows][cols];

            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    matrix[row][col] = 0;
                }
            }
            return matrix;
        }

}
