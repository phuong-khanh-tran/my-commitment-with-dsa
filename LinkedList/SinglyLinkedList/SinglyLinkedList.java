package LinkedList.SinglyLinkedList;

import java.util.NoSuchElementException;
import LinkedList.Node.Node;

public class SinglyLinkedList {
    public Node head;
    public Node tail;

    public void insertFirst(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = newNode;
        }
    }

    void insertAtPosition(int val, int position) {
        if (position < 0) {
            throw new IndexOutOfBoundsException("Negative position is not allowed");
        }

        if (position == 0) {
            insertFirst(val);
            return;
        }

        Node current = head;
        int count = 0;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }

        Node newNode = new Node(val);
        newNode.next = current.next;
        current.next = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }
    }

    public void insertLast(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    void deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        head = head.next;

        if (head == null) {
            tail = null;
            return;
        }
    }

    void deleteAtPosition(int position) {
        if (position < 0) {
            throw new IndexOutOfBoundsException("Negative position is not allowed");
        }

        if (position == 0) {
            deleteFirst();
            return;
        }

        Node current = head;
        int count = 0;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current == null || current.next == null) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }

        current.next = current.next.next;
        if (current.next == null) {
            tail = current;
        }
    }

    void deleteLast() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        if (head.next == null) {
            head = null;
            tail = null;
            return;
        }

        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }

        current.next = null;
        tail = current;
    }

    public void printList(Node rotatedHead) {
        Node current = rotatedHead;
        while (current != null) {
            System.out.println(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

}
