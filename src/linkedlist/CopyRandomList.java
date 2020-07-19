package linkedlist;

import linkedlist.dto.RandomListNode;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode iter = head, next;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (iter != null) {
            next = iter.getNext();

            RandomListNode copy = new RandomListNode(iter.getVal());
            iter.setNext(copy);
            copy.setNext(next);

            iter = next;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.getRandom() != null) {
                iter.getNext().setRandom(iter.getRandom().getNext());
            }
            iter = iter.getNext().getNext();
        }

        // Third round: restore the original list, and extract the copy list.
        iter = head;
        RandomListNode pseudoHead = new RandomListNode(0);
        RandomListNode copy, copyIter = pseudoHead;

        while (iter != null) {
            next = iter.getNext().getNext();

            // extract the copy
            copy = iter.getNext();
            copyIter.setNext(copy);
            copyIter = copy;

            // restore the original list
            iter.setNext(next);

            iter = next;
        }

        return pseudoHead.getNext();
    }

    public RandomListNode copyRandomListWithMap(RandomListNode head) {
        if (head == null) {
            return null;
        }

        final Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode cur = head;
        while(cur != null) {
            map.put(cur, new RandomListNode(cur.getVal()));
            cur = cur.getNext();
        }

        for (Map.Entry<RandomListNode, RandomListNode> entry : map.entrySet()) {
            final RandomListNode newNode = entry.getValue();
            newNode.setNext(map.get(entry.getKey().getNext()));
            newNode.setRandom(map.get(entry.getKey().getRandom()));
        }

        return map.get(head);
    }
}
