package br.com.studies.array.stock.max;

import br.com.studies.array.stock.FinancialOperation;

/**
 * Algorithm Complexity: O(n)
 * Space Complexity: O(2) -> O(1)
 */

public class MaxOneTransactionUseCase implements FinancialOperation {

    @Override
    public int maximumProfit(final int[] prices) {

        int min = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < min)
                min = prices[i];

            if (prices[i] - min > maxProfit)
                maxProfit = prices[i] - min;

        }

        return maxProfit;

    }

}
