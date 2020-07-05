package arrays;

import java.util.Arrays;
import java.util.Random;

public class MaximumStockPrice {

    public static int findMaximumStockPriceNaive(int stockPrices[], int start, int end) {
        int profit = 0;
        int currentProfit;
        if (end <= start)
            return 0;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (stockPrices[i] < stockPrices[j]) {
                    currentProfit = stockPrices[j] - stockPrices[i] +
                            findMaximumStockPriceNaive(stockPrices, start, i-1) +
                            findMaximumStockPriceNaive(stockPrices, j+1, end);
                    profit = Math.max(profit, currentProfit);
                }
            }
        }
        return profit;
    }

    public static int findMaximumStockPriceOptimal(int stockPrices[], int n) {
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if(stockPrices[i-1] < stockPrices[i]) {
                profit += stockPrices[i]-stockPrices[i-1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int a[] = new int[5];
        int max = 10;
        for (int i = 0; i < 5; i++) {
            a[i] = new Random().nextInt(max);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(findMaximumStockPriceNaive(a, 0,4));
        System.out.println(findMaximumStockPriceOptimal(a, 5));
    }
}
