import java.util.*;
import java.util.stream.*;

public class SecondMostRepeatedWord {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "apple", "banana", "cherry", "cherry");
        Map<String, Long> wordCount = words.stream()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));


        wordCount.entrySet().stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .skip(1) // Skip the most frequent one
                .findFirst()
                .ifPresent(entry -> System.out.println("Second most frequent word: " + entry.getKey() + " with count " + entry.getValue()));
    }
}
