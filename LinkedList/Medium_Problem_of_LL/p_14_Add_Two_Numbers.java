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

    public static Node addTwoNumbers(Node l1, Node l2) {
        // Intialize a dummy node as a new node
        Node dummy = new Node(0);
        Node temp = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;

            }
            // Repeat the same process for l2 as l1

            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            // Carry grts added to sum in the node (carry=sum/10)
            sum += carry;
            carry = sum / 10;

            Node node = new Node(sum % 10);
            temp.next = node;
            temp = temp.next;
        }

        return dummy.next;

    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        LinkedList l2 = new LinkedList();

        Node head1 = null;
        Node head2 = null;

        // 243
        head1 = ll.append(head1, 2);
        head1 = ll.append(head1, 4);
        head1 = ll.append(head1, 3);

        System.out.print("First Number: ");
        ll.printList(head1);

        // 564
        head2 = l2.append(head2, 5);
        head2 = l2.append(head2, 6);
        head2 = l2.append(head2, 4);

        System.out.print("Second Number: ");
        l2.printList(head2);

        Node result = addTwoNumbers(head1, head2);

        System.out.print("Sum : ");
        ll.printList(result);
    }
}
