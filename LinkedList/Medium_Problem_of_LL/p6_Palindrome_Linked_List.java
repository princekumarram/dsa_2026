import java.util.Stack;

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

public class p6_Palindrome_Linked_List {

    // Brute Force-Stack
    public static boolean isPalindrome(Node head) {
        Stack<Integer> st = new Stack<>();

        Node temp = head;

        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }

        Node node = head;
        while (node != null) {
            if (node.data != st.pop())
                return false;

            node = node.next;
        }

        return true;

    }

    // Optimal Solution
    public static boolean isPalindrome2(Node head) {

        if (head == null || head.next == null)
            return true;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node newHead = reverseLinkedList(slow.next);

        Node first = head;
        Node second = newHead;

        while (second != null) {
            if (first.data != second.data) {
                reverseLinkedList(newHead);
                return false;
            }

            first = first.next;
            second = second.next;
        }

        reverseLinkedList(newHead);
        return true;
    }

    static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null)
            return head;

        Node newHead = reverseLinkedList(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }

    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(2);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);
        // Print the original linked list

        System.out.println("Original Linked List: ");
        printLinkedList(head);

        // Check if the linked list is a palindrome
        if (isPalindrome(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }

        System.out.println("-----------------------------------------");

        if (isPalindrome2(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
