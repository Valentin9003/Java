    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.stream.Collectors;

    public class Crossfire_Test_With_ArrayMatrix {

        private static final int DESTROY = 0;
        private static final String END_COMMAND = "Nuke it from orbit";

        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int[][] matrix = fillTheMatrix(reader);

            String line;
            while (!END_COMMAND.equalsIgnoreCase(line = reader.readLine())) {
                String[] tokens = line.split("\\s+");

                int x = Integer.parseInt(tokens[0]);
                int y = Integer.parseInt(tokens[1]);
                int radius = Integer.parseInt(tokens[2]);

                //Destroy all cells in the given radius (matrix[x][y] = 0;)
                destroyAfectedColumsCellsInTheGivenRadius(matrix, x, y, radius);
                destroyAfectedRowsCellsInTheGivenRadius(matrix, x, y, radius);

                //Deleting all cells which are destroyed (matrix[x][y] = 0;)
                deleteZeroedCells(matrix);
            }
            printTheMatrix(matrix);
        }

        private static void destroyAfectedRowsCellsInTheGivenRadius(int[][] matrix, int x, int y, int radius) {
            int startRow = x - radius;
            if (startRow < 0)
                startRow = 0;

            int endRow = x + radius;
            if (endRow > matrix.length - 1)
                endRow = matrix.length - 1;

            for (int r = startRow; r <= endRow; r++) {
                try {
                    matrix[r][y] = DESTROY;
                } catch (IndexOutOfBoundsException ignored) {}
            }
        }

        private static void destroyAfectedColumsCellsInTheGivenRadius(int[][] matrix, int x, int y, int radius) {
            int startCol = y - radius;
            if (startCol < 0)
                startCol = 0;

            int endCol = y + radius;
            if (endCol > matrix[0].length - 1)
                endCol = matrix[0].length - 1;

            for (int c = startCol; c <= endCol; c++) {
                try {
                    matrix[x][c] = DESTROY;
                } catch (IndexOutOfBoundsException ignored) {}
            }
        }

        private static void deleteZeroedCells(int[][] matrix) {
            for (int row = 0; row < matrix.length; row++) {
                if (checkIfAllRowCellsAreEqualsToZero(matrix, row)) {
                    matrix = removeEmptyRow(matrix, row);
                }
                for (int col = 0; col < matrix[0].length; col++) {
                    if (matrix[row][col] == 0) {
                        moveAllRowNumbersOnLeft(matrix, row, col);
                    }
                }
            }
        }

        private static int[][] removeEmptyRow(int[][] matrix, int row) {
            int newRows = calculateNewMatrixRows(matrix);
            int[][] newMatrix = new int[newRows][matrix[0].length];
            int newMatrixRow = 0;
            for (int oldMatrixRow = 0; oldMatrixRow < matrix.length; oldMatrixRow++) {
                if (checkIfAllRowCellsAreEqualsToZero(matrix, oldMatrixRow)) {
                    continue;
                }
                for (int oldMatrixCol = 0; oldMatrixCol < matrix[0].length; oldMatrixCol++) {
                    newMatrix[newMatrixRow][oldMatrixCol] = matrix[oldMatrixRow][oldMatrixCol];
                }
                newMatrixRow++;
            }

//            int[][] matrx =
//                    Arrays.stream(matrix)
//                            .filter(m -> checkIfAllRowCellsAreEmpty(m))
//                            .m
//                    .toArray(Integer[][]::new);

            return newMatrix;
        }

        private static boolean checkIfAllRowCellsAreEmpty(int[] m) {
            long sum = Arrays.stream(m).mapToLong(Long::valueOf).sum();
            return sum != 0;
        }

        private static int calculateNewMatrixRows(int[][] matrix) {
            int counter = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (!checkIfAllRowCellsAreEqualsToZero(matrix, i)) {
                    counter++;
                }
            }
            return counter;
        }

        private static boolean checkIfAllRowCellsAreEqualsToZero(int[][] matrix, int row) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] != 0) {
                    return false;
                }
            }
            return true;
        }

        private static void moveAllRowNumbersOnLeft(int[][] matrix, int row, int col) {
            while (true) {
                for (int i = col; i < matrix[0].length; i++) {
                    try {
                        matrix[row][i] = matrix[row][i + 1];
                    } catch (IndexOutOfBoundsException ioobe) {
                        matrix[row][i] = 0;
                    }
                }

                boolean allZeroesAreInRight =
                        getIndexOnFirstZeroAndCheckInRightAllCellsAreZero(matrix, matrix[row], col);
                if (allZeroesAreInRight) {
                    return;
                }

            }

            //EXAMPLE
            /**coming matrix  -->  returned matrix
             * 1  2  0  4  5  -->  1  2  4  5  0
             * 6  0  0  0 10  -->  6 10  0  0  0
             * 11 12 0 14 15  -->  11 12 14 15 0*/
        }

        private static boolean getIndexOnFirstZeroAndCheckInRightAllCellsAreZero(int[][] matrix, int[] matrix1, int col) {
            int indexOnFirstZero = 0;
            for (int i = col; i < matrix[0].length; i++) {
                if (matrix1[i] == 0) {
                    indexOnFirstZero += i;
                    break;
                }
            }

            boolean allZeroesAreInRight = true;
            for (int i = indexOnFirstZero; i < matrix[0].length; i++) {
                if (matrix1[i] != 0) {
                    allZeroesAreInRight = false;
                }
            }
            return allZeroesAreInRight;
        }

        private static int[][] fillTheMatrix(BufferedReader reader) throws IOException {
            String[] dimensions = reader.readLine().split("\\s+");
            int rowsCount = Integer.parseInt(dimensions[0]);
            int colsCount = Integer.parseInt(dimensions[1]);

            int num = 1;
            int[][] matrix = new int[rowsCount][colsCount];
            for (int row = 0; row < rowsCount; row++) {
                for (int col = 0; col < colsCount; col++) {
                    matrix[row][col] = num;
                    num++;
                }
            }
            return matrix;
        }

        private static void printTheMatrix(int[][] matrix) {
            /**Printing the matrix, without printing positions equals to 0*/
            for (int[] ints : matrix) {
                boolean emptyRow = true;
                for (int number : ints) {
                    if (number != 0) {
                        System.out.print(number + " ");
                        emptyRow = false;
                    }
                }
                /**If all cols on the current row are equals to 0,
                 * don't printing empty line*/
                if (!emptyRow) {
                    System.out.println();
                }
            }
        }
    }
