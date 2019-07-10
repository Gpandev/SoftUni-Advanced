import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HotPotato {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> players = new ArrayDeque<>();

        List<String> gamePlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        int rotations = Integer.parseInt(scanner.nextLine());

        int i = 0;
        while (gamePlayer.size() > 0) {

            i = (i + rotations - 1) % gamePlayer.size();

            players.offer(gamePlayer.get(i));
            gamePlayer.remove(i);
        }

        while (players.size() > 1) {
            System.out.println(String.format("Removed %s",
                    players.poll()));
        }

        System.out.println(String.format("Last is %s",
                players.peek()));

    }
}
