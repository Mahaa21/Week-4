package test;

public class UserRegistration {
    public static void registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty()) throw new IllegalArgumentException("Invalid username");
        if (email == null || !email.contains("@")) throw new IllegalArgumentException("Invalid email");
        if (password == null || password.length() < 8) throw new IllegalArgumentException("Invalid password");
    }
}
