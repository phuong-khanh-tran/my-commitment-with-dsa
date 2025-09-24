package LinkedListImpl;

public class RemoveNthNodeFromEndRecursive {
    public Node removeNthFromEnd(Node head, int n) {
        return rec(head, n, new int[] { 0 });
    }

    private Node rec(Node head, int n, int[] count) {
        if (head == null) {
            return null;
        }

        head.next = rec(head.next, n, count);
        count[0]++;
        if (count[0] == n) {
            return head.next;
        }

        return head;
    }
}
