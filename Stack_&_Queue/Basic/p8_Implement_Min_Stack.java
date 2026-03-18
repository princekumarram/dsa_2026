import java.util.Stack;

class MinStack {

    private Stack<int[]> st;

    // Empty Constructor
    public MinStack() {
        st = new Stack<>();
    }

    // Method to push a value in stack
    public void push(int value) {
        // If stack is empty
        if (st.isEmpty()) {
            // Push current value as minimum
            st.push(new int[] { value, value });
            return;
        }

        int mini = Math.min(getMin(), value);
        st.push(new int[] { value, mini });
    }

    public void pop() {
        // Using in-built pop method
        st.pop();
    }

    public int top() {
        // Return the top value
        return st.peek()[0];
    }

    public int getMin() {
        return st.peek()[1];
    }

}

public class p8_Implement_Min_Stack {

    public static void main(String[] args) {
        MinStack s = new MinStack();

        // Function calls
        s.push(-2);
        s.push(0);
        s.push(-3);
        System.out.print(s.getMin() + " ");
        s.pop();
        System.out.print(s.top() + " ");
        s.pop();
        System.out.print(s.getMin());
    }
}
