import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryAdd {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> browser = new ArrayDeque<>();
        ArrayDeque<String> forwards = new ArrayDeque<>();
        String current = "";

        while (true){
            String input = scan.nextLine();

            if(input.equals("Home")){
                break;
            }

            if (input.equals("back")){
                if (!browser.isEmpty()){
                    forwards.push(current);
                    current = browser.pop();
                } else {
                    System.out.println("no previous URLs");
                    continue;
                }
            } else if (input.equals("forward")) {
                if (!forwards.isEmpty()){
                    browser.push(current);
                    current = forwards.pop();
                } else {
                    System.out.print("no next URLs");
                }
            } else {
                if (!current.equals("")){
                    browser.push(current);
                    if (!forwards.isEmpty()){
                        forwards.clear();
                    }
                }
                current = input;
            }
            System.out.println(current);
        }
    }
}
