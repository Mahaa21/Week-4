import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;

public class ConsoleToFile {
    public static void main(String[] args) {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your full name: ");
            String fullName = input.readLine();
            System.out.print("Enter your current age: ");
            String userAge = input.readLine();
            System.out.print("Enter your top programming language: ");
            String language = input.readLine();

            FileWriter log = new FileWriter("userdata.txt");
            log.write("Name: " + fullName + "\n");
            log.write("Age: " + userAge + "\n");
            log.write("Language: " + language + "\n");
            log.close();

            System.out.println("Information recorded.");
        } catch (Exception issue) {
            System.out.println("Failure: " + issue.getMessage());
        }
    }
}
