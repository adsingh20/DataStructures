package stacks;

import java.util.Stack;

public class PreviousGreaterElement {

    public void findPreviousGreaterElement(int arr[]) {
        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            while (stack.empty() == false && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            int previousHighest = stack.empty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

    }
}
