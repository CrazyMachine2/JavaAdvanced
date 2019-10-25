package pokemon.trainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private Integer badges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBadges() {
        return badges;
    }

    public void giveBadge() {
        this.badges++;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
