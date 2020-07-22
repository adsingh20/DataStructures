package stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextGreaterELement {

    public void findNextGreaterELement(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> greaterElement = new ArrayList<>();
        final int length = arr.length;
        stack.push(arr[length - 1]);

        for (int i = length - 2; i >= 0; i--) {
            while (stack.empty() == false && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            int nextGreater = stack.empty() ? -1 : stack.peek();
            greaterElement.add(nextGreater);
            stack.push(arr[i]);
        }
        Collections.reverse(greaterElement);
    }
}
