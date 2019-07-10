import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixShuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] dimensional = reader.readLine().split("\\s+");

        int rows = Integer.parseInt(dimensional[0]);
        int cols = Integer.parseInt(dimensional[1]);

        String[][] matrix = new String[rows][cols];

        for (int r = 0; r < rows ; r++) {
            matrix[r] = reader.readLine().split("\\s+");

        }

        String[] input = reader.readLine().split("\\s+");



        while (!input[0].equals("END")) {


            if (input[0].equals("swap") && input.length == 5) {
                int row1 = Integer.parseInt(input[1]);
                int col1 = Integer.parseInt(input[2]);
                int row2 = Integer.parseInt(input[3]);
                int col2 = Integer.parseInt(input[4]);

                if (row1 < rows && col1 < cols && row2 < rows && col2 < cols) {
                    swapMatrixElements(matrix, row1, col1, row2, col2);

                    printMatrix(matrix, rows, cols);
                }else {
                    System.out.println("Invalid input!");
                }

            } else {
                System.out.println("Invalid input!");
            }


            input = reader.readLine().split("\\s+");
        }
    }

    private static void swapMatrixElements(String[][] matrix,
                                           int row1, int col1, int row2, int col2) {


        String swapFirst = "";
        String swapSecond = "";

        swapFirst = matrix[row1][col1];
        swapSecond = matrix[row2][col2];
        matrix[row1][col1] = swapSecond;
        matrix[row2][col2] = swapFirst;

    }


    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows ; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
