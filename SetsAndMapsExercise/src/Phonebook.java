import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String,String> phonebook = new HashMap<>();

        while(true){
            String input = scan.nextLine();

            if (input.equals("search")){
                break;
            }

            String[] data = input.split("-");
            String name = data[0];
            String number = data[1];

            phonebook.put(name,number);
        }

        while(true){
            String name = scan.nextLine();
            if(name.equals("stop")){
                break;
            }

            if (phonebook.containsKey(name)){
                System.out.printf("%s -> %s%n",name,phonebook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n",name);
            }
        }

    }
}
