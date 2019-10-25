package strategypattern;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int nameCompare = Integer.compare(o1.getName().length(),o2.getName().length());

        if (nameCompare != 0){
            return nameCompare;
        } else {
            int char1 = o1.getName().toLowerCase().charAt(0);
            int char2 = o2.getName().toLowerCase().charAt(0);
            return Integer.compare(char1,char2);
        }

    }
}
