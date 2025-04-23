import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashSet;

public class RepeatingWordsFinder {
    public static void findRepeatingWords(String text) {
        String regex = "\\b(\\w+)\\s+\\1\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        HashSet<String> repeatingWords = new HashSet<>();

        while (matcher.find()) {
            repeatingWords.add(matcher.group(1));
        }

        System.out.println(String.join(", ", repeatingWords));
    }

    public static void main(String[] args) {
        String exampleText = "This is is a repeated repeated word test.";
        findRepeatingWords(exampleText);
    }
}
