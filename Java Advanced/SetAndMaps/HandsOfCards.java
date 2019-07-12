import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class HandsOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        LinkedHashMap<String, HashSet<String>> players = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] data = input.split(": ");

            String name = data[0];

            String[] cards = data[1].split(", ");

            if (!players.containsKey(name)) {
                players.put(name, new HashSet<>(){{addAll(Arrays.asList(cards));}});
            } else {
                players.get(name).addAll(Arrays.asList(cards));
            }

            input = reader.readLine();
        }

        for (Map.Entry<String, HashSet<String>> entry : players.entrySet()) {

            int deckPower = calculatePower(entry.getValue());

            System.out.println(String.format("%s: %d", entry.getKey(), deckPower));

        }

    }

    private static int calculatePower(HashSet<String> deck) {

        int sumPower = 0;

        for (String card : deck) {
            int power = 0;
            if (Character.isDigit(card.charAt(0)) && card.charAt(0) != '1') {
                power += card.charAt(0) - '0';
            } else {
                switch (card.charAt(0)){
                    case '1':
                        power +=10;
                        break;
                    case 'J':
                        power += 11;
                        break;
                    case 'Q':
                        power += 12;
                        break;
                    case 'K':
                        power += 13;
                        break;
                    case 'A':
                        power += 14;
                        break;
                }
            }

            switch (card.charAt(card.length() - 1)){
                case 'S':
                    power *= 4;
                    break;
                case 'H':
                    power *= 3;
                    break;
                case 'D':
                    power *= 2;
                    break;
            }

            sumPower += power;
        }
        return sumPower;
    }
}
