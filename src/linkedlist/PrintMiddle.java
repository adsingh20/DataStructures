package linkedlist;

import linkedlist.dto.SingleLinkedListNode;

public class PrintMiddle {

    void printMiddle(SingleLinkedListNode head) {
        if (head == null) {
            return;
        }

        SingleLinkedListNode slow = head, fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        System.out.println(slow.getData());
    }
}
