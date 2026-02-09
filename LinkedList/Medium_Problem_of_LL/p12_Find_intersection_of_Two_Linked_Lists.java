import java.util.HashSet;
import java.util.Set;

class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

public class p12_Find_intersection_of_Two_Linked_Lists {

    public static void insertNode(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // BRUTE FORCE
    // Utility function to check presence of intersection
    // public static Node intersectionPresent(Node head1, Node head2) {
    // while (head2 != null) {
    // Node temp = head1;
    // while (temp != null) {
    // if (temp == head2)
    // return head2;
    // temp = temp.next;
    // }
    // head2 = head2.next;
    // }
    // return null;// No intersection found
    // }

    // BETTER APPROACH
    // static Node intersectionPresent(Node head1, Node head2) {
    // Set<Node> st = new HashSet<>();// set to store visited nodes from the first
    // list
    // while (head1 != null) {
    // st.add(head1);
    // head1 = head1.next;
    // }

    // while (head2 != null) {
    // if (st.contains(head2))
    // return head2;// If node is found in set,it's the intersection point
    // head2 = head2.next;
    // }

    // return null;// Return null if no intersection is found
    // }

    // OPTIMAL APPROACH-1
    static Node intersectionPresent(Node head1, Node head2) {
        int diff = getDifference(head1, head2);

        if (diff < 0) {
            while (diff++ != 0)
                head2 = head2.next;
        } else {
            while (diff-- != 0)
                head1 = head1.next;
        }

        // Traverse both lists and compare node by node
        while (head1 != null) {
            if (head1 == head2)
                return head1;
            head2 = head2.next;
            head1 = head1.next;
        }
        return null;
    }

    static int getDifference(Node head1, Node head2) {
        int len1 = 0, len2 = 0;
        while (head1 != null || head2 != null) {
            if (head1 != null) {
                len1++;
                head1 = head1.next;
            }
            if (head2 != null) {
                len2++;
                head2 = head2.next;
            }
        }
        return len1 - len2;
    }

    // OPTIMAL APPROACH-2
    // static Node intersectionPresent(Node head1, Node head2) {
    // Node d1 = head1;
    // Node d2 = head2;

    // while (d1 != d2) {
    // d1 = d1 == null ? head2 : d1.next;
    // d2 = d2 == null ? head1 : d2.next;
    // }
    // return d1;

    // }

    // Utility function to print linked list
    public static void printList(Node head) {
        while (head != null && head.next != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        if (head != null) {
            System.out.print(head.data);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        insertNode(head, 3);
        insertNode(head, 1);
        insertNode(head, 2);
        insertNode(head, 4);

        Node head1 = head;
        head = head.next.next.next;// Intersection point
        Node headSec = new Node(3);
        Node head2 = headSec;
        headSec.next = head;
        System.out.print("List1: ");
        printList(head1);
        System.out.print("List2: ");
        printList(head2);

        // Checking if intersection is present
        Node answerNode = intersectionPresent(head1, head2);
        if (answerNode == null) {
            System.out.println("No intersection");
        } else {
            System.out.println("The intersection point is " + answerNode.data);
        }
    }
}
