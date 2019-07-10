import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Crossfire {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] dimension = reader.readLine().split("\\s+");
        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        int element = 1;
        for (int row = 0; row < rows ; row++) {
            ArrayList<Integer> r = new ArrayList<>();
            for (int col = 0; col < cols ; col++) {
                r.add(element);
                element++;
            }
            matrix.add(r);
        }

        String input = "";
        while (!"Nuke it from orbit".equals(input = reader.readLine())){
            String[] cordinats = input.split("\\s+");

            int indexRow = Integer.parseInt(cordinats[0]);
            int indexCol = Integer.parseInt(cordinats[1]);
            int bomb = Integer.parseInt(cordinats[2]);

            for (int row = indexRow - bomb; row <= indexRow + bomb ; row++) {
                if (isInMatrix(matrix,indexCol, row)) {
                    matrix.get(row).set(indexCol, 0);
                }
            }
            for (int col = indexCol - bomb; col <= indexCol + bomb  ; col++) {
                if (isInMatrix(matrix, indexRow, col)) {
                    matrix.get(indexRow).set(col, 0);
                }
            }

            for (int row = 0; row < matrix.size(); row++) {
                matrix.set(row, matrix.get(row)
                        .stream()
                        .filter(e -> e !=0)
                        .collect(Collectors.toCollection(ArrayList::new)));

                if (matrix.get(row).size() == 0) {
                    matrix.remove(row);
                    row--;
                }
            }
        }


        printMatrix(matrix);
    }

    private static boolean isInMatrix(ArrayList<ArrayList<Integer>> matrix, int row, int indexCol) {
        return row >= 0
                && row < matrix.size()
                && indexCol >=0
                && indexCol < matrix.get(row).size();
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size() ; col++) {
                System.out.print(matrix.get(row).get(col) + " ");
            }
            System.out.println();
        }
    }



}
