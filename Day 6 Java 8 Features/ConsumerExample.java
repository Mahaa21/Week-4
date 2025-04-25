import java.util.*;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "world", "java", "lambda");

        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());

        System.out.println("Printing strings in uppercase:");
        words.forEach(printUpperCase);
    }
}
