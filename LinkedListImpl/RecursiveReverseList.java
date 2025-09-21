package LinkedListImpl;

import LinkedList.Node.Node;
import LinkedList.SinglyLinkedList.SinglyLinkedList;

public class RecursiveReverseList {
    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newNode = head;
        if (head.next != null) {
            newNode = reverse(head.next);
            head.next.next = head;
        }
        head.next = null;

        return newNode;
    }
}
