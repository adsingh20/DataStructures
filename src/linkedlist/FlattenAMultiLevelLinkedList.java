package linkedlist;

import java.util.Stack;

public class FlattenAMultiLevelLinkedList {

    public Node flatten(Node head) {
        Node temp = head;
        Stack<Node> stk = new Stack<>();
        while (head != null) {
            if (head.child != null) {
                if (head.next != null) stk.push(head.next);
                head.next = head.child;
                head.next.prev = head;
                head.child = null;
            } else if (head.next == null && !stk.isEmpty()) {
                head.next = stk.pop();
                head.next.prev = head;
            }
            head = head.next;
        }

        return temp;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
