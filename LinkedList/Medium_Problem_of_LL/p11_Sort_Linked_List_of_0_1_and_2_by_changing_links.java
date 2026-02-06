class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        head = null;
    }

    // Function to insert a new node at the end
    void insert(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println(" -> NULL");
    }
}

public class p11_Sort_Linked_List_of_0_1_and_2_by_changing_links {

    static void sortZeroOneTwo(LinkedList ll) {
        // Create dummy nodes for 0s, 1s, and 2s
        Node zeroDummy = new Node(-1);
        Node oneDummy = new Node(-1);
        Node twoDummy = new Node(-1);

        // Create tail pointers to add new nodes in respective lists
        Node zeroTail = zeroDummy;
        Node oneTail = oneDummy;
        Node twoTail = twoDummy;

        Node curr = ll.head;
        // Traverse the original list
        while (curr != null) {
            if (curr.data == 0) {
                zeroTail.next = curr;
                zeroTail = zeroTail.next;
            } else if (curr.data == 1) {
                oneTail.next = curr;
                oneTail = oneTail.next;
            } else {
                twoTail.next = curr;
                twoTail = twoTail.next;
            }
            curr = curr.next;
        }
        // Connect 0s list to 1s, and 1s to 2s
        zeroTail.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        oneTail.next = twoDummy.next;
        twoTail.next = null;

        // Update original list head
        ll.head = zeroDummy.next;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(0);
        ll.insert(1);
        ll.insert(2);
        ll.insert(0);

        System.out.println("Original List:");
        ll.print();

        // Sorting the list
        sortZeroOneTwo(ll);

        System.out.println("Sorted List:");
        ll.print();
    }
}