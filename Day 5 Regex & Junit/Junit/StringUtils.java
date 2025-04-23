package test;

public class StringUtils {
    public String reverse(String str) { return new StringBuilder(str).reverse().toString(); }
    public boolean isPalindrome(String str) {
        String rev = reverse(str);
        return str.equalsIgnoreCase(rev);
    }
    public String toUpperCase(String str) { return str.toUpperCase(); }
}
