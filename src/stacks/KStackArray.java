package stacks;

import java.util.Arrays;

public class KStackArray {

    int[] array;
    int[] top;
    int[] next;
    int k;
    int freeTop;
    int capacity;

    public KStackArray(int numberOfStacks, int capacity) {
        this.k = numberOfStacks;
        this.capacity = capacity;
        this.array = new int[capacity];
        this.top = new int[numberOfStacks];
        this.next = new int[capacity];
        Arrays.fill(this.top, -1);

        for (int i = 0; i < this.capacity - 1; i++) {
            this.next[i] = i + 1;
        }
        this.next[this.capacity - 1] = -1;
    }

    public void push(int x, int stack) {
        int i  = freeTop;
        freeTop = next[i];
        next[i] = top[stack];
        top[stack] = i;
        array[i] = x;
    }

    public int pop(int stack) {
        int i = top[stack];
        top[stack] = next[i];
        next[i] = freeTop;
        freeTop = next[i];
        return array[i];

    }
}
