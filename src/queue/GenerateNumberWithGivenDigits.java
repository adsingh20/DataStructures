package queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class GenerateNumberWithGivenDigits {

    /**
     * Generate first number from number combination of number1 and number2
     * @param number1
     * @param number2
     * @param totalNumbers
     * @return
     */
    public ArrayList<Integer> generateFirstNNumbers(int number1, int number2, int totalNumbers) {
        Queue<String> queue = new ArrayDeque<>();

        ArrayList<Integer> generatedNumbers = new ArrayList<>();
        // Add 2
        queue.offer(String.valueOf(number1));
        // Add 3
        queue.offer(String.valueOf(number2));
        for (int i = 0; i < totalNumbers; i++) {
            // 2
            String current = queue.peek();
            // 2
            generatedNumbers.add(Integer.parseInt(current));
            // 2 is processed
            queue.remove();
            // 22 Added
            queue.offer(current.concat(String.valueOf(number1)));
            // 23 Added
            queue.offer(current.concat(String.valueOf(number2)));
        }

        return generatedNumbers;
    }
}
