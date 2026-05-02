
public class p4_Count_all_subsequences_with_sum_K {

    static int countSubsequenceWithTargetSum(int[] nums, int target) {
        return func(0, target, nums);
    }

    static int func(int ind, int sum, int[] nums) {

        if (sum == 0)
            return 1;

        if (sum < 0 || ind == nums.length)
            return 0;

        return func(ind + 1, sum - nums[ind], nums) + func(ind + 1, sum, nums);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int target = 5;
        System.out.println("Number of subsequences with target sum " + target + ": " +

                countSubsequenceWithTargetSum(nums, target));
    }

}
