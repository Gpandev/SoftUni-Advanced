import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputText = reader.readLine();

        TreeMap<Character, Integer> symbolsCount = new TreeMap<>();

        for (int i = 0; i < inputText.length() ; i++) {
            char symbol = inputText.charAt(i);

            if (!symbolsCount.containsKey(symbol)) {
                symbolsCount.put(symbol, 1);
            } else {
                symbolsCount.put(symbol, symbolsCount.get(symbol) + 1);
            }
        }

        for (Map.Entry<Character, Integer> kvp : symbolsCount.entrySet()) {
            System.out.printf("%c: %d time/s%n",kvp.getKey(), kvp.getValue());
        }

    }
}
