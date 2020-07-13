package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CountDistinctElementsInEveryWindow {

    private static List<Integer> findCountsOfElementsInEveryWindow(int arr[], int windowSize) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < windowSize; i++) {
            if (!counts.containsKey(arr[i])) {
                counts.put(arr[i], 1);
            } else {
                counts.put(arr[i], counts.get(arr[i]) + 1);
            }
        }
        numbers.add(counts.size());

        for (int i = windowSize; i < arr.length; i++) {
            if (counts.get(arr[i - windowSize]) == 1) {
                counts.remove(arr[i - windowSize]);
            } else {
                counts.put(arr[i - windowSize], counts.get(arr[i - windowSize]) - 1);
            }
            if (!counts.containsKey(arr[i])) {
                counts.put(arr[i], 1);
            } else {
                counts.put(arr[i], counts.get(arr[i]) + 1);
            }
            numbers.add(counts.size());
        }
        return numbers;
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 10, 10, 30, 40};
        System.out.println(Arrays.toString(a));
        System.out.println(findCountsOfElementsInEveryWindow(a, 4));
    }
}
