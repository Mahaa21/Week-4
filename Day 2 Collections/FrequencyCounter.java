import java.util.*;

public class FrequencyCounter {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("apple", "banana", "apple", "orange");

        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String item : input) {
            if (frequencyMap.containsKey(item)) {
                frequencyMap.put(item, frequencyMap.get(item) + 1);
            } else {
                frequencyMap.put(item, 1);
            }
        }

        System.out.println("Frequency Map: " + frequencyMap);
    }
}
