import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> names = new LinkedHashSet<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            names.add(name);
        }

        for(String name : names){
            System.out.println(name);
        }

    }
}
