package binaryheap;

import java.util.PriorityQueue;

public class KLargestElements {

    /**
     * Uses min heap to print largest k elements
     * Time Complexity O(k + (n-k)*logk)
     * @param arr
     * @param k Number of Largest to be prinyed
     */
    void printKLargestElementsEfficient(int[] arr, int k) {
        PriorityQueue<Integer> largestKElements = new PriorityQueue<>();

        // Time Complexity O(k)
        for (int i = 0; i < k; i++) {
            largestKElements.add(arr[i]);
        }

        int index = k;

        // Time Complexity O((n-k)*logk)
        while (index < arr.length) {
            if (largestKElements.peek() < arr[index]) {
                largestKElements.poll();
                largestKElements.add(arr[index]);
            }
        }

        System.out.println(largestKElements);
    }
}
