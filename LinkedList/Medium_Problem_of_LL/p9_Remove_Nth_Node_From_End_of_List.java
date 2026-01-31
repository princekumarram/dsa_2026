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

public class p9_Remove_Nth_Node_From_End_of_List {

    // static Node removeNthNodeFromEnd(Node head, int N) {
    // if (head == null)
    // return head;

    // int cnt = 0;
    // Node temp = head;

    // // Count total nodes
    // while (temp != null) {
    // cnt++;
    // temp = temp.next;
    // }

    // // If head needs to be removed
    // if (N == cnt) {
    // return head.next;
    // }

    // temp = head;
    // int curr = 1;

    // // Traverse to node just before the target
    // while (temp != null) {
    // if (curr == cnt - N) {
    // temp.next = temp.next.next;
    // break;
    // }
    // curr++;
    // temp = temp.next;
    // }

    // return head;
    // }

    static Node removeNthNodeFromEnd2(Node head, int N) {
        Node dummy = new Node(0, head);

        // Initialize slow and fast pointers at dummy
        Node slow = dummy;
        Node fast = dummy;

        // Move fast pointer N+1 steps ahead to create a gap
        for (int i = 0; i <= N; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Slow is now at node before target → delete target node
        slow.next = slow.next.next;

        // Return updated head
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Node newHead = removeNthNodeFromEnd(head, 3);
        Node newHead2 = removeNthNodeFromEnd2(head, 3);

        // // Print result
        // while (newHead != null) {
        // System.out.print(newHead.data + " ");
        // newHead = newHead.next;
        // }
        System.out.println();
        System.out.println("-------------------------------------");

        while (newHead2 != null) {
            System.out.print(newHead2.data + " ");
            newHead2 = newHead2.next;
        }
    }
}