import java.util.*;

public class GenerateBinaryNumbers {
    public static List<String> generateBinaryNumbers(int N) {
        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();

        queue.add("1");

        for (int i = 0; i < N; i++) {
            String current = queue.remove();
            result.add(current);
            queue.add(current + "0");
            queue.add(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        List<String> binaryNumbers = generateBinaryNumbers(N);
        System.out.println(binaryNumbers);
    }
}
