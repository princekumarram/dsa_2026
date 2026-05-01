import java.util.*;

public class p1_Sort_Characters_By_Frequency {

    static String frequencySort(String s) {

        // Step 1: Count frequency
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Max Heap (based on frequency)
        PriorityQueue<Character> pq = new PriorityQueue<>(
                (a, b) -> map.get(b) - map.get(a));

        pq.addAll(map.keySet());

        // Step 3: Build result
        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            char ch = pq.poll();
            int freq = map.get(ch);

            for (int i = 0; i < freq; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String input1 = "tree";
        String input2 = "cccaaa";
        String input3 = "Aabb";
        String input4 = "loveleetcode";

        System.out.println("Input: " + input1 + " -> Output: " + frequencySort(input1));
        System.out.println("Input: " + input2 + " -> Output: " + frequencySort(input2));
        System.out.println("Input: " + input3 + " -> Output: " + frequencySort(input3));
        System.out.println("Input: " + input4 + " -> Output: " + frequencySort(input4));
    }
}