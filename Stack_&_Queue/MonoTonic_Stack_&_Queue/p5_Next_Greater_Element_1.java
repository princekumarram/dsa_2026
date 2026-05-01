import java.util.HashMap;
import java.util.Stack;

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

        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Find next greater for nums2
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], st.peek());
            }

            st.push(nums2[i]);
        }

        // Prepare answer for nums1
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };

        // int[] result = nextGreaterElement(nums1, nums2);
        int[] result = nextGreaterElement2(nums1, nums2);

        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}