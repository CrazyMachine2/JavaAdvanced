import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Long.*;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Long>> citiesOfCountry = new LinkedHashMap<>();
        Map<String, Long> countryPopulation = new LinkedHashMap<>();

        while (true) {
            String input = scan.nextLine();

            if (input.equals("report")) {
                break;
            }

            String[] data = input.split("\\|");
            String city = data[0];
            String country = data[1];
            long population = Integer.parseInt(scan.nextLine());

            if (!citiesOfCountry.containsKey(country)) {
                citiesOfCountry.put(country, new LinkedHashMap<>());
                citiesOfCountry.get(country).put(city, population);
                countryPopulation.put(country, population);
            } else {
                if (!citiesOfCountry.get(country).containsKey(city)) {
                    citiesOfCountry.get(country).put(city, population);
                    countryPopulation.put(country, countryPopulation.get(country) + population);
                }
            }
        }

        countryPopulation.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> {
                    System.out.printf("%s (total population: %d)%n", entry.getKey(), entry.getValue());

                    citiesOfCountry.get(entry.getKey()).entrySet().stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                            .forEach(entry1 -> System.out.printf("=>%s: %d%n", entry1.getKey(), entry1.getValue()));
                });
    }
}
