import java.util.*;

public class ListRotator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int rotateBy = 2;

        List<Integer> rotatedList = new ArrayList<>();
        int n = list.size();
        rotateBy = rotateBy % n;
        for (int i = rotateBy; i < n; i++) {
            rotatedList.add(list.get(i));
        }

        for (int i = 0; i < rotateBy; i++) {
            rotatedList.add(list.get(i));
        }

        System.out.println("Rotated List: " + rotatedList);
    }
}
