import java.util.Stack;

public class p4_Postfix_to_Prefix_Conversion {
    static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }

    static String postfixToPrefix(String postfix) {
        // Change Stack type to String to store intermediate expressions
        Stack<String> s = new Stack<>();
        int n = postfix.length();

        for (int i = 0; i < n; i++) {
            char c = postfix.charAt(i);

            if (isOperand(c)) {
                // Push operand as a String
                s.push(String.valueOf(c));
            } else {
                // Postfix logic: pop op2 first, then op1
                String op2 = s.pop();
                String op1 = s.pop();

                // Prefix format: <operator><operand1><operand2>
                s.push(c + op1 + op2);
            }
        }
        // The final element in the stack is the complete prefix expression
        return s.peek();
    }

    public static void main(String[] args) {

        String postfix = "ABC/-AK/L-*";
        System.out.println("Prefix Expression: " + postfixToPrefix(postfix));
    }
}
