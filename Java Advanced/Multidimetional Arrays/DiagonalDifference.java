import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size ; row++) {
            String[] line = reader.readLine().split("\\s+");
            for (int col = 0; col < line.length ; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }

        int row = 0;
        int col = 0;
        int sumFirstDiagonal = 0;
        while (row < size && col < size) {
            sumFirstDiagonal += matrix[row][col];
            row++;
            col++;
        }

        row--;
        col = 0;
        int sumSecondDiagonal = 0;
        while (row >=0 && col < size) {
            sumSecondDiagonal += matrix[row][col];
            row--;
            col++;
        }
        System.out.println(Math.abs(sumFirstDiagonal - sumSecondDiagonal));
    }
}
