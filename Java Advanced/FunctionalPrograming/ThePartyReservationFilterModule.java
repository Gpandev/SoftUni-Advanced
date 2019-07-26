import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Predicate;


public class ThePartyReservationFilterModule {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

        String command = scanner.nextLine();

        HashMap<String, Predicate<String>> predicates = new HashMap<>();

        while (!command.equals("Print")) {

            String[] data = command.split(";");

            String type = data[1];

            String param = data[2];

            String filterName = type + param;


            if (command.equals("Add")){

                Predicate<String> predicate;

                if (type.contains("Starts")){
                    predicate = str -> str.startsWith(param);
                }else if (type.contains("Ends")) {
                    predicate = str -> str.endsWith(param);
                }else if (type.contains("Length")) {
                    predicate = str -> str.length() == Integer.parseInt(param);
                }else {
                    predicate = str -> str.contains(param);
                }

                predicates.putIfAbsent(filterName, predicate);

            } else {
                predicates.remove(filterName);
            }

            command = scanner.nextLine();
        }


        Arrays.stream(names).forEach(name-> {
            boolean[] hasToBeFiltered = new boolean[1];
            predicates.forEach((key,value) -> {
                if(value.test(name)){
                    hasToBeFiltered[0] = true;
                }
            });
            if (!hasToBeFiltered[0]) {
                System.out.println(name + " ");
            }

        });

    }
}
