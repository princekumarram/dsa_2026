import java.util.*;

// Node definition for linked list with child pointers
class Node {
    int data;
    Node next;
    Node child;

    Node() {
        data = 0;
        next = null;
        child = null;
    }

    Node(int data1) {
        data = data1;
        next = null;
        child = null;
    }

    Node(int data1, Node next1, Node child1) {
        data = data1;
        next = next1;
        child = child1;
    }
}

public class p3_Flattening_of_LL {

    // BRUTE FORCE
    static Node flattenLinkedList(Node head) {
        List<Integer> arr = new ArrayList<>();

        while (head != null) {
            Node t2 = head;
            while (t2 != null) {
                arr.add(t2.data);
                t2 = t2.child;
            }
            head = head.next;
        }

        Collections.sort(arr);
        return convertArrToLinkedList(arr);
    }

    static Node convertArrToLinkedList(List<Integer> arr) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        for (int val : arr) {
            temp.child = new Node(val);
            temp = temp.child;
        }
        return dummyNode.child;
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.child;
        }
        System.out.println();
    }

    static void printOriginalLinkedList(Node head, int depth) {
        while (head != null) {
            System.out.print(head.data);
            if (head.child != null) {
                System.out.print("->");
                printOriginalLinkedList(head.next, depth + 1);
            }
            if (head.next != null) {
                System.out.println();
                for (int i = 0; i < depth; i++) {
                    System.out.print("| ");
                }
            }
            head = head.next;
        }
    }

    // OPTIMAL SOLUTION
    static Node merge(Node list1, Node list2) {
        Node dummyNode = new Node(-1);
        Node res = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                res.child = list1;
                res = list1;
                list1 = list1.child;
            } else {
                res.child = list2;
                res = list2;
                list2 = list2.child;
            }
            res.next = null;
        }

        if (list1 != null)
            res.child = list1;
        else
            res.child = list2;

        if (dummyNode.child != null) {
            dummyNode.child.next = null;
        }

        return dummyNode.child;
    }

    // Flatten a multi-level linked list

    public static Node flattenLinkedList2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mergedHead = flattenLinkedList(head.next);
        return merge(head, mergedHead);
    }

    public static void main(String[] args) {
        // Create linked list with child pointers
        Node head = new Node(5);
        head.child = new Node(14);

        head.next = new Node(10);
        head.next.child = new Node(4);

        head.next.next = new Node(12);
        head.next.next.child = new Node(20);
        head.next.next.child.child = new Node(13);

        head.next.next.next = new Node(7);
        head.next.next.next.child = new Node(17);

        // Print original list
        System.out.println("Original linked list:");
        printOriginalLinkedList(head, 0);

        // Node flattened = flattenLinkedList(head);
        Node flattened = flattenLinkedList2(head);

        System.out.print("\nFlattened linked list: ");
        printLinkedList(flattened);
    }
}
