package stacks;

import java.util.Stack;

public class LargestRectangularArea {

    private int calculateLargestRectangularArea(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        final int length = arr.length;
        int top;
        int current;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                top = stack.pop();
                current = arr[top] * (stack.isEmpty() ? i :(i - stack.peek() - 1));
                result = Math.max(current, result);
            }
        }

        while (stack.isEmpty()) {
            top = stack.pop();
            current = arr[top] * (stack.isEmpty() ? length :(length - stack.peek() - 1));
            result = Math.max(current, result);
        }

        return result;
    }
}
