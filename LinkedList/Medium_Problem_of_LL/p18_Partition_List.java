import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class p18_Partition_List {

    public static Node partition(Node head, int x) {
        Node beforeHead = new Node(0);
        Node before = beforeHead;

        Node afterHead = new Node(0);
        Node after = afterHead;

        Node current = head;

        while (current != null) {
            if (current.data < x) {
                before.next = current;
                before = before.next;
            } else {
                after.next = current;
                after = after.next;
            }
            current = current.next;
        }

        after.next = null; // end the after list
        before.next = afterHead.next; // connect two lists

        return beforeHead.next;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(2);

        int x = 3;
        Node result = partition(head, x);
        printList(result);
    }
}
