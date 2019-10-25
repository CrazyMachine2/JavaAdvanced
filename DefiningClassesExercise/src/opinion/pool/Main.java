package opinion.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Participant> participants = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split(" ");

            Participant participant = new Participant(data[0],Integer.parseInt(data[1]));
            participants.add(participant);
        }

        participants.stream()
                .filter(p -> p.getAge() > 30)
                .sorted((p1,p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(p -> System.out.printf("%s - %d%n",p.getName(),p.getAge()));
    }
}
