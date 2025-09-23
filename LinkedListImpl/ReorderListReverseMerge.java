package LinkedListImpl;

import LinkedList.Node.Node;

public class ReorderListReverseMerge {
    public void reoderList(Node head) {
        //Find middle
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse
        Node second = slow.next;
        slow.next = null;
        Node prev = null;
        while(second != null) {
            Node temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        //Merge
        Node first = head;
        second = prev;
        while(first != null && second != null) {
            Node temp1 = first.next;
            Node temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
}
