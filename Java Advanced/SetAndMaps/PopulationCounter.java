import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        LinkedHashMap<String, LinkedHashMap<String, Long>> populationCount = new LinkedHashMap<>();

        while (!input.equals("report")) {

            String[] data = input.split("\\|");

            String city = data[0];
            String country = data[1];
            long population = Long.parseLong(data[2]);

            if (!populationCount.containsValue(country)) {
                populationCount.put(country, new LinkedHashMap<>(){{put(city,population);}});
            } else {
                populationCount.get(country).putIfAbsent(city,population);
            }

            input = reader.readLine();
        }

        populationCount.entrySet().stream()
                .sorted((f, s) -> {
                  Long firstP =  populationCount.get(f.getKey())
                            .values()
                            .stream()
                            .mapToLong(i -> i)
                            .sum();

                  Long secondP =  populationCount.get(s.getKey())
                            .values()
                            .stream()
                            .mapToLong(i -> i)
                            .sum();

                  return secondP.compareTo(firstP);

                }).forEach(entry -> {
            System.out.println(String.format("%S (total population: %d)",entry.getKey(),entry.getValue()
                    .values()
                    .stream().mapToLong(value -> value).sum()));

            entry.getValue().entrySet()
                    .stream()
                    .sorted((f,s) -> s.getValue().compareTo(f.getValue()))
                    .forEach(e -> {
                        System.out.println(String.format("=>%s: %d",e.getKey(),e.getValue()));
                    });
        });

    }
}
