import java.util.ArrayList;
import java.util.Collections;

class Node {
    // Data stored in the node
    int data;

    // Pointer to the next node in the list
    Node next;

    // Constructor with both data and
    // next node as parameters
    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    // Constructor with only data as a
    // parameter, sets next to null
    Node(int data1) {
        data = data1;
        next = null;
    }
}

public class p15_Merge_two_sorted_LinkedLists {

    static Node convertArrToLinkedList(ArrayList<Integer> arr) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        for (int i = 0; i < arr.size(); i++) {
            temp.next = new Node(arr.get(i));
            temp = temp.next;
        }
        return dummyNode.next;
    }

    // BRUTE FORCE

    static Node sortTwoLinkedLists(Node list1, Node list2) {
        ArrayList<Integer> arr = new ArrayList<>();
        Node temp1 = list1;
        Node temp2 = list2;

        while (temp1 != null) {
            arr.add(temp1.data);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            arr.add(temp2.data);
            temp2 = temp2.next;
        }

        Collections.sort(arr);

        Node head = convertArrToLinkedList(arr);

        return head;

    }

    // OPTIMAL SOLUTION
    static Node sortTwoLinkedLists2(Node list1, Node list2) {
        Node dummyNode = new Node(-1);
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

        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        return dummyNode.next;
    }

    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            // Print the data of the current node
            System.out.print(temp.data + " ");
            // Move to the next node
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example Linked Lists
        Node list1 = new Node(1);
        list1.next = new Node(3);
        list1.next.next = new Node(5);

        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(6);

        System.out.print("First sorted linked list: ");
        printLinkedList(list1);

        System.out.print("Second sorted linked list: ");
        printLinkedList(list2);

        // Node mergedList = sortTwoLinkedLists(list1, list2);
        Node mergedList = sortTwoLinkedLists2(list1, list2);

        System.out.print("Merged sorted linked list: ");
        printLinkedList(mergedList);
    }
}
