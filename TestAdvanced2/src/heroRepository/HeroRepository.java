package heroRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HeroRepository {
    private List<Hero> data;

    public HeroRepository() {
        this.data = new ArrayList<>();
    }

    public void add (Hero hero){
        this.data.add(hero);
    }

    public void remove(String name){
        this.data.removeIf(h -> h.getName().equals(name));
    }

    public Hero getHeroWithHighestStrength(){
       return this.data.stream()
               .sorted((h1,h2) -> Integer.compare(h2.getItem().getStrength(),h1.getItem().getStrength()))
               .findFirst()
               .get();
    }

    public Hero getHeroWithHighestAgility(){
        return this.data.stream()
                .sorted((h1,h2) -> Integer.compare(h2.getItem().getAgility(),h1.getItem().getAgility()))
                .findFirst()
                .get();
    }

    public Hero getHeroWithHighestIntelligence(){
        return this.data.stream()
                .sorted((h1,h2) -> Integer.compare(h2.getItem().getIntelligence(),h1.getItem().getIntelligence()))
                .findFirst()
                .get();
    }

    public int getCount(){
        return this.data.size();
    }

    @Override
    public String toString() {
     String str = "";

     for (Hero hero : this.data){
         str += hero.toString();
     }
     return str;
    }
}
