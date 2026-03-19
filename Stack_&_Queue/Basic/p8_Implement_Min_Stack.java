import java.util.Stack;

//BRUTE FORCE
// class MinStack {

//     private Stack<int[]> st;

//     // Empty Constructor
//     public MinStack() {
//         st = new Stack<>();
//     }

//     // Method to push a value in stack
//     public void push(int value) {
//         // If stack is empty
//         if (st.isEmpty()) {
//             // Push current value as minimum
//             st.push(new int[] { value, value });
//             return;
//         }

//         int mini = Math.min(getMin(), value);
//         st.push(new int[] { value, mini });
//     }

//     public void pop() {
//         // Using in-built pop method
//         st.pop();
//     }

//     public int top() {
//         // Return the top value
//         return st.peek()[0];
//     }

//     public int getMin() {
//         return st.peek()[1];
//     }

// }

//OPTIMAL SOLUTION

class MinStack {
    private Stack<Integer> st;
    private int mini;

    // Empty Constructor
    public MinStack() {
        st = new Stack<>();

    }

    // Method to push a value in stack
    public void push(int value) {
        if (st.isEmpty()) {
            // Update the minimum value
            mini = value;
            // Push current value as minimum
            st.push(value);
            return;
        }
        if (value > mini) {
            st.push(value);
        } else {
            // Add the modified value to stack
            st.push(2 * value - mini);
            // Update the minimum
            mini = value;
        }
    }

    public void pop() {
        if (st.isEmpty())
            return;
        int x = st.pop();

        // If the modified value was added to stack
        if (x < mini) {
            // Update the minimum
            mini = 2 * mini - x;
        }
    }

    public int top() {

        if (st.isEmpty())
            return -1;

        int x = st.peek();
        // Return top if minimum is less than the top
        if (mini < x)
            return x;
        // Otherwise return mini
        return mini;
    }

    public int getMin() {
        return mini;
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
