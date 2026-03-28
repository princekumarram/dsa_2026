import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class p4_Nearest_Smaller_to_Right {

    static int[] RightSmallerEle(int arr[]) {
        int ans[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() >= arr[i]) {
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

    static ArrayList<Integer> RightSmallerEle2(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty())
                ans.add(-1);
            else
                ans.add(st.peek());

            st.push(arr[i]);
        }
        Collections.reverse(ans);
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 2, 10, 8 };

        int[] ans = RightSmallerEle(nums);

        for (int x : ans) {
            System.out.print(x + " ");
        }

        System.out.println();
        ArrayList<Integer> ans2 = RightSmallerEle2(nums);

        for (int x = 0; x < ans2.size(); x++) {
            System.out.print(ans2.get(x) + " ");
        }

        System.out.println();
    }
}
