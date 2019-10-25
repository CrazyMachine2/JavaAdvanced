import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Integer>> usernamesIP = new TreeMap<>();

        while (true) {
            String input = scan.nextLine();

            if (input.equals("end")) {
                break;
            }

            String[] data = input.split(" ");
            String ip = data[0].split("=")[1];
            String user = data[2].split("=")[1];

            if (!usernamesIP.containsKey(user)) {
                usernamesIP.put(user, new LinkedHashMap<>());
            }
            if (!usernamesIP.get(user).containsKey(ip)) {
                usernamesIP.get(user).put(ip,1);
            }else {
                usernamesIP.get(user).put(ip, usernamesIP.get(user).get(ip) + 1);
            }
        }

        for (Map.Entry<String,Map<String,Integer>> entry : usernamesIP.entrySet()) {
            System.out.printf("%s: %n",entry.getKey());

            int count = entry.getValue().size();

            for (Map.Entry<String,Integer> entry1 : entry.getValue().entrySet()){
                if (count ==1){
                    System.out.printf("%s => %d.",entry1.getKey(),entry1.getValue());
                } else {
                    System.out.printf("%s => %d, ",entry1.getKey(),entry1.getValue());
                }
                count--;
            }
            System.out.println();
        }
    }
}
