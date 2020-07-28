package queue;

import java.util.Deque;
import java.util.LinkedList;

public class PrintKMaxNumbersInSubArray {

    void printKMax(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> deque = new LinkedList<Integer>();

        for (int i = 0; i < k; i++) {
            // Only add element if they are small than the last peek because
            // we need to track of the highest number in the array
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        for (int i = k; i < n; i++) {
            System.out.println(arr[deque.peek()]);

            //Remove element which are not part of the window and they will be present
            // in the front
            while (!deque.isEmpty() && i - k <= arr[deque.peekLast()]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        System.out.println(arr[deque.peek()]);
    }
}
