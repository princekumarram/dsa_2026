import java.util.ArrayList;
import java.util.Stack;

public class p2_Nearest_Greater_to_Left {

    static int[] preGreaterEle(int[] arr) {

        int ans[] = new int[arr.length];
        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < arr.length; i++) {

            // remove elements that are <= current (can't be previous greater)
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if (st.isEmpty())
                ans[i] = -1;
            else
                ans[i] = st.peek();
            st.push(arr[i]);
        }

        return ans;
    }

    static int[] preGreaterEle2(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0; i < arr.length; i++) {

            // remove elements that are <= current (can't be previous greater)
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if (st.isEmpty())
                ans.add(-1);
            else
                ans.add(st.peek());
            st.push(arr[i]);
        }

        // Convert ArrayList to int[]
        int[] result = new int[arr.length];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 2, 10 };

        int[] ans = preGreaterEle(nums);

        for (int x : ans) {
            System.out.print(x + " ");
        }

        System.out.println();
    }
}
