import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfCommands = Integer.parseInt(reader.readLine());

        String text = "";

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands ; i++) {
            String[] input = reader.readLine().split("\\s+");

            int command = Integer.parseInt(input[0]);


            switch (command) {
                case 1:
                    stack.push(text);
                    text += input[1];

                    break;
                case 2:
                    stack.push(text);
                    int erasesChars = Integer.parseInt(input[1]);
                    text = text.substring(0, text.length() - erasesChars);


                    break;
                case 3:
                    int indexForPrint = Integer.parseInt(input[1]);
                    System.out.println(text.charAt(indexForPrint - 1));

                    break;
                case 4:
                    text = stack.pop();
                    break;

            }
        }
    }
}
