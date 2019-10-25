import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, Set<String>> userByIP = new TreeMap<>();
        Map<String,Long> usersDuration = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            String ip = input[0];
            String user = input[1];
            long duration = Integer.parseInt(input[2]);

            if(!userByIP.containsKey(user)){
                userByIP.put(user,new TreeSet<>());
                userByIP.get(user).add(ip);
                usersDuration.put(user,duration);
            } else {
                    userByIP.get(user).add(ip);
                    usersDuration.put(user,usersDuration.get(user) + duration);
            }
        }
        usersDuration.entrySet().forEach(entry -> {
            System.out.printf("%s: %d ", entry.getKey(),entry.getValue());
            System.out.print(userByIP.get(entry.getKey()));
            System.out.println();
        });
    }
}
