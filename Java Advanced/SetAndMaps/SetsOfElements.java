import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class SetsOfElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] input = reader.readLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        LinkedHashSet<Integer> firstElements = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondElements = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(reader.readLine());
            firstElements.add(num);
        }

        for (int i = 0; i < m ; i++) {
            int num = Integer.parseInt(reader.readLine());
            secondElements.add(num);
        }

        firstElements.retainAll(secondElements);

        firstElements.forEach(number -> System.out.print(number + " "));

    }
}
