package linkedlist;

import linkedlist.dto.SingleLinkedListNode;

public class ReverseLinkedList {

    private static SingleLinkedListNode reverseALinkedList(SingleLinkedListNode head) {
        SingleLinkedListNode current = head;
        SingleLinkedListNode previous = null;
        while (current != null) {
            SingleLinkedListNode next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        return previous;
    }

    private static SingleLinkedListNode reverseALinkedListRecursively(SingleLinkedListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        SingleLinkedListNode rest_head = reverseALinkedList(head.getNext());
        SingleLinkedListNode rest_tail = head.getNext();
        rest_tail.setNext(head);
        head.setNext(null);
        return rest_head;
    }

    private static SingleLinkedListNode reverseALinkedListRecursively2(SingleLinkedListNode current,
                                                                       SingleLinkedListNode previous) {
        if (current == null) {
            return previous;
        }
        SingleLinkedListNode next = current;
        current.setNext(previous);
        return reverseALinkedListRecursively2(next, current);
    }

    private static SingleLinkedListNode reverseALinkedListKNodes(SingleLinkedListNode head, int count) {
        SingleLinkedListNode current = head;
        SingleLinkedListNode previousFirst = null;
        boolean isFirstPass = true;
        while (current != null) {
            SingleLinkedListNode first = current;
            SingleLinkedListNode previous = null;
            int k = 0;
            while (current != null && k < count) {
                SingleLinkedListNode next = current.getNext();
                current.setNext(previous);
                previous = current;
                current = next;
                count++;
            }
            if (isFirstPass) {
                head = previous;
                isFirstPass = false;
            } else {
                previousFirst.setNext(previous);
            }
            previousFirst = first;
        }
        return head;
    }

}
