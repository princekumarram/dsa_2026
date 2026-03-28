public class p5_Next_Greater_Element_1 {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int target = nums1[i];
            boolean foundTarget = false;

            int next = -1;
            for (int j = 0; j < m; j++) {
                if (!foundTarget) {
                    if (nums2[j] == target) {
                        foundTarget = true; // start looking after this index
                    }
                } else {
                    if (nums2[j] > target) {
                        next = nums2[j];
                        break; // first greater element only
                    }
                }
            }

            ans[i] = next;
        }

        return ans;
    }

    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {

    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };

        int[] result = nextGreaterElement(nums1, nums2);

        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}