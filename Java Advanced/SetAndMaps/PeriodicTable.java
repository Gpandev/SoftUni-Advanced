import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        TreeSet<String> elements = new TreeSet<>();

        while (n-- > 0) {
            String[] data = reader.readLine().split("\\s+");

            Collections.addAll(elements, data);
        }

        elements.forEach(element -> System.out.print(element + " "));

    }
}
