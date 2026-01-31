class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class p8_Odd_Even_Linked_List {

    static Node oddEvenLinkedList(Node head) {

        if (head == null || head.next == null) {
            return head;
        }
        Node odds = new Node(0);
        Node evens = new Node(0);
        Node evenP = evens, oddP = odds;
        boolean flag = true;

        while (head != null) {
            if (flag) {
                oddP.next = head;
                oddP = oddP.next;
            } else {
                evenP.next = head;
                evenP = evenP.next;
            }
            head = head.next;
            flag = !flag;

        }
        evenP.next = null;
        oddP.next = evens.next;

        return odds.next;
    }

    static Node oddEvenLinkedList2(Node head) {
        // Edge cases
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize pointers
        Node odd = head; // 1st node
        Node even = head.next; // 2nd node
        Node evenHead = even; // Save start of even list

        // Rearrange nodes
        while (even != null && even.next != null) {
            odd.next = even.next; // Link odd to next odd
            odd = odd.next;

            even.next = odd.next; // Link even to next even
            even = even.next;
        }

        // Attach even list after odd list
        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(6);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(7);

        Node newHead = oddEvenLinkedList(head);
        Node newHead2 = oddEvenLinkedList2(head);

        // Print result
        while (newHead != null) {
            System.out.print(newHead.data + " ");
            newHead = newHead.next;
        }

        System.out.println();
        System.out.println("------------------------------------");

        while (newHead2 != null) {
            System.out.print(newHead2.data + " ");
            newHead2 = newHead2.next;
        }
    }
}
