package arrays;

import java.util.*;
import java.util.stream.Collectors;

public class TrappingRainWater {

    public static int findTrappedRainWaterBruteForce(int brickLength[], int arraySize) {
        int totalWaterTrapped = 0;

        for (int i = 1; i < arraySize - 1; i++) {

            int leftMax = brickLength[i];
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, brickLength[j]);
            }

            int rightMax = brickLength[i];
            for (int k = i + 1; k < arraySize; k++) {
                rightMax = Math.max(rightMax, brickLength[k]);
            }

            totalWaterTrapped = totalWaterTrapped + (Math.min(leftMax, rightMax) - brickLength[i]);
        }

        return totalWaterTrapped;
    }

    public static int findTrappedRainWaterWithPrecomputedArray(int brickLength[], int arraySize) {
        int totalWaterTrapped = 0;

        int leftMax[] = new int[arraySize];
        leftMax[0] = brickLength[0];
        for (int i = 1; i < arraySize; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], brickLength[i]);
        }

        int rightMax[] = new int[arraySize];
        rightMax[arraySize-1] = brickLength[arraySize-1];
        for (int j = arraySize - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], brickLength[j]);
        }


        for (int i = 1; i < arraySize - 1; i++) {
            totalWaterTrapped = totalWaterTrapped + (Math.min(leftMax[i], rightMax[i]) - brickLength[i]);
        }

        return totalWaterTrapped;
    }

    public static int findTrappedRainWaterWithStack(List<Integer> brickLength) {
        int totalWaterTrapped = 0;
        int current = 0;
        Stack<Integer> stack = new Stack<>();

        while (current < brickLength.size()) {
            while (!stack.empty() && brickLength.get(current) > brickLength.get(stack.peek())) {
                int top = stack.peek();
                stack.pop();
                if (stack.empty())
                    break;
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(brickLength.get(current), brickLength.get(stack.peek())) - brickLength.get(top);
                totalWaterTrapped += distance * bounded_height;
            }
            stack.push(current++);
        }

        return totalWaterTrapped;
    }


    public static void main(String[] args) {
        int a[] = new int[5];
        List<Integer> list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            a[i] = new Random().nextInt(5);
            list.add(a[i]);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(findTrappedRainWaterBruteForce(a, 5));
        System.out.println(findTrappedRainWaterWithPrecomputedArray(a, 5));
        System.out.println(findTrappedRainWaterWithStack(list));
    }
}
