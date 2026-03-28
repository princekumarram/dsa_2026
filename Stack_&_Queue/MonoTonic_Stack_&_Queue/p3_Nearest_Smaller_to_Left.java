import java.util.Stack;

public class p3_Nearest_Smaller_to_Left {

    static int[] preSmallerEle(int arr[]) {
        int ans[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

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

    public static void main(String[] args) {
        int[] nums = { 4, 5, 2, 10, 8 };

        int[] ans = preSmallerEle(nums);

        for (int x : ans) {
            System.out.print(x + " ");
        }

        System.out.println();
    }
}
