import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FillTheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(", ");

        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix;

        if (pattern.equals("A")) {
            matrix = generateMatrixPatternA(size);
        } else {
            matrix = generateMatrixPatternB(size);
        }

        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length ; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] generateMatrixPatternB(int size) {
        int[][] matrix = new int[size][size];

        int value = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix [row][col] = value;
                    value++;
                }
            } else {
                for (int row = size - 1; row >= 0 ; row--) {
                    matrix[row][col] = value;
                    value++;
                }
            }
        }


        return matrix;
    }

    private static int[][] generateMatrixPatternA(int size) {
        int[][] matrix = new int[size][size];

        int value = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size ; row++) {
                matrix[col][row] = value;
                value++;
            }
        }

        return matrix;
    }
}
