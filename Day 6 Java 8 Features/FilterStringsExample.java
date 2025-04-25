import java.util.*;
import java.util.stream.Collectors;

public class FilterStringsExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple", "Banana", "Avocado", "Cherry", "Apricot", "Blueberry");

        List<String> filtered = words.stream()
                .filter(s -> !s.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println("Original list: " + words);
        System.out.println("Filtered list (excluding 'A'): " + filtered);
    }
}
