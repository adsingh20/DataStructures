package stacks;

import java.util.Stack;

public class StockSpan {

    public void findStockSpan(int[] stocks, int[] span) {
        Stack<Integer> stockStack = new Stack<>();

        stockStack.push(0);

        for (int i = 1; i < stocks.length; i++) {
            // Pop elements from stack while stack is not
            // empty and top of stack is smaller than
            // price[i]
            while (!stockStack.empty() && stocks[stockStack.peek()] <= stocks[i]) {
                stockStack.pop();
            }
            // If stack becomes empty, then price[i] is
            // greater than all elements on left of it, i.e.,
            // price[0], price[1], ..price[i-1]. Else price[i]
            // is greater than elements after top of stack
            span[i] = stockStack.empty() ? i + 1 : i - stockStack.peek();

            // Push this element to stack
            stockStack.push(i);
        }
    }
}
