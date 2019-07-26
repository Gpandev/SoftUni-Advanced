
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

import static java.lang.System.in;

public class ConsumerPrint {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(in);


        Consumer<String> printer = word -> System.out.println(word);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(printer);

    }
}
