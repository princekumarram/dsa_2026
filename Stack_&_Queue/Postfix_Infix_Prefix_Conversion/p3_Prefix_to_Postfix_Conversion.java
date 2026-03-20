import java.util.Stack;

public class p3_Prefix_to_Postfix_Conversion {
    static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }

    public static String prefixToPostfix(String prefix) {
        Stack<String> s = new Stack<>();
        int n = prefix.length();

        for (int i = n - 1; i >= 0; i--) {
            char c = prefix.charAt(i);
            if (isOperand(c)) {
                s.push(c + "");
            } else {
                String op1 = s.pop();
                String op2 = s.pop();
                s.push(op1 + op2 + c);
            }
        }
        return s.peek();
    }

    public static void main(String[] args) {

        String prefix = "*-A/BC-/AKL";
        System.out.println("Postfix Expression: " + prefixToPostfix(prefix));
    }
}
