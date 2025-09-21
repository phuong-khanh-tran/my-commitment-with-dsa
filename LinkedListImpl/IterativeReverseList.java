package LinkedListImpl;

import LinkedList.Node.Node;
// import LinkedList.SinglyLinkedList.SinglyLinkedList;

public class IterativeReverseList {
    Node reverseList(Node head) {
        Node current = head;
        Node prev = null;

        while (current != null) {
            Node temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}

// class Main {
// public static void main(String[] args) {
// SinglyLinkedList list = new SinglyLinkedList();
// list.insertLast(1);
// list.insertLast(2);
// list.insertLast(3);
// list.insertLast(4);
// list.insertLast(5);

// IterativeReverseList reverse = new IterativeReverseList();
// Node r = reverse.reverseList(list.head);
// list.printList(r);
// }
// }
