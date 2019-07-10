import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int pointOfPlayer = 18500;
        int pointOfHeigan = 3000000;

        int[][] matrix = new int[15][15];

        int positionOfPlayer = matrix[7][7];

        int[][] strikeMatrix = new int[3][3];

        double damageOnHaigan = Double.parseDouble(reader.readLine());

        String input = reader.readLine();
        while (true) {
            String[] data = input.split("\\s+");

            String strike = data[0];
            int row = Integer.parseInt(data[1]);
            int col = Integer.parseInt(data[2]);
            System.out.println(cloudMatrix(strikeMatrix, row, col));
            if (strike.equals("Cloud")){
                if (positionOfPlayer == matrix[row][col]) {
                    pointOfPlayer -= 3500;
                  pointOfHeigan -= damageOnHaigan;


                }
            }


            input = reader.readLine();

        }


    }
    private static boolean isInBoundDamage(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >=0 && col < matrix[row].length;
    }

    private static int[][] cloudMatrix (int[][] matrix, int row, int col) {
        int[][] cloudMatrixOfDamage = new int[3][3];

        for (int i = row - 1; i < row + 1 ; i++) {
            for (int j = col - 1; j < col + 1 ; j++) {
                cloudMatrixOfDamage[i][j] = matrix[i][j];
            }
        }
        return cloudMatrixOfDamage;
    }
}
