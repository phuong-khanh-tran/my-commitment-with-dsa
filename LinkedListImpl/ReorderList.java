package LinkedListImpl;

import LinkedList.Node.Node;

public class ReorderList {
    public void reorderList(Node head) {
        rec(head, head.next);
    }

    private Node rec(Node root, Node current) {
        if (current == null) {
            return root;
        }

        root = rec(root, current.next);
        if (root == null) {
            return null;
        }
        Node temp = null;
        if (root == current || root.next == current) {
            return current.next = null;
        } else {
            temp = root.next;
            root.next = current;
            current.next = temp;
        }
        return temp;
    }

}