import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p9_Subset_2 {
    static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Sort to handle duplicates
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    static void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;

            current.add(nums[i]);

            backtrack(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        List<List<Integer>> ans = subsetsWithDup(nums);

        for (List<Integer> subset : ans) {
            System.out.print("[");
            for (int i = 0; i < subset.size(); i++) {
                System.out.print(subset.get(i));
                if (i != subset.size() - 1)
                    System.out.print(",");
            }
            System.out.print("] ");
        }
        System.out.println();
        sc.close();
    }
}
