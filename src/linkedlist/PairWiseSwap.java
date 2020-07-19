package linkedlist;

import linkedlist.dto.SingleLinkedListNode;

public class  PairWiseSwap {

    private static SingleLinkedListNode doPairWiseSwap(SingleLinkedListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        SingleLinkedListNode current = head.getNext().getNext();
        SingleLinkedListNode previous = current;
        head = head.getNext();
        head.setNext(previous);

        while (current != null && current.getNext() == null) {
            previous.setNext(current.getNext());
            previous = current;
            SingleLinkedListNode next = current.getNext().getNext();
            current = next;
        }
        previous.setNext(current);

        return head;
    }
}
