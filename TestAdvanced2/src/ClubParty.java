import java.util.*;

public class ClubParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<String> data = new ArrayDeque<>();
        Deque<String> currentHall = new ArrayDeque<>();

        int capacity = Integer.parseInt(scan.nextLine());
        Map<String, List<Integer>> halls = new LinkedHashMap<>();


        String[] input = scan.nextLine().split(" ");
        for (String str : input) {
            data.push(str);
        }

        while (true) {
            if (data.isEmpty()) {
                break;
            }
            String next = data.pop();

            if (isInteger(next)) {
                int value = Integer.parseInt(next);

                if (!halls.isEmpty()) {
                    int sum = getSum(halls.get(currentHall.peek()));

                    if (sum + value > capacity) {
                        printHall(currentHall.peek(), halls.get(currentHall.peek()));
                        halls.remove(currentHall.peek());
                        currentHall.poll();
                        if (!halls.isEmpty()) {
                            if (value <= capacity) {
                                halls.get(currentHall.peek()).add(value);
                            }
                        }
                    } else {
                        halls.get(currentHall.peek()).add(value);
                    }
                }
            } else {
                halls.put(next, new ArrayList<>());
                currentHall.offer(next);
            }
        }
        System.out.println();
    }

    private static void printHall(String key, List<Integer> value) {
        System.out.print(key + " -> ");

        for (int i = 0; i < value.size(); i++) {
            if (i == value.size() - 1) {
                System.out.print(value.get(i));
            } else {
                System.out.print(value.get(i) + ", ");
            }
        }
        System.out.println();
    }

    private static int getSum(List<Integer> integers) {
        int sum = 0;

        for (Integer integer : integers) {
            sum += integer;
        }
        return sum;
    }

    private static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
