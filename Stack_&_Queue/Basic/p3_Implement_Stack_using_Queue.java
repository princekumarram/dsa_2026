import java.util.*;

class QueueStack {

    Queue<Integer> q = new LinkedList<>();

    public void push(int x) {
        int s = q.size();
        q.add(x);

        // Move elements before new element to back
        for (int i = 0; i < s; i++) {
            q.add(q.poll());
        }
    }

    public int pop() {
        int n = q.peek();
        q.poll();
        return n;
    }

    public int top() {
        return q.peek();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

}

public class p3_Implement_Stack_using_Queue {
    public static void main(String[] args) {
        QueueStack st = new QueueStack();

        String[] commands = { "QueueStack", "push", "push", "pop", "top", "isEmpty" };

        int[][] inputs = { {}, { 4 }, { 8 }, {}, {}, {} };

        for (int i = 0; i < commands.length; i++) {
            switch ((commands[i])) {
                case "push":
                    st.push(inputs[i][0]);
                    System.out.println("null ");
                    break;
                case "pop":
                    System.out.println(st.top() + " ");
                    break;
                case "top":
                    System.out.println(st.top() + " ");
                    break;
                case "isEmpty":
                    System.out.println(st.isEmpty() ? "true" : "false");
                case "QueueStack":
                    System.out.println("null  ");
                    break;

            }
        }
    }
}
