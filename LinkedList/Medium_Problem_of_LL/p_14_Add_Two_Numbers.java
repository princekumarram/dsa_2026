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

// LinkedList class to manage node-level operations
class LinkedList {
    // function to insert digit at the end
    Node append(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null) {
            return newNode;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    // Function to print the list
    void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
        }
        System.out.println();
    }
}

public class p_14_Add_Two_Numbers {

    static Node addTwoNumbers(Node l1, Node l2) {
        // Intialize a dummy node as a new node

    }

    public static void main(String[] args) {
        Node head = null;
        LinkedList ll = new LinkedList();

        // Example: {2, 4, 3}; // represents 342
        head = ll.append(head, 2);
        head = ll.append(head, 4);
        head = ll.append(head, 3);

        System.out.print("Original Number: ");
        ll.printList(head);

        head = null;
        LinkedList l2 = new LinkedList();
        // Example: {5, 6, 4}; // represents 465

        head = l2.append(head, 5);
        head = l2.append(head, 6);
        head = l2.append(head, 4);

        System.out.print("Original Number: ");
        l2.printList(head);

        // head = addOne(head);
        head = addTwoNumbers(ll, l2);

        System.out.print("After Adding One: ");
        ll.printList(head);
    }
}
