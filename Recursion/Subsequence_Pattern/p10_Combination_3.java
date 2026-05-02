import java.util.ArrayList;
import java.util.List;

public class p10_Combination_3 {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        // Call the recursive function with initial parameters
        func(n, 1, nums, k, ans);
        return ans;
    }

    static void func(int sum, int last, List<Integer> nums, int k, List<List<Integer>> ans) {
        if (sum == 0 && nums.size() == k) {
            ans.add(new ArrayList<>(nums));
            return;
        }

        if (sum <= 0 || nums.size() > k)
            return;

        for (int i = last; i <= 9; i++) {
            if (i <= sum) {
                nums.add(i);

                func(sum - i, i + 1, nums, k, ans);
                nums.remove(nums.size() - 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {

        int k = 3; // Number of elements in the combination
        int n = 9; // Target sum
        List<List<Integer>> result = combinationSum3(k, n);

        // Print the result
        for (List<Integer> combination : result) {
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
