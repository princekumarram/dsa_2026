import java.util.ArrayList;
import java.util.List;

public class p1_Generate_all_binary_strings {

    static void generateBinaryStrings(int n) {
        List<String> result = new ArrayList<>();
        generate(n, "", result);
        // Print results
        for (String s : result) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    static void generate(int n, String curr, List<String> result) {
        if (curr.length() == n) {
            result.add(curr);
            return;
        }

        // Always try adding '0'

        generate(n, curr + "0", result);

        if (curr.isEmpty() || curr.charAt(curr.length() - 1) != '1') {
            generate(n, curr + "1", result);
        }
    }

    public static void main(String[] args) {

        int n = 3;
        generateBinaryStrings(n);
    }
}
