package binaryheap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfAStream {

    public void findMedian(int[] arr) {
        PriorityQueue<Integer> largerHeap = new PriorityQueue<>();
        PriorityQueue<Integer> smallerHeap = new PriorityQueue<>(Comparator.reverseOrder());

        smallerHeap.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int element = arr[i];

            if (smallerHeap.size() > largerHeap.size())  {
                if (smallerHeap.peek() > element) {
                    largerHeap.add(smallerHeap.poll());
                    smallerHeap.add(element);
                } else {
                    largerHeap.add(element);
                }
                System.out.println((smallerHeap.peek() + largerHeap.peek()) / 2);
            } else {
                if (smallerHeap.peek() <= element) {
                    smallerHeap.add(element);
                } else {
                    largerHeap.add(element);
                    smallerHeap.add(largerHeap.poll());
                }
                System.out.println(smallerHeap.peek());
            }
        }
    }
}
