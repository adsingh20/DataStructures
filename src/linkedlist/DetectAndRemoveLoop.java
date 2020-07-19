package linkedlist;

import linkedlist.dto.SingleLinkedListNode;

public class DetectAndRemoveLoop {

    void detectAndRemoveLoop(SingleLinkedListNode head) {
        SingleLinkedListNode slow = head;
        SingleLinkedListNode fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                break;
            }
        }
        if (slow != fast) {
            return;
        }
        slow = head;
        while (slow.getNext() != fast.getNext()) {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        fast.setNext(null);
    }
}
