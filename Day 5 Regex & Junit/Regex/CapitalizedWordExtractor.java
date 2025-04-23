import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CapitalizedWordExtractor {
    public static void extractCapitalizedWords(String text) {
        String regex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        String exampleText = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        extractCapitalizedWords(exampleText);
    }
}
