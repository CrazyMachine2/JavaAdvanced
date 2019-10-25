import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        Predicate<String> isUppercase = word -> word.charAt(0) == Character.toUpperCase(word.charAt(0));

        List<String> words = Arrays.stream(scan.nextLine().split(" "))
                .filter(isUppercase)
                .collect(Collectors.toList());

        System.out.println(words.size());
        words.forEach(System.out::println);

//        String[] text = scan.nextLine().split(" ");
//        List<String> result = new ArrayList<>();
//        for (int i = 0; i < text.length; i++) {
//            if (isUppercase.test(text[i])) {
//                result.add(text[i]);
//            }
//        }
    }
}
