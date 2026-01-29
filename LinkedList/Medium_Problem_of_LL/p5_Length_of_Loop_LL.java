
import java.util.HashMap;

class Node {
    int data;
    Node next;

    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    Node(int data1) {
        data = data1;
        next = null;
    }
}

public class p5_Length_of_Loop_LL {

    public static int lengthOfLoop(Node head) {
        HashMap<Node, Integer> visitedNodes = new HashMap<>();

        Node temp = head;
        int timer = 0;

        while (temp != null) {
            if (visitedNodes.containsKey(temp)) {
                int loopLength = timer - visitedNodes.get(temp);
                return loopLength;
            }
            visitedNodes.put(temp, timer);
            temp = temp.next;
            timer++;
        }
        return 0;
    }

    public static int lengthOfLoop2(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return countLoopLength(slow);
            }
        }
        return 0;
    }

    public static int countLoopLength(Node meetingPoint) {
        Node temp = meetingPoint;

        int length = 1;

        while (temp.next != meetingPoint) {
            temp = temp.next;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        // Creating a sample linked list with a loop
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        // Linking the nodes
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // Creating a loop from fifth to second
        fifth.next = second;

        // Getting the loop length
        int loopLength = lengthOfLoop(head);

        // Printing the result
        if (loopLength > 0) {
            System.out.println("Length of the loop: " + loopLength);
        } else {
            System.out.println("No loop found in the linked list.");
        }

        int loopLength2 = lengthOfLoop2(head);

        // Printing the result
        if (loopLength2 > 0) {
            System.out.println("Length of the loop: " + loopLength2);
        } else {
            System.out.println("No loop found in the linked list.");
        }
    }

}
