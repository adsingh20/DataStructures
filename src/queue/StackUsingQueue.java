package queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();

    int currentSize;

    StackUsingQueue() {
        this.currentSize = 0;
    }

    void push(int x) {
        this.currentSize++;
        queue2.add(x);

        while(!queue1.isEmpty()) {
            queue2.add(queue1.peek());
            queue1.remove();
        }

        Queue<Integer> tempQueue = queue1;
        queue1 = queue2;
        queue2 = tempQueue;
    }
}
