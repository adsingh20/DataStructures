package queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class GenerateNumberWithGivenDigits {

    ArrayList<Integer> generateFirstNNumbers(int number1, int number2, int totalNumbers) {
        Queue<String> queue = new ArrayDeque<>();

        ArrayList<Integer> generatedNumbers = new ArrayList<>();
        queue.offer(String.valueOf(number1));
        queue.offer(String.valueOf(number2));
        for (int i = 0; i < totalNumbers; i++) {
            String current = queue.peek();
            assert current != null;
            generatedNumbers.add(Integer.parseInt(current));
            queue.remove();
            queue.offer(current.concat(String.valueOf(number1)));
            queue.offer(current.concat(String.valueOf(number2)));
        }

        return generatedNumbers;
    }
}
