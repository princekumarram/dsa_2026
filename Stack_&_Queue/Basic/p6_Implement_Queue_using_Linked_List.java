import java.util.*;

class Node {
    int val;
    Node next;

    Node(int d) {
        val = d;
        next = null;
    }
}

class LinkedListQueue {
    private Node start; // Start of the queue
    private Node end; // End of the queue
    private int size; // Size of the queue
    // Constructor

    public LinkedListQueue() {
        start = end = null;
        size = 0;
    }

    // Method to push an element in the queue
    public void push(int x) {
        Node element = new Node(x);

        if (start == null) {
            start = end = element;
        } else {
            end.next = element;
            end = element;
        }
        size++;
    }

    public int pop() {
        if (start == null) {
            return -1;// Pop operation cannot be performed

        }
        int value = start.val; // Get the front value
        Node temp = start; // Store the front temporarily
        start = start.next; // Update front to next node
        temp = null; // Delete old front node
        size--; // Decrement size

        return value; // Return data
    }

    public int peek() {
        if (start == null) {
            return -1;// Front element cannot be accessed
        }
        return start.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

public class p6_Implement_Queue_using_Linked_List {
    public static void main(String[] args) {
        LinkedListQueue q = new LinkedListQueue();
        String[] commands = { "LinkedListQueue", "push", "push",
                "peek", "pop", "isEmpty" };
        // Array of inputs
        int[][] inputs = { {}, { 3 }, { 7 }, {}, {}, {} };

        for (int i = 0; i < commands.length; ++i) {
            if (commands[i].equals("push")) {
                q.push(inputs[i][0]);
                System.out.print("null ");
            } else if (commands[i].equals("pop")) {
                System.out.print(q.pop() + " ");
            } else if (commands[i].equals("peek")) {
                System.out.print(q.peek() + " ");
            } else if (commands[i].equals("isEmpty")) {
                System.out.print((q.isEmpty() ? "true" : "false") + " ");
            } else if (commands[i].equals("LinkedListQueue")) {
                System.out.print("null ");
            }
        }
    }
}
