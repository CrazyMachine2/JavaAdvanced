import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,Map<String,List<String>>> countriesByContinent = new LinkedHashMap<>();
        int num = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < num; i++) {
            String[] input = scan.nextLine().split(" ");

            String continent = input[0];
            String country = input[1];
            String city = input[2];

            if (!countriesByContinent.containsKey(continent)){
                countriesByContinent.put(continent,new LinkedHashMap<>());
            }
            if(!countriesByContinent.get(continent).containsKey(country)){
                countriesByContinent.get(continent).put(country,new ArrayList<>());
                countriesByContinent.get(continent).get(country).add(city);
            } else {
                countriesByContinent.get(continent).get(country).add(city);
            }
        }

        for (Map.Entry<String,Map<String,List<String>>> entry : countriesByContinent.entrySet()){
            System.out.printf("%s:%n",entry.getKey());
            for (Map.Entry<String,List<String>> entry1 : countriesByContinent.get(entry.getKey()).entrySet()){
                System.out.printf("%s -> ",entry1.getKey());
                for (int i = 0; i < entry1.getValue().size(); i++) {
                    if(i == entry1.getValue().size() -1){
                        System.out.printf("%s",entry1.getValue().get(i));
                    } else {
                        System.out.printf("%s, ",entry1.getValue().get(i));
                    }
                }
                System.out.println();
            }
        }
    }
}
