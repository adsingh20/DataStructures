package binaryheap;

import java.util.PriorityQueue;

public class SortKSortedArray {

    void sortKSortedArray(final int[] arr, final int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Adding to the queue takes O(klogk) time
        for (int i = 0; i <= k; i++) {
            priorityQueue.add(arr[i]);
        }

        int index = 0;

        // Adding to the queue takes O((n-1)logk) time
        for (int i = k + 1; i < arr.length; i++) {
            arr[index++] = priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }

        while (priorityQueue.isEmpty()) {
            arr[index++] = priorityQueue.poll();
        }
    }
}
