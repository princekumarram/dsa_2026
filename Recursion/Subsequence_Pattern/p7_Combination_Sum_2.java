//Find all unique combinations

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class p7_Combination_Sum_2 {

    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> ds = new ArrayList<>();

        findCombination(0, target, candidates, ans, ds);
        return ans;

    }

    static void findCombination(int ind, int target, int[] arr, List<List<Integer>> ans, List<Integer> ds) {

        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1])
                continue;

            if (arr[i] > target)
                break;

            ds.add(arr[i]);

            findCombination(i + 1, target - arr[i], arr, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] v = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;

        List<List<Integer>> comb = combinationSum2(v, target);

        // Output the combinations
        System.out.print("[ ");
        for (List<Integer> combination : comb) {
            System.out.print("[ ");
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.print("]");
        }
        System.out.println(" ]");
    }
}
