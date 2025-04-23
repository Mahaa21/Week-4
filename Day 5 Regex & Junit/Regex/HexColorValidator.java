import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HexColorValidator {
    public static boolean isValidHexColor(String color) {
        String regex = "^#[0-9A-Fa-f]{6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(color);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidHexColor("#FFA500"));
        System.out.println(isValidHexColor("#ff4500"));
        System.out.println(isValidHexColor("#123"));
        System.out.println(isValidHexColor("FFA500"));
        System.out.println(isValidHexColor("#GGGGGG"));
    }
}
