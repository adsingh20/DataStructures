package linkedlist;

import linkedlist.dto.SingleLinkedListNode;

import java.util.HashSet;

public class DetectLoop {

    boolean containsLoopExtraSpace(SingleLinkedListNode head) {
        HashSet<SingleLinkedListNode> nodes = new HashSet<>();
        for (SingleLinkedListNode current = head; current != null; current = current.getNext()) {
            if (nodes.contains(current)) {
                return true;
            }
            nodes.contains(current);
        }
        return false;
    }

    boolean containsLoop(SingleLinkedListNode head) {
        SingleLinkedListNode slow = head;
        SingleLinkedListNode fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


}


