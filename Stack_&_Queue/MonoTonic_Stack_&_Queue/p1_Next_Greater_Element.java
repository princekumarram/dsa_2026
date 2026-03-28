import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class p1_Next_Greater_Element {

    public static int[] nextGreater(int[] nums) {
        Stack<Integer> st = new Stack<>();

        int n = nums.length;
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }
            st.push(nums[i]);
        }
        return res;
    }

    // Av code
    public static int[] nextGreater2(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans.add(-1);
            } else {
                ans.add(st.peek());
            }

            st.push(arr[i]); // Important step
        }

        // Reverse because we traversed from right to left
        Collections.reverse(ans);

        // Convert ArrayList to int[]
        int[] result = new int[arr.length];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };

        int[] ans = nextGreater(nums);

        for (int x : ans) {
            System.out.print(x + " ");
        }

        System.out.println();
    }
}