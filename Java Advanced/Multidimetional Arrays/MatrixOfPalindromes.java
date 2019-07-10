import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = new String[rows][cols];

        int first, mid ;
        for (int r = 0; r < rows ; r++) {
           mid = 'a' + r;
           first = 'a' + r;
            for (int c = 0; c < cols; c++) {
                    matrix[r][c] = String.valueOf((char)first);
                    matrix[r][c] += (char)mid;
                    matrix[r][c] += (char)first;
                mid++;

            }
        }
        printMatrix(matrix, rows, cols);

    }

    private static void printMatrix(String[][] matrix,int rows,int cols) {
        for (int row = 0; row < rows ; row++) {
            for (int col = 0; col < cols ; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

