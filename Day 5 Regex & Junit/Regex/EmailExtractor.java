import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmailExtractor {
    public static void extractEmails(String text) {
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        String exampleText = "Contact us at support@example.com and info@company.org";
        extractEmails(exampleText);
    }
}
