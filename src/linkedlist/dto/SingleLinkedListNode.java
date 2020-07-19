package linkedlist.dto;

public class SingleLinkedListNode {
    int data;
    SingleLinkedListNode next;

    public SingleLinkedListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SingleLinkedListNode getNext() {
        return next;
    }

    public void setNext(SingleLinkedListNode next) {
        this.next = next;
    }
}
