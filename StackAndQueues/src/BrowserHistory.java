import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> browser = new ArrayDeque<>();
        String current = "";

        while (true){
            String input = scan.nextLine();

            if(input.equals("Home")){
                break;
            }

            if (input.equals("back")){
                if (!browser.isEmpty()){
                   current = browser.pop();
                } else {
                    System.out.println("no previous URLs");
                    continue;
                }
            } else {
                if (!current.equals("")){
                    browser.push(current);
                }
                current = input;
            }
            System.out.println(current);
        }
    }
}
