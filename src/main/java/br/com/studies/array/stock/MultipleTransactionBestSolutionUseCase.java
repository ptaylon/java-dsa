package br.com.studies.array.stock;


/**
 * Algorithm Complexity: O(n)
 * Space Complexity: O(1)
 */

public class MultipleTransactionBestSolutionUseCase implements FinancialOperation {

    @Override
    public int maximumProfit(final int[] prices) {

        int res = 0;

        // Keep on adding the difference between
        // adjacent when the prices a
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                res += prices[i] - prices[i - 1];
        }

        return res;

    }

}