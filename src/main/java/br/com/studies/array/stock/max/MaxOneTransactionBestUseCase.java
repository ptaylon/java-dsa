package br.com.studies.array.stock.max;

import br.com.studies.array.stock.FinancialOperation;

/**
 * Algorithm Complexity: O(n)
 * Space Complexity: O(2) -> O(1)
 */

public class MaxOneTransactionBestUseCase implements FinancialOperation {

    @Override
    public int maximumProfit(final int[] prices) {

        int minSoFar = prices[0]; // O(1)
        int res = 0; // O(1)

        // Update the minimum value seen so far
        // if we see smaller
        for (int i = 1; i < prices.length; i++) { // O(n-1)
            minSoFar = Math.min(minSoFar, prices[i]);

            // Update result if we get more profit
            res = Math.max(res, prices[i] - minSoFar);
        }

        return res;

    }

}
