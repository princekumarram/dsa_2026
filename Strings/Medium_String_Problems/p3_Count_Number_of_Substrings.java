import java.util.*;

public class p3_Count_Number_of_Substrings {

    static int countSubstrings(String s, int k) {
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

    static int atMostKDistinct(String s, int k) {
        int left = 0, res = 0;

        Map<Character, Integer> freq = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0) + 1);

            // Shrink window if distinct charactes exceed k

            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);

                if (freq.get(leftChar) == 0)
                    freq.remove(leftChar);

                left++;
            }
            res += (right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {

        // Sample test
        String s = "pqpqs";
        int k = 2;

        // Output the result
        System.out.println("Count: " + countSubstrings(s, k)); // Output: 7

    }
}
