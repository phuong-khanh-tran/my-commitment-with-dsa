package LinkedListImpl;

import LinkedList.Node.Node;
import LinkedList.SinglyLinkedList.SinglyLinkedList;

public class RotateList {
    public Node rotate(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        Node tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;
        if (k == 0) {
            return head;
        }

        Node current = head;
        for (int i = 0; i < length - k - 1; i++) {
            current = current.next;
        }

        Node newHead = current.next;
        current.next = null;
        tail.next = head;

        return newHead;
    }
}

class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        RotateList rotator = new RotateList();
        Node newNode = rotator.rotate(list.head, 2);

        list.printList(newNode);
    }
}

// Commands:
// javac LinkedList/Node/Node.java
// LinkedList/SinglyLinkedList/SinglyLinkedList.java
// LinkedListImpl/RotateList.java
// java LinkedListImpl.Main
