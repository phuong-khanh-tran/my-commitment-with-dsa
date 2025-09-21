package LinkedListImpl;

import LinkedList.Node.Node;

public class MergeTwoSortedLists {
    public Node mergeList(Node headL1, Node headL2) {
        Node dummy = new Node(-1);
        Node current = dummy;

        while (headL1 != null && headL2 != null) {
            if (headL1.value > headL2.value) {
                current.next = headL2;
                headL2 = headL2.next;
            } else {
                current.next = headL1;
                headL1 = headL1.next;
            }
            current = current.next;
        }

        if (headL1 == null) {
            current.next = headL2;
        } else {
            current.next = headL1;
        }

        return dummy.next;
    }
}
