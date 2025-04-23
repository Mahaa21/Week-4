import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CurrencyExtractor {
    public static void extractCurrencyValues(String text) {
        String regex = "\\$\\d+\\.\\d{2}|\\d+\\.\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        String exampleText = "The price is $45.99, and the discount is 10.50.";
        extractCurrencyValues(exampleText);
    }
}
