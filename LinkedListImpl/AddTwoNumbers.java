package LinkedListImpl;

import LinkedList.Node.Node;

public class AddTwoNumbers {
    public Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node current = dummy;

        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int v1 = l1 != null ? l1.value : 0;
            int v2 = l2 != null ? l2.value : 0;
            int val = v1 + v2 + carry;
            carry = val / 10;
            val = val % 10;

            current.next = new Node(val);
            current = current.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return dummy.next;
    }
}
