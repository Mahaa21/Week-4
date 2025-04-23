import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SSNValidator {
    public static void validateSSN(String ssn) {
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ssn);

        if (matcher.matches()) {
            System.out.println('"' + ssn + "\" is valid");
        } else {
            System.out.println('"' + ssn + "\" is invalid");
        }
    }

    public static void main(String[] args) {
        String input1 = "123-45-6789";
        String input2 = "123456789";

        validateSSN(input1);
        validateSSN(input2);
    }
}
