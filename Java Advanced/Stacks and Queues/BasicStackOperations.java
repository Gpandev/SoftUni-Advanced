import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;

public class BasicStackOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] param = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int elementsCount = param[0];
        int elementsToPop = param[1];
        int searchingElement = param[2];

        ArrayDeque<Integer> stackNum = new ArrayDeque<>();

        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(elementsCount)
                .forEach(stackNum::push);


        while (elementsToPop -- > 0){
            stackNum.pop();
        }

        if (stackNum.contains(searchingElement)) {
            System.out.println("true");
        } else {
            if (stackNum.size() == 0){
                System.out.println(0);
            } else {
                System.out.println(Collections.min(stackNum));
            }
        }
    }
}
