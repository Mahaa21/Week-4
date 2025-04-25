import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class WordFrequency {
    public static void main(String[] args) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get("sample.txt")));

        List<String> words = Arrays.asList(text.split("\\W+"));

        Map<String, Long> wordCount = words.stream()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        int topN = 5;
        wordCount.entrySet().stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .limit(topN)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
