package linkedlist.dto;

public class RandomListNode {
    int val;
    RandomListNode next;
    RandomListNode random;

    public RandomListNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public RandomListNode getNext() {
        return next;
    }

    public void setNext(RandomListNode next) {
        this.next = next;
    }

    public RandomListNode getRandom() {
        return random;
    }

    public void setRandom(RandomListNode random) {
        this.random = random;
    }
}
