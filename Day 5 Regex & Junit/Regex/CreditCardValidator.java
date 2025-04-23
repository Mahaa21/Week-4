import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CreditCardValidator {
    public static boolean isValidCreditCard(String cardNumber) {
        String regex = "^(4\\d{15}|5\\d{15})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cardNumber);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidCreditCard("4123456789012345"));
        System.out.println(isValidCreditCard("5123456789012345"));
        System.out.println(isValidCreditCard("6123456789012345"));
        System.out.println(isValidCreditCard("412345678901234"));
    }
}
