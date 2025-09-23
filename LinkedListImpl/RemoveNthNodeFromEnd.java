package LinkedListImpl;

class Node {
    int value;
    Node next;

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

public class RemoveNthNodeFromEnd {
    public Node removeNthNodeFromEnd(Node head, int n) {
        Node dummy = new Node(0, head);
        Node left = dummy;
        Node right = head;

        while (n > 0) {
            right = right.next;
            n--;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return dummy.next;
    }
}
