import java.util.*;

public class HandsOfCards {

    private static int A = 14, K = 13, Q = 12, J = 11, S = 4, H = 3, D = 2, C = 1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> playerScore = new LinkedHashMap<>();
        Map<String, Set<String>> playerCards = new LinkedHashMap<>();

        while (true) {
            String input = scan.nextLine();

            if (input.equals("JOKER")) {
                break;
            }

            String[] data = input.split(": ");
            String name = data[0];
            String[] cards = data[1].split(", ");

            if (!playerCards.containsKey(name)) {
                playerCards.put(name, new LinkedHashSet<>());
            }

            for (String card : cards) {
                playerCards.get(name).add(card);
            }
        }

        for(Map.Entry<String,Set<String>> entry : playerCards.entrySet()){
            int score = 0;
            for (String card : entry.getValue()) {
                int power = 0;
                int type = 0;

                if(!Character.isAlphabetic(card.charAt(0))){
                        power = Integer.parseInt(card.charAt(0)+"");
                } else if (card.charAt(0) == 'J'){
                    power = J;
                } else if (card.charAt(0) == 'Q'){
                    power = Q;
                } else if (card.charAt(0) == 'K'){
                    power = K;
                } else {
                    power = A;
                }
            if(card.length() <3){
                if (card.charAt(1) == 'S'){
                    type = S;
                } else if (card.charAt(1) == 'H'){
                    type = H;
                } else if (card.charAt(1) == 'D'){
                    type = D;
                } else {
                    type = C;
                }
            } else {
                if (card.charAt(2) == 'S'){
                    type = S;
                } else if (card.charAt(2) == 'H'){
                    type = H;
                } else if (card.charAt(2) == 'D'){
                    type = D;
                } else {
                    type = C;
                }
            }
                score += power * type;
            }
            playerScore.put(entry.getKey(),score);
        }

        playerScore.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue()
                .thenComparing(Map.Entry.comparingByKey()).reversed())
                .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
    }
}
