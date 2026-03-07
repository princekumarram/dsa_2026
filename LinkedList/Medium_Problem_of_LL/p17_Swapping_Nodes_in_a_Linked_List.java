import java.util.ArrayList;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class p17_Swapping_Nodes_in_a_Linked_List {
    public static Node swapNodes(Node head, int k) {
        ArrayList<Integer> arr = new ArrayList<>();

        Node temp = head;

        while (temp != null) {
            arr.add(temp.data);
            temp = temp.next;
        }

        int n = arr.size();
        int firstIndex = k - 1;
        int secondIndex = n - k;
        int tempVal = arr.get(firstIndex);

        arr.set(firstIndex, arr.get(secondIndex));
        arr.set(secondIndex, tempVal);

        temp = head;
        int i = 0;
        while (temp != null) {
            temp.data = arr.get(i);
            temp = temp.next;
            i++;
        }
        return head;
    }

    static Node swapNodes2(Node head, int k) {
        Node first = head;
        Node second = head;
        Node temp = head;

        // Step 1:Move first to kth node
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        // Step 2: Move temp from kth node to end
        temp = first;
        while (temp.next != null) {
            temp = temp.next;
            second = second.next;
        }

        // Step 3 : Swap values
        int swap = first.data;
        first.data = second.data;
        second.data = swap;

        return head;

    }

    public static void main(String[] args) {
        // Creating linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 2;

        // head = swapNodes(head, k);
        head = swapNodes2(head, k);

        // Print updated list
        printList(head);
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
