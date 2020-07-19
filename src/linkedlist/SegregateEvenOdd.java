package linkedlist;

import linkedlist.dto.SingleLinkedListNode;

public class SegregateEvenOdd {

    private SingleLinkedListNode segregateEvenOddNodes(SingleLinkedListNode head) {
        SingleLinkedListNode oddStart = null;
        SingleLinkedListNode oddEnd = null;
        SingleLinkedListNode evenStart = null;
        SingleLinkedListNode evenEnd = null;

        for (SingleLinkedListNode current = head; current != null; current = current.getNext()) {
            int nodeValue = current.getData();
            if (nodeValue % 2 == 0) {
                if (evenStart == null) {
                    evenStart = current;
                    evenEnd = evenStart;
                } else {
                    evenEnd.setNext(current);
                    evenEnd = evenEnd.getNext();
                }
            } else {
                if (oddStart == null) {
                    oddStart = current;
                    oddEnd = evenStart;
                } else {
                    oddEnd.setNext(current);
                    oddEnd = oddEnd.getNext();
                }
            }
        }

        if (oddStart == null || evenStart == null) {
            return head;
        }
        evenEnd.setNext(oddStart);
        return evenStart;
    }
}
