import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;

public class BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().split("\\s+");

        int numberOfElement = Integer.parseInt(elements[0]);
        int numOfElementToPoll = Integer.parseInt(elements[1]);
        int lookingForElement = Integer.parseInt(elements[2]);

        ArrayDeque<Integer> numbersQueue = new ArrayDeque<>();

        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(numberOfElement)
                .forEach(numbersQueue::offer);

        while (numOfElementToPoll-- > 0) {
            numbersQueue.poll();
        }
        if (numbersQueue.contains(lookingForElement)) {
            System.out.println("true");
        } else {
            if (numbersQueue.size() == 0){
                System.out.println(0);
            } else {
                System.out.println(Collections.min(numbersQueue));
            }
        }

    }
}
