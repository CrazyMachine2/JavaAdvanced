package google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String,Person> people = new HashMap<>();

        while (true){
            String input = scan.nextLine();

            if (input.equals("End")){
                break;
            }

            String[] data = input.split(" ");
            String name = data[0];

            if(!people.containsKey(name)){
                Person person = new Person();
                person = getPersonsInformation(data,person);
                people.put(name,person);

            } else {
                Person person = people.get(name);
                person = getPersonsInformation(data,person);
                people.put(name,person);
            }
        }

        String searchedPerson = scan.nextLine();
        printInformation(people.get(searchedPerson));

    }

    private static void printInformation(Person person) {

        System.out.println(person.getName());
        System.out.println("Company:");

        if (person.getCompany() != null){
            System.out.println(person.getCompany().toString());
        }

        System.out.println("Car:");
        if (person.getCar() != null){
            System.out.println(person.getCar().toString());
        }

        System.out.println("Pokemon:");
        if (!person.getPokemons().isEmpty()){
            for (Pokemon pokemon : person.getPokemons()){
                System.out.println(pokemon.toString());
            }
        }

        System.out.println("Parents:");
        if (!person.getParents().isEmpty()){
            for (Parent parent : person.getParents()){
                System.out.println(parent.toString());
            }
        }
        System.out.println("Children:");
        if (!person.getChildren().isEmpty()){
            for (Kid kid : person.getChildren()){
                System.out.println(kid.toString());
            }
        }

    }

    private static Person getPersonsInformation(String[] data, Person man) {
        Person person = man;
        person.setName(data[0]);

        switch (data[1]){
            case "company":
                String companyName = data[2];
                String department = data[3];
                double salary = Double.parseDouble(data[4]);
                Company company = new Company(companyName,department,salary);

                person.setCompany(company);

                break;
            case "pokemon":
                String pokemonName = data[2];
                String pokemonType = data[3];
                Pokemon pokemon = new Pokemon(pokemonName,pokemonType);

                person.getPokemons().add(pokemon);

                break;
            case "parents":
                String parentName = data[2];
                String parentBirthday = data[3];
                Parent parent = new Parent (parentName,parentBirthday);

                person.getParents().add(parent);


                break;
            case "children":
                String kidName = data[2];
                String kidBirthday = data[3];
                Kid kid = new Kid(kidName,kidBirthday);

                person.getChildren().add(kid);


                break;
            case "car":
                String model = data[2];
                int speed = Integer.parseInt(data[3]);
                Car car = new Car (model,speed);

                person.setCar(car);

                break;
        }

        return person;
    }
}












