import java.util.NoSuchElementException;

class Node {
    int value;
    Node next;
    Node prev;

    Node(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    Node head;
    Node tail;

    void insertFirst(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        newNode.prev = null;

        if (head != null) {
            head.prev = newNode;
        }

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
        newNode.prev = current;

        if (current.next != null) {
            current.next.prev = newNode;
        }

        current.next = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }
    }

    void insertEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
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

        head.prev = null;
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

        Node nodeToDel = current.next;

        if (nodeToDel.next != null) {
            nodeToDel.next.prev = current;
        }

        current.next = nodeToDel.next;

        if (current.next == null) {
            tail = current;
        }
    }

    void deleteLast() {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }

        if (head.next == null) {
            head = null;
            tail = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;
    }
}
