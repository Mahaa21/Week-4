import java.io.*;

public class CaseFormatter {
    public static void main(String[] args) {
        String inputPath = "source.txt";
        String outputPath = "converted.txt";

        try {
            Reader reader = new BufferedReader(new FileReader(inputPath));
            Writer writer = new BufferedWriter(new FileWriter(outputPath));

            int unit;
            while ((unit = reader.read()) != -1) {
                char symbol = Character.toLowerCase((char) unit);
                writer.write(symbol);
            }

            reader.close();
            writer.close();

            System.out.println("Transformation complete.");
        } catch (IOException ex) {
            System.out.println("Failure encountered: " + ex.getMessage());
        }
    }
}
