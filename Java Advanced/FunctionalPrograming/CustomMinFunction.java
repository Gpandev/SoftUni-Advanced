import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.lang.System.in;

public class CustomMinFunction {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> minNumber = arr -> {

           int min = Arrays.stream(arr).min().getAsInt();

                return min;
        };

        System.out.println(minNumber.apply(numbers));
    }
}
