import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LicensePlateValidator {
    public static boolean isValidLicensePlate(String plate) {
        String regex = "^[A-Z]{2}[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(plate);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidLicensePlate("AB1234"));
        System.out.println(isValidLicensePlate("A12345"));
        System.out.println(isValidLicensePlate("AB123"));
        System.out.println(isValidLicensePlate("ab1234"));
    }
}
