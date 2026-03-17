import java.util.Stack;

public class p7_Balanced_Parentheses {
    static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.isEmpty())
                    return false;

                char top = st.pop();
                // Check for matching pair
                if ((ch == ')' && top == '(') ||
                        (ch == ']' && top == '[') ||
                        (ch == '}' && top == '{'))
                    continue;
                else
                    return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {

        String s = "()[{}()]";

        if (isValid(s))
            System.out.println("True");
        else
            System.out.println("False");
    }
}