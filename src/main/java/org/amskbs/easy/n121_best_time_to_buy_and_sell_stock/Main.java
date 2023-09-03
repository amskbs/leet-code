package org.amskbs.easy.n121_best_time_to_buy_and_sell_stock;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        List<int[]> inputs = List.of(
                new int[]{7, 1, 5, 3, 6, 4},
                new int[]{7, 6, 4, 3, 1},
                new int[]{7, 6, 5, 4, 3, 2, 99, 100, 98}
        );

        for (int[] input : inputs) {
            System.out.println(main.maxProfit(input));
        }
    }

    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int currentProfit = 0;
        int minBuyPrice = prices[0];
        for (int price : prices) {
            minBuyPrice = Math.min(minBuyPrice, price);
            currentProfit = price - minBuyPrice;
            maxProfit = Math.max(maxProfit, currentProfit);
        }
        return maxProfit;
    }
}
