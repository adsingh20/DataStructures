package queue;

import linkedlist.dto.SingleLinkedListNode;

public class QueueLinkedList {
    SingleLinkedListNode front;
    SingleLinkedListNode rear;
    int size;

    QueueLinkedList() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    void enqueue(int x) {
        SingleLinkedListNode temp = new SingleLinkedListNode(x);
        if (front == null) {
            front = temp;
            rear = temp;
            return;
        }
        this.rear.setNext(temp);
        this.rear = temp;
    }

    void dequeue() {
        if (front == null) {
            return;
        }
        SingleLinkedListNode temp = this.front;
        this.front = this.front.getNext();
        if (this.front == null) {
            this.rear = null;
        }
    }
}
