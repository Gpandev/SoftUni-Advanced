import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximalSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] dimensional = reader.readLine().split("\\s+");

        int n = Integer.parseInt(dimensional[0]);
        int m = Integer.parseInt(dimensional[1]);

        int[][] matrix = new int[n][m];

        int sum = 0;
        int maxSum = -1;
        int a = 0;
        int b = 0;

        for (int r = 0; r < n ; r++) {
            matrix[r] = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int r = 0, c = 0;
        while (r + 3 <= n) {
            while (c + 3 <= m) {
                for (int i = r; i <= r + 2; i++) {
                    for (int j = c; j <= c + 2; j++) {
                        sum += matrix[i][j];
                    }
                }
                if (sum > maxSum) {
                    maxSum = sum;
                    a = r;
                    b = c;
                }
                sum = 0;

                c++;
            }
            r++;
            c = 0;
        }

        System.out.println("Sum = " + maxSum);

        for (int i = a ; i < a+ 3 ; i++) {
            for (int j = b; j < b + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
