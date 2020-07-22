package stacks;

import java.util.Stack;

public class StockSpan {

    public void findStockSpan(int[] stocks) {
        Stack<Integer> stockStack = new Stack<>();

        stockStack.push(0);

        for (int i = 1; i < stocks.length; i++) {
            while (stockStack.empty() == false && stocks[stockStack.peek()] <= stocks[i]) {
                stockStack.pop();
            }
            int span = stockStack.empty() ? i + 1 : i - stockStack.peek();
            stockStack.push(i);
        }
    }
}
