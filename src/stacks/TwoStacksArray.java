package stacks;

public class TwoStacksArray {

    int[] array;
    int cap;
    int top1;
    int top2;

    public TwoStacksArray(int n) {
        this.cap = n;
        this.top1 = -1;
        this.top2 = this.cap;
        this.array = new int[n];
    }

    void push1(int x) {
        if (this.top1 < this.top2 - 1) {
            this.top1++;
            array[top1] = x;
        }
    }

    void push2(int x) {
        if (this.top1 < this.top2 - 1) {
            this.top2--;
            array[top2] = x;
        }
    }

    int pop1() {
        if (this.top1 >= 0) {
            int x = this.array[top1];
            this.top1--;
            return x;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    int pop2() {
        if (this.top1 < this.cap) {
            int x = this.array[top2];
            this.top1++;
            return x;
        } else {
            return Integer.MIN_VALUE;
        }
    }
}
