
class Node {
    int val;
    Node next;

    Node(int d) {
        val = d;
        next = null;
    }
}

// Structure to represent stack
class LinkedListStack {
    private Node head;
    private int size;

    // Contructor
    public LinkedListStack() {
        head = null;
        size = 0;
    }

    public void push(int x) {
        // Creating a node
        Node element = new Node(x);
        element.next = head;// Updating the pointers
        head = element;// Updating the top

        // Increment the top
        size++;
    }

    public int pop() {
        // If the stack is empty
        if (head == null) {
            return -1;// Pop operation cannot be performed
        }
        int value = head.val;// Get the top value
        Node temp = head;// Store the top temporarily
        head = head.next;// Update top to next node
        temp = null;// Delete old top node
        size--;

        return value;// Return data
    }

    // Method to get the top element of the stack
    public int top() {
        // If the stack is empty
        if (head == null) {
            return -1;// Top element cannot be accessed

        }
        return head.val;// Return the top
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }
}

public class p5_Implement_stack_using_linked_list {
    public static void main(String[] args) {
        LinkedListStack st = new LinkedListStack();

        String[] commands = { "LinkedListStack", "push", "push",
                "pop", "top", "isEmpty" };
        // Array of inputs
        int[][] inputs = { {}, { 3 }, { 7 }, {}, {}, {} };

        for (int i = 0; i < commands.length; ++i) {
            if (commands[i].equals("push")) {
                st.push(inputs[i][0]);
                System.out.print("null ");
            } else if (commands[i].equals("pop")) {
                System.out.print(st.pop() + " ");
            } else if (commands[i].equals("top")) {
                System.out.print(st.top() + " ");
            } else if (commands[i].equals("isEmpty")) {
                System.out.print((st.isEmpty() ? "true" : "false") + " ");
            } else if (commands[i].equals("LinkedListStack")) {
                System.out.print("null ");
            }
        }
    }
}
