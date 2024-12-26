package br.com.studies.array.stock;


/**
 * Algorithm complexity: O(n)
 * Space complexity: O(n + 2) -> O(n)
 */

public class MultipleTransactionAllowedUseCase implements FinancialOperation {

    @Override
    public int maximumProfit(int[] prices) {

        char[] operations = new char[prices.length];
        int operation = 0;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {

            analiseOperation(prices, i, operations);

            if (operations[i] == 'b') {
                operation -= prices[i];
            }

            if (operations[i] == 's') {
                operation += prices[i];
                profit += operation;
                operation = 0;
            }

        }

        return profit;

    }

    void analiseOperation(final int[] prices, final int i, final char[] operations) {
        
        int nextPrice = getNextPrice(prices, i);

        if (prices[i] < nextPrice) {
            operations[i] = buyOrHold(i, operations);
        }

        if (prices[i] >= nextPrice) {
            operations[i] = sellOrIgnore(i, prices, nextPrice, operations);
        }

        System.out.println("i: " + i + ", price: " + prices[i] +", operation: " + operations[i]);
        
    }

    int getNextPrice(final int[] prices, final int i) {
        return i + 1 > prices.length - 1 ? -1 : prices[i + 1];
    }

    char buyOrHold(int i, char[] operations) {

        char lastOperation = i - 1 < 0 ? 'i' : operations[i - 1];

        if (lastOperation == 'i' || lastOperation == 's') {
            return 'b';
        }

        return 'h';

    }

    char sellOrIgnore(int i, int[] prices, int nextPrice, char[] operations) {

        char response;

        if (i == 0 || operations[i - 1] == 's' || operations[i - 1] == 'i')
            response = 'i';
        else if (prices[i] == nextPrice && operations[i - 1] == 'h')
            response = 's';
        else
            response = 's';

        return response;

    }

}