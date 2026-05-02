
import java.util.ArrayList;
import java.util.List;

public class p6_Combination_Sum_1 {

    static List<List<Integer>> combinationSum(int[] candiates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        findCombination(0, target, candiates, ans, ds);
        return ans;
    }

    static void findCombination(int ind, int target, int arr[], List<List<Integer>> ans, List<Integer> ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombination(ind, target - arr[ind], arr, ans, ds);
            ds.remove(ds.size() - 1);
        }

        findCombination(ind + 1, target, arr, ans, ds);
    }

    public static void main(String[] args) {
        int[] v = { 2, 3, 6, 7 };
        int target = 7;
        // Get all combinations
        List<List<Integer>> ans = combinationSum(v, target);

        System.out.println("Combinations are: ");
        for (List<Integer> combination : ans) {
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
