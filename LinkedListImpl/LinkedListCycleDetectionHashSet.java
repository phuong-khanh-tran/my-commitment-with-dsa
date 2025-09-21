package LinkedListImpl;

import java.util.HashSet;
import java.util.Set;

import LinkedList.Node.Node;

public class LinkedListCycleDetectionHashSet {
    public boolean hasCycle(Node head) {
        Set<Node> seen = new HashSet<>();
        Node current = head;

        while (current != null) {
            if (seen.contains(current)) {
                return true;
            }
            seen.add(current);
            current = current.next;
        }
        return false;
    }
}
