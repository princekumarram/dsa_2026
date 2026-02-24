class Node {
    int data;
    Node next;
    Node prev;

    // Constructor
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

public class p2_Remove_duplicates_from_sorted_DLL {

    public static Node removeDuplicates(Node head) {
        if (head == null)
            return null;

        Node current = head;

        while (current != null && current.next != null) {
            Node nextDistinct = current.next;

            // Skip and unlink all nodes with the same value as current

            while (nextDistinct != null && nextDistinct.data == current.data) {
                nextDistinct = nextDistinct.next;
            }

            // Connect current node to the next distinct node

            current.next = nextDistinct;
            if (nextDistinct != null) {
                nextDistinct.prev = current;
            }
            // Move to next node
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next = new Node(4);

        Node result = removeDuplicates(head);

        // Print result
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }

    }

}
