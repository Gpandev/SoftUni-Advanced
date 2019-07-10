import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class InfixToPostfix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] sequence = reader.readLine().split(" ");

        for (int i = 0; i < sequence.length; i++) {
            if (!"-+/*()".contains(sequence[i])) {
                queue.offer(sequence[i]);
            } else if (sequence[i].equals("(")) {
                stack.push(sequence[i]);
            } else if (sequence[i].equals(")")) {

                while (!stack.peek().equals("(")) {
                    queue.offer(stack.pop());
                }
                stack.pop();
            } else {
                if ("+-".contains(sequence[i])) {
                    while (!stack.isEmpty() && !stack.peek().equals("(")){
                        queue.offer(stack.pop());
                    }
                } else {
                    while (!stack.isEmpty() && !"+-(".contains(stack.peek())) {
                        queue.offer(stack.pop());
                    }
                }

                stack.push(sequence[i]);
            }

        }

        while (!stack.isEmpty()){
            queue.offer(stack.pop());
        }
        System.out.println(String.join(" ", queue));

    }
}
