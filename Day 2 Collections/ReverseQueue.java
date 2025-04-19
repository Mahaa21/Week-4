import java.util.*;

public class ReverseQueue {
    public static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) return queue;
        int front = queue.remove();
        reverseQueue(queue);
        queue.add(front);
        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        Queue<Integer> reversed = reverseQueue(queue);
        System.out.println(reversed);
    }
}
