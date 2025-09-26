package LinkedListImpl;

public class ReverseNodesInKgroup {
    public Node reverse(Node head, int k) {
        Node dummy = new Node(0, head);
        Node groupPrev = dummy;

        while (true) {
            Node kth = getKth(groupPrev, k);
            if (kth == null) {
                break;
            }

            Node groupNext = kth.next;
            Node prev = kth.next;
            Node current = groupPrev.next;
            while (current != groupNext) {
                Node tmp = current.next;
                current.next = prev;
                prev = current;
                current = tmp;
            }

            Node tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }

        return dummy.next;

    }

    private Node getKth(Node current, int k) {
        while (current != null && k > 0) {
            current = current.next;
            k--;
        }
        return current;
    }

}
