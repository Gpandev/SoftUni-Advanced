import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class PredicateParty {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        String command = scanner.nextLine();


        while (!command.equals("Party!")) {
            String[] data  = command.split("\\s+");

            Predicate<String> predicate = createPredicate(data[1], data[2]);

            if (data[0].equals("Remove")) {
               names.removeIf(predicate);
            }else {
                ArrayList<String> namesToAdd = new ArrayList<>();

                names.forEach(name -> {
                    if (predicate.test(name)){
                        namesToAdd.add(name);
                    }
                });

                names.addAll(namesToAdd);
            }

            command = scanner.nextLine();
        }

        Collections.sort(names);

        System.out.println(names.size() == 0 ?
                "Nobody is going to the party!" :
                String.join(", ", names) + " are going to the party!");

    }

    public static Predicate<String> createPredicate (String type, String element) {

        Predicate<String> predicate;

        switch (type) {
            case "StartsWith":
                predicate = str -> str.startsWith(element);
                break;
            case "EndsWith":
                predicate = str -> str.endsWith(element);
                break;
            default:
                predicate = str -> str.length() == Integer.parseInt(element);
                break;
        }

        return predicate;
    }
}
