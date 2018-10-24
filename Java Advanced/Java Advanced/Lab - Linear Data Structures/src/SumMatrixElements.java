import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumMatrixElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[][] matrix = readAndFillMatrix(reader);

        int sum = 0;
        for (int[] row : matrix) {
            for (int colNum : row) {
                sum += colNum;
            }
        }

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(sum);
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
