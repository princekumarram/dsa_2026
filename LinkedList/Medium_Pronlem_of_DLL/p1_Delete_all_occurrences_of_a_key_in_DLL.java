
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

public class p1_Delete_all_occurrences_of_a_key_in_DLL {

    static Node deleteAllOccurOfX(Node head, int x) {
        Node curr = head;

        while (curr != null) {
            Node nextNode = curr.next;

            if (curr.data == x) {
                if (curr == head) {
                    head = head.next;
                    if (head != null)
                        head.prev = null;
                } else {
                    if (curr.prev != null)
                        curr.prev.next = curr.next;

                    if (curr.next != null)
                        curr.next.prev = curr.prev;
                }
            }
            curr = nextNode;
        }
        return head;
    }

    // Function to print DLL
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null)
                System.out.print(" <-> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Creating list: 2 <-> 2 <-> 10 <-> 8 <-> 4 <-> 2 <-> 5 <-> 2
        Node head = new Node(2);
        head.next = new Node(2);
        head.next.prev = head;

        head.next.next = new Node(10);
        head.next.next.prev = head.next;

        head.next.next.next = new Node(8);
        head.next.next.next.prev = head.next.next;

        head.next.next.next.next = new Node(4);
        head.next.next.next.next.prev = head.next.next.next;

        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.prev = head.next.next.next.next;

        head.next.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next.prev = head.next.next.next.next.next;

        head.next.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next.prev = head.next.next.next.next.next.next;

        int x = 2;

        head = deleteAllOccurOfX(head, x);

        printList(head);
    }
}
