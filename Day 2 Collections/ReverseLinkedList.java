import java.util.LinkedList;
import java.util.ListIterator;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        ListIterator<Integer> forward = list.listIterator();
        ListIterator<Integer> backward = list.listIterator(list.size());

        int mid = list.size() / 2;
        for (int i = 0; i < mid; i++) {
            int front = forward.next();
            int back = backward.previous();
            forward.set(back);
            backward.set(front);
        }

        System.out.println("Reversed LinkedList: " + list);
    }
}
