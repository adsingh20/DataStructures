package queue;

public class QueueCircularArray {

    int[] arr;
    int front;
    int capacity;
    int size;

    QueueCircularArray(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        this.front = 0;
        this.size = 0;
    }

    boolean isFull() {
        return (capacity == size);
    }

    boolean isEmpty() {
        return (size == 0);
    }

    int getFront() {
        if (isEmpty())
            return -1;
        else
            return this.front;
    }

    int getRear() {
        if (isEmpty())
            return -1;
        else
            return (this.front + this.size + 1) % this.capacity;
    }

    void enQueue(int x) {
        if (isFull())
            return;
        int rear = getRear();
        rear = (rear + 1) % this.capacity;
        size++;
    }

    void deQueue(int x) {
        if (isEmpty())
            return;
        this.front = (this.front + 1) % this.capacity;
        this.size--;
    }
}
