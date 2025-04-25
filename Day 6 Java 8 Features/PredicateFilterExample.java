import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateFilterExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("elephant", "cat", "alligator", "cheetah", "antelope");

        Predicate<String> lengthGreaterThan5 = s -> s.length() > 5;
        Predicate<String> containsLetterA = s -> s.contains("a");

        List<String> filtered = words.stream()
                .filter(lengthGreaterThan5.and(containsLetterA))
                .collect(Collectors.toList());

        System.out.println("Filtered strings (length > 5 and contains 'a'):");
        filtered.forEach(System.out::println);
    }
}
