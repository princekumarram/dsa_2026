// Print all the possible subsequence of the string 

import java.util.ArrayList;
import java.util.List;

public class p3_Power_Set {

    static void helper(String s, int index, StringBuilder current, List<String> result) {

        if (index == s.length()) {
            result.add(current.toString());
            return;
        }

        helper(s, index + 1, current, result);

        current.append(s.charAt(index));
        helper(s, index + 1, current, result);
        // Backtrack by removing last character
        current.deleteCharAt(current.length() - 1);
    }

    static List<String> getSubsequences(String s) {
        List<String> result = new ArrayList<>();

        StringBuilder current = new StringBuilder();

        helper(s, 0, current, result);

        return result;
    }

    public static void main(String[] args) {
        // Input string
        String s = "abc";

        // Get all subsequences
        List<String> subsequences = getSubsequences(s);

        // Print all subsequences
        for (String subseq : subsequences) {
            System.out.println("\"" + subseq + "\"");
        }
    }
}
