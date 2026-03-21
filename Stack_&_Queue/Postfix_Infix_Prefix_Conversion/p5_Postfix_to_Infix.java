import java.util.Stack;

public class p5_Postfix_to_Infix {
    static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }

    static String postfixToInfix(String postfix) {
        Stack<String> s = new Stack<>();
        int n = postfix.length();

        for (int i = 0; i < n; i++) {
            char c = postfix.charAt(i);

            if (isOperand(c)) {
                s.push(String.valueOf(c));
            } else {
                String op2 = s.pop();
                String op1 = s.pop();

                s.push("(" + op1 + c + op2 + ")");
            }
        }
        return s.peek();
    }

    public static void main(String[] args) {

        String postfix = "AB*C+";
        System.out.println("Infix Expression: " + postfixToInfix(postfix));

    }
}
