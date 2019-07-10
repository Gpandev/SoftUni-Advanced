import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringMatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] input = reader.readLine().split("[()]");
        int degreeRotate = Integer.parseInt(input[1]) % 360;
        List<String> text = new ArrayList<>();
        String nextText = "";

        int textLenght = 0;
        while (!"END".equals(nextText = reader.readLine())) {
            text.add(nextText);

            if (nextText.length() > textLenght) {
                textLenght = nextText.length();
            }
        }

        char[][] matrix = new char[text.size()][textLenght];
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < textLenght ; col++) {
                if (text.get(row).length() <= col) {
                    matrix[row][col] = ' ';
                } else {
                    matrix[row][col] = text.get(row).charAt(col);
                }
            }
        }

        if (degreeRotate == 90) {
            int rotateRows = matrix[0].length;
            int rotateCols = matrix.length;
            char[][] rotateMatrix = new char[rotateRows][rotateCols];
            for (int row = 0; row < matrix[0].length; row++) {
                for (int col = 0; col < matrix.length ; col++) {
                    rotateMatrix[row][(rotateCols-1) -col] = matrix[col][row];
                }
            }
            printMatrix(rotateMatrix);

        } else if (degreeRotate == 180){
            char[][] rotateMatrix = new char[matrix.length][matrix[0].length];
            for (int row = matrix.length - 1; row >= 0; row--) {
                for (int col = 0; col < matrix[0].length ; col++) {
                    rotateMatrix[row][col] =
                            matrix[matrix.length - row - 1][matrix[0].length - col -1];
                }
            }
            printMatrix(rotateMatrix);

        } else if (degreeRotate == 270){
            int rotateRows = matrix[0].length;
            int rotateCols = matrix.length;
            char[][] rotateMatrix = new char[rotateRows][rotateCols];
            for (int row = 0; row < matrix.length ; row++) {
                for (int col = 0; col < matrix[0].length ; col++) {
                    rotateMatrix[(rotateRows - 1) - col][row] = matrix[row][col];
                }
            }
            printMatrix(rotateMatrix);

        } else {
            printMatrix(matrix);
        }



    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length ; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
