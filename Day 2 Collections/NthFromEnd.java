import java.util.*;

public class NthFromEnd {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;

        ListIterator<String> first = list.listIterator();
        ListIterator<String> second = list.listIterator();

        for (int i = 0; i < n; i++) {
            if (!first.hasNext()) {
                System.out.println("N is larger than the list size");
                return;
            }
            first.next();
        }

        while (first.hasNext()) {
            first.next();
            second.next();
        }

        if (second.hasNext()) {
            System.out.println(second.next());
        }
    }
}
