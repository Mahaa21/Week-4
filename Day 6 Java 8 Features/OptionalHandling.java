import java.util.*;
import java.util.stream.*;

public class OptionalHandling {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> max = numbers.stream()
                .max(Integer::compareTo);
        max.ifPresentOrElse(
                value -> System.out.println("Maximum value: " + value),
                () -> System.out.println("The list is empty.")
        );
        List<Integer> emptyList = Collections.emptyList();
        Optional<Integer> maxEmpty = emptyList.stream()
                .max(Integer::compareTo);

        maxEmpty.ifPresentOrElse(
                value -> System.out.println("Maximum value: " + value),
                () -> System.out.println("The list is empty.")
        );
    }
}
