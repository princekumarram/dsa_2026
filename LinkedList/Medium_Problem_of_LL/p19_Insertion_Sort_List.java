class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class p19_Insertion_Sort_List {

    public static Node insertionSortList(Node head) {
        Node dummy = new Node(0); // start of sorted list
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;

            // find position in sorted list
            Node prev = dummy;
            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }
            // insert current node
            current.next = prev.next;
            prev.next = current;

            current = nextNode;
        }

        return dummy.next;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        // Creating the linked list: 4 -> 2 -> 1 -> 3
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        System.out.print("Original List: ");
        printList(head);

        // Call insertion sort
        head = insertionSortList(head);

        System.out.print("\nSorted List: ");
        printList(head);
    }
}
