import java.io.*;

public class StudentBinaryStore {
    public static void main(String[] args) {
        String path = "students.bin";

        try {
            DataOutputStream saver = new DataOutputStream(new FileOutputStream(path));
            saver.writeInt(301);
            saver.writeUTF("Nina");
            saver.writeDouble(8.4);

            saver.writeInt(302);
            saver.writeUTF("Zaid");
            saver.writeDouble(9.1);

            saver.close();
        } catch (IOException trouble) {
            System.out.println("Writing issue: " + trouble.getMessage());
        }

        try {
            DataInputStream loader = new DataInputStream(new FileInputStream(path));
            while (loader.available() > 0) {
                int id = loader.readInt();
                String label = loader.readUTF();
                double score = loader.readDouble();
                System.out.println("Roll: " + id + ", Name: " + label + ", GPA: " + score);
            }
            loader.close();
        } catch (IOException error) {
            System.out.println("Reading issue: " + error.getMessage());
        }
    }
}
