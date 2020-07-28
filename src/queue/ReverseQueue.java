package queue;

import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        while(!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        while(!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
    }

    void reverseRecursively(Queue<Integer> queue) {

        if(queue.isEmpty()) {
            return;
        }

        int x = queue.peek();
        queue.remove();
        reverse(queue);

        queue.offer(x);
    }
}
