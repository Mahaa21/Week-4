import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ProgrammingLanguageExtractor {
    public static void extractLanguages(String text) {
        String regex = "\\b(Java|Python|JavaScript|Go|C\\+\\+|Ruby|C#|PHP|Swift|Kotlin)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        String exampleText = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        extractLanguages(exampleText);
    }
}
