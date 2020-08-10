package binaryheap.dto;

import util.MathUtil;

public class MinHeap {

    int[] arr;
    int size;
    int capacity;

    MinHeap(int capacity) {
        arr = new int[capacity];
        size = 0;
        this.capacity = capacity;
    }

    public int getLeft(int i) {
        return arr[2 * i + 1];
    }

    public int getRight(int i) {
        return arr[2 * i + 2];
    }

    public int getParent(int i) {
        return arr[(i - 1) / 2];
    }

    public int getLeftIndex(int i) {
        return 2 * i + 1;
    }

    public int getRightIndex(int i) {
        return 2 * i + 2;
    }

    public int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    /**
     * Time Compexity O(log (h))
     *
     * @param item Item to be inserted
     */
    public void insert(int item) {
        if (size == capacity) {
            return;
        }

        size++;
        arr[size - 1] = item;

        for (int i = size - 1; i != 0 && getParent(i) > arr[i]; ) {
            MathUtil.swap(arr, i, getParentIndex(i));
            i = getParentIndex(i);
        }
    }

    /**
     * Fix the binary heap which might have one single violation
     * Time Complexity Best Case O(1), Worst Case theta(height) => O(height) = O(logh)
     * Auxiliary Space O(h)
     *
     * @param rootIndex Index of the root which is being checked for violation
     */
    public void minHeapify(int rootIndex) {
        final int leftChildIndex = getLeftIndex(rootIndex);
        final int rightChildIndex = getRightIndex(rootIndex);
        int smallestIndex = rootIndex;
        if (leftChildIndex < size && arr[leftChildIndex] < arr[rootIndex]) {
            smallestIndex = leftChildIndex;
        }
        if (rightChildIndex < size && arr[rightChildIndex] < arr[rootIndex]) {
            smallestIndex = leftChildIndex;
        }
        if (smallestIndex != rootIndex) {
            MathUtil.swap(arr, rootIndex, smallestIndex);
            minHeapify(smallestIndex);
        }
    }

    /**
     * Remove minimum element from heap
     * Time Complexity - O(height) => O(log n)
     *
     * @return Mimumum Element from heap
     */
    public int extractMinimum() {
        if (size == 0) {
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            size--;
            return arr[0];
        }

        MathUtil.swap(arr, 0, size - 1);
        size--;
        minHeapify(0);
        return arr[size];
    }

    /**
     * Update Key Value
     *
     * @param index Index to be updated
     * @param item  Value to be updated
     */
    public void decreaseKey(int index, int item) {
        arr[index] = item;

        while (index != 0 && getParent(index) > arr[index]) {
            MathUtil.swap(arr, index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    /**
     * Delete the key at the given index
     *
     * @param index Index from which element has to be deleted
     */
    public void deleteKey(int index) {
        decreaseKey(index, Integer.MIN_VALUE);
        extractMinimum();
    }

    /**
     * Converts random array into a min heap
     * Starts with last internal node and calls minheapify for all nodes
     * @param arr
     */
    public void buildHeap(int[] arr) {
        int size = arr.length;

        for (int i = getParentIndex(size); i >= 0; i--) {
            minHeapify(i);
        }
    }
}
