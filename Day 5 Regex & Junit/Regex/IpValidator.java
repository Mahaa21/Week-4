import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class IpValidator {
    public static boolean isValidIPv4(String ip) {
        String regex = "^([0-9]{1,2}|1[0-9]{2}|2[0-4][0-9]|25[0-5])" +
                "(\\.?([0-9]{1,2}|1[0-9]{2}|2[0-4][0-9]|25[0-5])){3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidIPv4("192.168.1.1"));
        System.out.println(isValidIPv4("255.255.255.255"));
        System.out.println(isValidIPv4("256.256.256.256"));
        System.out.println(isValidIPv4("192.168.1.300"));
    }
}
