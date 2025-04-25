import java.util.function.BiFunction;

public class StringConcatenation {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatenateWithSpace = (s1, s2) -> s1 + " " + s2;

        String result = concatenateWithSpace.apply("Hello", "World");

        System.out.println("Concatenated string: " + result);
    }
}
