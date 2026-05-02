
public class p5_Check_subsequence_exists_with_sum_K {

    static boolean checkSubsequenceSum(int[] nums, int target) {
        int n = nums.length;

        return solve(0, n, nums, target);
    }

    static boolean solve(int i, int n, int[] arr, int k) {
        if (k == 0)
            return true;

        if (k < 0)
            return false;
        if (i == n) {
            return k == 0;
        }

        return solve(i + 1, n, arr, k - arr[i]) || solve(i + 1, n, arr, k);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int target = 5;
        System.out.println(checkSubsequenceSum(nums, target));
    }
}
