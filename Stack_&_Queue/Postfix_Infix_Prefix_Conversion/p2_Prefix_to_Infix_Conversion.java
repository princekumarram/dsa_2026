import java.util.Stack;

public class p2_Prefix_to_Infix_Conversion {
    static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }

    public static String prefixToInfix(String prefix) {
        Stack<String> s = new Stack<>();
        int n = prefix.length();

        // Traverse the prefix expression from right to left
        for (int i = n - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            // If the character is an operand, push it to the stack
            if (isOperand(c)) {
                s.push(c + ""); // instead of String.valueOf()
            } else {
                // Pop two operands from the stack
                String op1 = s.pop();
                String op2 = s.pop();
                // Form the new infix expression and push back to stack
                String exp = "(" + op1 + c + op2 + ")";
                s.push(exp);
            }
        }
        // The final element in the stack is the result
        return s.peek();
    }

    public static void main(String[] args) {

        String prefix = "*-A/BC-/AKL";
        System.out.println("Infix Expression: " + prefixToInfix(prefix));
    }
}
