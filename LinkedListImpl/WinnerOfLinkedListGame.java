package LinkedListImpl;

public class WinnerOfLinkedListGame {
    public String gameResult(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;
        int evenCount = 0;
        int oddCount = 0;

        while (current != null && current.next != null) {
            if (current.value > current.next.value) {
                evenCount++;
            } else if (current.value < current.next.value) {
                oddCount++;
            }
            current = current.next.next;
        }

        if (evenCount > oddCount) {
            return "Even";
        } else if (evenCount < oddCount) {
            return "Odd";
        } else {
            return "Tie";
        }
    }
}