package linkedlist;

import linkedlist.dto.SingleLinkedListNode;

public class FindIntersection {

    public SingleLinkedListNode getIntersectionNode(SingleLinkedListNode headA, SingleLinkedListNode headB) {
        SingleLinkedListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = (pa != null) ? pa.getNext() : headB;
            pb = (pb != null) ? pb.getNext() : headA;
        }
        return pa;
    }
}
