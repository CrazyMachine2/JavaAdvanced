package pokemon.trainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (true) {
            String input = scan.nextLine();

            if (input.equals("Tournament")) {
                break;
            }

            String[] data = input.split(" ");
            String name = data[0];
            String pokemonName = data[1];
            String element = data[2];
            int health = Integer.parseInt(data[3]);

            Trainer trainer = new Trainer(name);
            Pokemon pokemon = new Pokemon(pokemonName, element, health);

            if (!trainers.containsKey(name)) {
                trainers.put(name, trainer);
                trainers.get(name).getPokemons().add(pokemon);
            } else {
                trainers.get(name).getPokemons().add(pokemon);
            }
        }

        while (true) {
            String element = scan.nextLine();

            if (element.equals("End")) {
                break;
            }

            for (Map.Entry<String, Trainer> entry : trainers.entrySet()) {
                List<Pokemon> pokemons = entry.getValue().getPokemons();
                Trainer trainer = entry.getValue();

                boolean hasElement = false;

                for (Pokemon pokemon : pokemons) {
                    if (pokemon.getElement().equals(element)) {
                        hasElement = true;
                        break;
                    }
                }

                if (hasElement) {
                    trainer.giveBadge();
                } else {
                    for (Pokemon pokemon : pokemons) {
                        pokemon.loseHealth();
                    }
                    pokemons.removeIf(p -> p.getHealth() <= 0);
                }
            }
        }

        trainers.entrySet().stream()
                .sorted((t1, t2) -> Integer.compare(t2.getValue().getBadges(), t1.getValue().getBadges()))
                .forEach(entry -> System.out.printf("%s %d %d%n"
                        , entry.getKey(), entry.getValue().getBadges(), entry.getValue().getPokemons().size()));


        List<Trainer> trainerList = new ArrayList<>();

        for(Map.Entry<String,Trainer> entry : trainers.entrySet()){
            trainerList.add(entry.getValue());
        }

        trainerList.stream().sorted((t1,t2) -> t1.getBadges().compareTo(t2.getBadges()))
                .forEach(p ->System.out.printf("%s %d %d%n",p.getName(),p.getBadges(),p.getPokemons().size() ));
    }
}