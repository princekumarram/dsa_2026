import java.util.*;

//Method1
// class StackQueue {
//     private Stack<Integer> st1, st2;

//     // Constructor
//     public StackQueue() {
//         st1 = new Stack<>();
//         st2 = new Stack<>();
//     }

//     // Method to push element in the queue
//     public void push(int x) {
//         // Pop out elements from the first stack and push on top of the second stack
//         while (!st1.isEmpty()) {
//             st2.push(st1.pop());
//         }
//         // Insert the desired element
//         st1.push(x);

//         // pop out elements from the second stack and push back on top of the first
//         // stack
//         while (!st2.isEmpty()) {
//             st1.push(st2.pop());
//         }

//     }

//     public int pop() {
//         if (st1.isEmpty()) {
//             System.out.println("Stack is empty");
//             return -1;// Representing empty stack
//         }
//         int topElement = st1.pop();
//         return topElement;
//     }

//     public int peek() {
//         if (st1.isEmpty()) {
//             System.out.println("Stack is empty");
//             return -1;
//         }
//         return st1.peek();
//     }

//     public boolean isEmpty() {
//         return st1.isEmpty();
//     }

// }

// --------------------------METHOD2------------------
class StackQueue {
    private Stack<Integer> input, output;

    public StackQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    // Push element x to the back of queue

    public void push(int x) {
        input.push(x);
    }

    // Removes the element from in front of queue and returns that element
    public int pop() {
        // Shift input to output if output is empty
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        // If queue is still empty,return -1

        if (output.isEmpty()) {
            System.out.println("Queue is empty,cannot pop.");
            return -1;
        }
        return output.pop();
    }

    public int peek() {
        if (output.isEmpty()) {
            System.out.println("Queue is empty,cannot peek. ");
            return -1;
        }
        return output.peek();
    }

    // Returns true if the queue is empty,false otherwise
    public boolean isEmpty() {
        return input.isEmpty() && output.isEmpty();
    }
}

public class p4_Implement_Queue_using_Stack {

    // Method1
    // public static void main(String[] args) {
    // StackQueue q = new StackQueue();

    // String[] commands = { "StackQueue", "push", "push", "pop", "peek", "isEmpty"
    // };

    // int[][] inputs = { {}, { 4 }, { 8 }, {}, {}, {} };

    // for (int i = 0; i < commands.length; i++) {
    // if (commands[i].equals("push")) {
    // q.push(inputs[i][0]);
    // System.out.print("null ");
    // } else if (commands[i].equals("pop")) {
    // System.out.print(q.pop() + " ");
    // } else if (commands[i].equals("peek")) {
    // System.out.print(q.peek() + " ");
    // } else if (commands[i].equals("isEmpty")) {
    // System.out.print((q.isEmpty() ? "true" : "false") + " ");
    // } else if (commands[i].equals("StackQueue")) {
    // System.out.print("null ");
    // }
    // }
    // }

    // --------------------------METHOD2------------------

    public static void main(String[] args) {
        StackQueue q = new StackQueue();
        q.push(3);
        q.push(4);
        System.out.println("The element popped is " + q.pop());
        q.push(5);
        System.out.println("The front of the queue is " + q.peek());
        System.out.println("Is the queue empty? " + (q.isEmpty() ? "Yes" : "No"));
        System.out.println("The element popped is " + q.pop());
        System.out.println("The element popped is " + q.pop());
        System.out.println("Is the queue empty? " + (q.isEmpty() ? "Yes" : "No"));

    }
}
