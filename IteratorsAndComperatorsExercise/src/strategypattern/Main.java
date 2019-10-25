package strategypattern;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Set<Person> peopleByEquality = new TreeSet<>();
        Set<Person> peopleByHash = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split(" ");
            Person person = new Person(data[0],Integer.parseInt(data[1]));
            peopleByEquality.add(person);
            peopleByHash.add(person);
        }

        System.out.println(peopleByEquality.size());
        System.out.println(peopleByHash.size());

    }
}
