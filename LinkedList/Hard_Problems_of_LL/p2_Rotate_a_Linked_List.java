// Definition for singly-linked list node
class Node {
    int val;
    Node next;

    Node(int data) {
        val = data;
        next = null;
    }
}

public class p2_Rotate_a_Linked_List {

    // Function to rotate the list to the right by k positons

    // BRUTE FORCE
    static Node rotateRight(Node head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        for (int i = 0; i < k; i++) {
            // Initialize pointers for traversal
            Node curr = head;
            Node prev = null;

            // Traverse to last node
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }

            // cut the last node
            prev.next = null;

            // Move it to the front
            curr.next = head;
            head = curr;
        }
        // Return rotated list
        return head;
    }

    // OPTIMAL SOLUTION

    static Node rotateRight2(Node head, int k) {
        // If list is empty or only one node or k = 0, return head
        if (head == null || head.next == null || k == 0)
            return head;

        // Initialize length and tail
        int length = 1;
        Node tail = head;

        // Traverse to find tail and calculate length
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Make the list circular
        tail.next = head;

        // Calculate effective rotation
        k = k % length;

        // Traverse to new tail position
        int stepsToNewTail = length - k;
        Node newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // New head is next of newTail
        Node newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
    }

    public static void main(String[] args) {

        // Create linked list: 1->2->3->4->5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 2;
        // Node result = rotateRight(head, k);

        // // Print result
        // while (result != null) {
        // System.out.print(result.val + " ");
        // result = result.next;
        // }
        System.out.println();

        Node result2 = rotateRight2(head, k);

        // Print result
        while (result2 != null) {
            System.out.print(result2.val + " ");
            result2 = result2.next;
        }
    }
}
