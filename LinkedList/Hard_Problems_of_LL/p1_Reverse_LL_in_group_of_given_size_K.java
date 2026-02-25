
// Definition for singly-linked list node
class Node {
    int val;
    Node next;

    Node(int data) {
        val = data;
        next = null;
    }
}

public class p1_Reverse_LL_in_group_of_given_size_K {

    static Node reverseKGroup(Node head, int k) {
        Node dummy = new Node(0);
        dummy.next = head;

        // Pointer to tail of the last reversed group
        Node groupPrev = dummy;

        while (true) {
            Node kth = getKthNode(groupPrev, k);
            if (kth == null)
                break;

            // Store the next group's head
            Node groupNext = kth.next;

            // Reverse the current k-group
            Node prev = groupNext;
            Node curr = groupPrev.next;

            for (int i = 0; i < k; i++) {
                Node temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            // Connect the previous group to the reversed group
            Node temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }
        // Return the new head
        return dummy.next;
    }

    // Helper function to get the k-th node from the current node

    static Node getKthNode(Node curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    public static void main(String[] args) {
        // Creating the linked list: 1->2->3->4->5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 2;

        // Reversing in groups of k
        Node result = reverseKGroup(head, k);

        // Printing the final list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;

        }
    }
}
