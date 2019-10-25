import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int count = 1;

        Map<Integer,List<String>> map = new LinkedHashMap<>(802);

        String[] arr = scan.nextLine().split("");

        for (String letter : arr) {
            if(!map.containsKey(count)){
                map.put(count,new ArrayList<>());
                map.get(count).add(letter);
            } else {
                if (map.get(count).size() <= 15){
                    map.get(count).add(letter);
                } else {
                    count++;
                    map.put(count,new ArrayList<>());
                    map.get(count).add(letter);
                }
            }
        }

        List<StringBuilder> sequences = new ArrayList<>();

        map.entrySet().stream().forEach(entry -> {
            StringBuilder sb = new StringBuilder();
            for (String letter : entry.getValue()){
                sb.append(letter);
            }
            sequences.add(sb);
        });

        Set<StringBuilder> sequenceCandidate = new LinkedHashSet<>();

        for (StringBuilder sequence : sequences){
            Set<Character> charSet = new LinkedHashSet<>();

            for (int i = 0; i < sequence.length(); i++) {
                charSet.add(sequence.charAt(i));
            }

            if (charSet.size() == 16){
                sequenceCandidate.add(sequence);
            }
        }

        System.out.println();
    }

}
