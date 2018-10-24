import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[][] matrix = readAndFillMatrix(reader);

        int bestSum = Integer.MIN_VALUE;

        int rowIndex = 0;
        int colIndex = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int curentSum = matrix[row][col] + matrix[row][col + 1]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (curentSum > bestSum) {
                    bestSum = curentSum;
                    rowIndex = row;
                    colIndex = col;
                }
            }
        }

        for (int i = rowIndex; i < rowIndex + 2; i++) {
            for (int j = colIndex; j < colIndex + 2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(bestSum);
    }

    private static int[][] readAndFillMatrix(BufferedReader reader) throws IOException {
            String[] dimensions = reader.readLine().split(", ");
            int rows = Integer.parseInt(dimensions[0]);
            int cols = Integer.parseInt(dimensions[1]);

            int[][] matrix = new int[rows][cols];

            for (int row = 0; row < matrix.length; row++) {
                int[] numbers = Arrays.stream(reader.readLine()
                        .split(", "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                for (int col = 0; col < matrix[row].length; col++) {
                    matrix[row][col] = numbers[col];
                }
            }
            return matrix;
        }
}
