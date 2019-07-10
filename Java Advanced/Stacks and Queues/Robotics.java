import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Robotics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(";");

        String[] robots = new String[input.length];
        int[] processTime = new int[input.length];
        int[] workTime = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            String[] data = input[i].split("-");
            String name = data[0];
            int time = Integer.parseInt(data[1]);

            robots[i] = name;
            processTime[i] = time;
        }

        String startTime = reader.readLine();

        ArrayDeque<String> product = new ArrayDeque<>();

        String inputProduct = reader.readLine();

        while (!inputProduct.equals("End")) {
            product.offer(inputProduct);

            inputProduct = reader.readLine();
        }


    }
}
