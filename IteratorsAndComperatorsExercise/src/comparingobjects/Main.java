package comparingobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        List<Person> people = new ArrayList<>();

        while (true){
            String input = scan.nextLine();

            if (input.equals("END")){
                break;
            }

            String[] data = input.split("\\s+");

            Person person = new Person (data[0],Integer.parseInt(data[1]),data[2]);
            people.add(person);
        }
        int n = Integer.parseInt(scan.nextLine());
        Person comparePerson = people.get(n - 1);

        int equalPeopleCount = (int)people.stream().filter(p -> p.compareTo(comparePerson) == 0)
                .count();

        if(equalPeopleCount == 1){
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d",equalPeopleCount,
                    people.size() - equalPeopleCount, people.size());
        }
    }
}






















