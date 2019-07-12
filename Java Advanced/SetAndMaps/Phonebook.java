import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, String> phonebook = new LinkedHashMap<>();

        String input = "";

        while (!"search".equals( input = reader.readLine())) {
            String[] data = input.split("-");

            String name = data[0];
            String phoneNumber = data[1];

            phonebook.put(phonebook.getOrDefault(name, name), phoneNumber);

        }

        while (!"stop".equals(input = reader.readLine())) {

            if (phonebook.containsKey(input)) {
                System.out.println(String.format("%s -> %s",input, phonebook.get(input)));
            } else {
                System.out.println(String.format("Contact %s does not exit.", input));
            }

        }
    }
}
