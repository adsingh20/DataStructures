package linkedlist.dto;

public class MergeSortedLinkedList {

    SingleLinkedListNode mergeSortedLinkedList(SingleLinkedListNode first, SingleLinkedListNode second) {
        if (first == null) return second;
        if (second == null) return first;

        SingleLinkedListNode head;
        SingleLinkedListNode tail;

        if (first.getData() > second.getData()) {
            head = tail = second;
            second = second.getNext();
        } else {
            head = tail = first;
            first = first.getNext();
        }

        while (first != null && second != null) {
            if (first.getData() <= second.getData()) {
                tail.setNext(first);
                tail = first;
                first = first.getNext();
            } else {
                tail.setNext(second);
                tail = second;
                second = second.getNext();
            }
        }

        if (first == null) tail.setNext(second);
        if (second == null) tail.setNext(first);

        return head;
    }
}
