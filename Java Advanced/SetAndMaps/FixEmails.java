import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        LinkedHashMap<String, String> namesAndEmails = new LinkedHashMap<>();

        String name = "";
        int count = 1;
        while (!input.equals("stop")) {

            if (count%2 == 1) {
                if (!namesAndEmails.containsKey(input)) {
                    namesAndEmails.put(input, "");
                    name = input;
                }
            }else {
                String endEmails = input.substring(input.lastIndexOf('.') + 1);

                if (!(endEmails.equals("us") || endEmails.equals("com") || endEmails.equals("uk"))) {
                    namesAndEmails.put(name, input);
                } else {
                    namesAndEmails.remove(name);
                }
            }

            input = reader.readLine();
            count++;
        }


        namesAndEmails.entrySet().forEach(e -> {
            System.out.println(String.format("%s -> %s",e.getKey(),e.getValue()));
        });
    }
}
