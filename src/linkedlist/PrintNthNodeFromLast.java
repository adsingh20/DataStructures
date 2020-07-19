package linkedlist;

import linkedlist.dto.SingleLinkedListNode;

public class PrintNthNodeFromLast {

    private static void printNthNodeFromLastNaiveSolution(SingleLinkedListNode head, int n) {
        int length = 0;
        for (SingleLinkedListNode curr = head; curr != null; curr = curr.getNext()) {
            length++;
        }
        if (length < n) {
            return;
        }
        SingleLinkedListNode curr = head;
        for (int i = 0; i < length - n + 1; i++) {
            curr = curr.getNext();
        }
        System.out.println(curr.getData());
    }

    private static void printNthNodeFromLast(SingleLinkedListNode head, int n) {
        int length = 0;
        SingleLinkedListNode first = head;
        SingleLinkedListNode second = head;
        for (int i = 0; i < n; i++) {
            if (first == null) {
                return;
            }
            first = first.getNext();
        }
        while (first != null) {
            first = first.getNext();
            second = second.getNext();
        }
        System.out.println(second.getData());
    }
}
