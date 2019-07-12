import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class MinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Integer> resource = new LinkedHashMap<>();


        String input = "";
        int counter = 1;
        int quantity = 0;
        String nameResource = "";
        while (!"stop".equals( input = reader.readLine())) {

            if (counter%2 == 1) {

                if (!resource.containsKey(input)){
                    resource.put(input, 0);

                }
                nameResource = input;

            } else {
                resource.put(nameResource, resource.get(nameResource) + Integer.parseInt(input));
            }
           counter++;

        }

        resource.entrySet().forEach(key -> {
            System.out.println(String.format("%s -> %d", key.getKey(), key.getValue()));
        });
    }
}
