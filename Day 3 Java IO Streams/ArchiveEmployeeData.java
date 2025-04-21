import java.io.*;
import java.util.*;

class Staff implements Serializable {
    int code;
    String person;
    String unit;
    double pay;

    Staff(int code, String person, String unit, double pay) {
        this.code = code;
        this.person = person;
        this.unit = unit;
        this.pay = pay;
    }
}

public class ArchiveEmployeeData {
    public static void main(String[] data) {
        List<Staff> group = new ArrayList<>();
        group.add(new Staff(101, "Alice", "HR", 55000));
        group.add(new Staff(102, "Bob", "Tech", 72000));
        group.add(new Staff(103, "Charlie", "Admin", 49000));

        try {
            ObjectOutputStream saver = new ObjectOutputStream(new FileOutputStream("records.bin"));
            saver.writeObject(group);
            saver.close();
        } catch (IOException issue) {
            System.out.println("Save failed: " + issue.getMessage());
        }

        try {
            ObjectInputStream loader = new ObjectInputStream(new FileInputStream("records.bin"));
            List<Staff> restored = (List<Staff>) loader.readObject();
            loader.close();

            for (Staff item : restored) {
                System.out.println("ID: " + item.code + ", Name: " + item.person + ", Dept: " + item.unit + ", Salary: " + item.pay);
            }
        } catch (IOException | ClassNotFoundException fail) {
            System.out.println("Load error: " + fail.getMessage());
        }
    }
}
