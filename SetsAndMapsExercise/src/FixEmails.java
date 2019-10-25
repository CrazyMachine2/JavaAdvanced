import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String,String> emails = new LinkedHashMap<>();

        while (true){
            String name = scan.nextLine();

            if (name.equals("stop")){
                break;
            }

            String email = scan.nextLine();
            int dot = email.indexOf(".") + 1;
            String domain = email.substring(dot).toLowerCase();

            if (!isValid(domain)){
                emails.put(name,email);
            }
        }
        emails.entrySet()
                .stream()
                .forEach(entry -> System.out.printf("%s -> %s%n", entry.getKey(),entry.getValue()));
    }
    private static boolean isValid (String domain){
        return domain.equals("uk") || domain.equals("us") || domain.equals("com");
    }
}
