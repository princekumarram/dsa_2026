import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

}

public class p10_SortLL {

    // static Node sortLL(Node head) {
    // ArrayList<Integer> arr = new ArrayList<>();
    // Node temp = head;

    // while (temp != null) {
    // arr.add(temp.data);
    // temp = temp.next;
    // }

    // Collections.sort(arr);

    // temp = head;

    // for (int i = 0; i < arr.size(); i++) {
    // temp.data = arr.get(i);
    // temp = temp.next;
    // }
    // return head;
    // }

    static Node mergeTwoSortedLinkedLists(Node list1, Node list2) {

        Node dummyNode = new Node(-1, null);
        Node temp = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        return dummyNode.next;
    }

    public static Node findMiddle(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node sortLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = findMiddle(head);

        // Split into two halves
        Node right = middle.next;
        middle.next = null;
        Node left = head;

        // Recursively sort both halves
        left = sortLL(left);
        right = sortLL(right);

        return mergeTwoSortedLinkedLists(left, right);
    }

    static void printLinkedList(Node head) {
        // Pointer to traverse list
        Node temp = head;

        // Traverse and print values
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(5);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(1);

        // Print original list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Sort the linked list
        head = sortLL(head);

        // Print sorted list
        System.out.print("Sorted Linked List: ");
        printLinkedList(head);
    }
}
