package LinkedListImpl;

import LinkedList.Node.Node;

//location found:
//key >= prev.val && key <= current.val
//key > prev.val && key > current.val
//key < prev.val && key < current.val

public class InsertIntoSortedCircularLinkedList {
    public Node insertSortedCircular(Node head, int key) {
        Node newNode = new Node(key);

        // empty list
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        Node prev = head;
        Node current = head.next;

        while (current != head) {
            if ((key >= prev.value && key <= current.value)
                    || (key > prev.value && key > current.value)
                    || (key < prev.value && key < current.value)) {
                break;
            }
            prev = prev.next;
            current = current.next;
        }

        prev.next = newNode;
        newNode.next = current;
        return key < head.value ? newNode : head;
    }
}
