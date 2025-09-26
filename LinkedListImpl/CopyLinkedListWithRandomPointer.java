package LinkedListImpl;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyLinkedListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToCopy = new HashMap<>();
        Node current = head;
        oldToCopy.put(null, null);

        while (current != null) {
            if (!oldToCopy.containsKey(current)) {
                oldToCopy.put(current, new Node(0));
            }
            oldToCopy.get(current).val = current.val;

            if (!oldToCopy.containsKey(current.next)) {
                oldToCopy.put(current.next, new Node(0));
            }
            oldToCopy.get(current).next = oldToCopy.get(current.next);

            if (!oldToCopy.containsKey(current.random)) {
                oldToCopy.put(current.random, new Node(0));
            }
            oldToCopy.get(current).random = oldToCopy.get(current.random);

            current = current.next;
        }

        return oldToCopy.get(head);
    }
}
