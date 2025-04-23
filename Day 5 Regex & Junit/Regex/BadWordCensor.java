import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class BadWordCensor {
    public static String censorBadWords(String text, String[] badWords) {
        String patternString = String.join("|", badWords);
        Pattern pattern = Pattern.compile("\\b(" + patternString + ")\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll("****");
    }

    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"};

        String censored = censorBadWords(input, badWords);
        System.out.println(censored);
    }
}
